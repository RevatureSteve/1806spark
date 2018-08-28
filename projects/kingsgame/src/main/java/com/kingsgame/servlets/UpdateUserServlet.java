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

public class UpdateUserServlet extends HttpServlet{
	private Dao dao = new Dao();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int uid = 0; String em = null; int postypeid = 0;
		System.out.println("hit");
		ObjectMapper mapper = new ObjectMapper();
		ServletInputStream data = req.getInputStream();
		ObjectNode n = mapper.readValue(data, ObjectNode.class);
		
		if(n.has("u_id")) {
			uid = n.get("u_id").asInt();
			System.out.println("u_id"+uid);
			if(n.has("email")) {
				em = n.get("email").asText();
				System.out.println("email"+em);
			};
			if(n.has("pos_id")) {
				postypeid = n.get("pos_id").asInt();
				System.out.println("pos_id"+postypeid);
			};
			if(uid != 0) {
				dao.updateUser(uid, em, postypeid);
				System.out.println("Confirmation of Update for: " + uid + " " + em + " " + postypeid);
			}
		};
		
		
	}
}
