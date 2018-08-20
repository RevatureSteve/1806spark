package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pogo.Users;
import com.revature.service.AppService;

/**
 * Servlet implementation class UserInformationByEmail
 * @author Alex Moraga
 *
 */
public class UserInformationByEmail extends HttpServlet {
	/*
	 * URL: /user/email
	 */
	
	// Creating new object to grab AppService's methods
	private AppService aS = new AppService();

	public UserInformationByEmail() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("UserInformationByEmail -GET");
		
		String email = request.getParameter("email");
		System.out.println("The user's email is " + email);
		
		// Retrieved user's info from AppService as usersInfo
		Users usersInfo = aS.getUserByEmail(email);
		
		// Convert to JSON
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(usersInfo);
		
		// Setting response type as applicaton/json
		response.setContentType("application/json");
		// To write as json
		response.getWriter().write(json);
	}
}
