package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.revature.service.UserService;

/**
 * /employee/update
 */
public class UpdateEmployeeInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	private UserService us= new UserService();
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		System.out.println("Updating employee info");
		
		ObjectMapper mapper = new ObjectMapper();
		ServletInputStream data = request.getInputStream();
		ObjectNode n = mapper.readValue(data, ObjectNode.class);
		
		int userId = 0;
		String email = null;
		String password = null;
		String fname = null;
		String lname = null;
		
		us.updateEmployeeInfo(userId, email, password, fname, lname);		
		
		
	}

}
