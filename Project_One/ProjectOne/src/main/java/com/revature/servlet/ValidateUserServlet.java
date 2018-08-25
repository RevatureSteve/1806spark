package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.revature.pogo.Users;
import com.revature.service.AppService;

/**
 * Servlet implementation class ValidateUserServlet
 * 
 * @author Alex Moraga
 *
 */
public class ValidateUserServlet extends HttpServlet{
	/*
	 * url - /reimbursement/c
	 */
	
	private AppService aS = new AppService();
	
	
	public ValidateUserServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("ValidateServlet -POST");
 
		ObjectMapper mapper = new ObjectMapper();
		// Reads the json that's being sent through the POST request
		ServletInputStream json = request.getInputStream();
		// Setting a json object that has been received as an ObjectNod
		ObjectNode node = mapper.readValue(json, ObjectNode.class);

		// Setting email & password as the text values stored within ObjectNode.class
		String email = node.get("email").textValue();
		String password = node.get("password").textValue();
		
		System.out.println("email: " + email + " , password: " + password);
		
		// Passing email/password for verification through the login app service
		// & setting it as verified if user is valid
		Users verified = aS.login(email, password);
		System.out.println("User is valid " + verified);
		// Printing out the verified user through mapper and 
		// & setting it as jsonOut
		String jsonOut = mapper.writeValueAsString(verified);
		
		// Note: printwriter is not a JSON String, just a misc toString code
		PrintWriter out = response.getWriter();
		System.out.println("Json object is now send back to the front end:  " + jsonOut);
		// Setting the response content type as application/json
		response.setContentType("application/json");
		out.print(jsonOut);
}
	

}
