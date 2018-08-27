package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.revature.service.ReimbursementService;

/**
 *  url - /employee/reimbursement/submit
 */
public class CreateReimbursementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ReimbursementService rs = new ReimbursementService();  
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Creating new reimbursement request");
		
		ObjectMapper mapper = new ObjectMapper();
		ServletInputStream data = request.getInputStream();
		ObjectNode n = mapper.readValue(data, ObjectNode.class);
		
		int user_id = 0;
		double amount = 0;
		String description = null;
		byte[] img = null;
		int type_id = 0;
		
		user_id = n.get("user_id").asInt();
		amount = n.get("amount").asDouble();
		description = n.get("description").textValue();
		if (n.has("image")) {
		img = n.get("image").binaryValue();
		}
		type_id = n.get("type_id").asInt();
		
		rs.createReimbursement(user_id, amount, description, img, type_id);
		
	}

}
