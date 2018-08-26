package com.kingsgame.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.kingsgame.dao.Dao;

public class UpdateServlet extends HttpServlet{
	private Dao dao = new Dao();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int rid = 0; int mgrid = 0; int rqstatusid = 0;
		System.out.println("hit");
		ObjectMapper mapper = new ObjectMapper();
		ServletInputStream data = req.getInputStream();
		ObjectNode n = mapper.readValue(data, ObjectNode.class);
		
		if(n.has("r_id")) {
			rid = n.get("r_id").asInt();
			System.out.println("r_id"+rid);
			if(n.has("mgr_u_id")) {
				mgrid = n.get("mgr_u_id").asInt();
				System.out.println("mgr_u_id"+mgrid);
			};
			if(n.has("rq_status_id")) {
				rqstatusid = n.get("rq_status_id").asInt();
				System.out.println("rq_status_id"+rqstatusid);
			};
			if(rid != 0) {
				dao.updateReimbursement(rid, mgrid, rqstatusid);
				System.out.println("Confirmation of Update for: " + rid + " " + mgrid + " " + rqstatusid);
			}
		};
		
		
	}
}
