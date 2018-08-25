package com.kingsgame.servlets;

import java.io.File;
import java.io.IOException;
import java.sql.Blob;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.kingsgame.dao.Dao;

public class NewReServlet extends HttpServlet{

	Dao dao = new Dao();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int r = 0;
		ObjectMapper mapper = new ObjectMapper();
		ServletInputStream data = req.getInputStream();
		ObjectNode n = mapper.readValue(data,ObjectNode.class);
		int emp_u_id = 0;
		Double amt = 0.0;
		String description = null;
	//	Blob imgpath = null;
		int rq_type_id = 0;
		if(n.has("emp_u_id")) {
			
			emp_u_id = n.get("emp_u_id").asInt();
		};
		if(n.has("amt")) {
			amt = n.get("amt").asDouble();
		};
		if(n.has("description")) {
			description = n.get("description").asText();
		};
	//	if(n.has("	")) {
	//		if((n.get("img").equals(""))){
	//			imgpath = null;
	//		}else {
	//		imgpath = (Blob) n.get("img");
	//		}
	//	};
		if(n.has("rq_type_id")) {
			rq_type_id = n.get("rq_type_id").asInt();
		};
		System.out.println(emp_u_id+"sad"+amt+"sad"+description+
	//			imgpath
				+rq_type_id);
		if(emp_u_id != 0 && amt != 0) {
			r = dao.createReimbursement(emp_u_id, amt, description, 
					//imgpath, 
					rq_type_id);
		
		
		
		String json = mapper.writeValueAsString(r);
		
		resp.setContentType("application/json");
		
		resp.getWriter().write(json);	
		System.out.println(json);
		}
		}
	
}
