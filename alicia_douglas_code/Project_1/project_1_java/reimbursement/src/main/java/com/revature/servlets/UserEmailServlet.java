package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.domain.Users;
import com.revature.service.UserBuisnessLogic;

/**
 * Servlet implementation class UserEmailServlet
 */
public class UserEmailServlet extends HttpServlet {
	
	
	/*
	 * url - /users/email
	 */
	
	private static final long serialVersionUID = 1L;
	private UserBuisnessLogic userBL = new UserBuisnessLogic();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("userEmail");
		Users user = userBL.getUserByEmail(email);
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(user);
		response.setContentType("application/json");
		
		PrintWriter out = response.getWriter();
		out.print(json);
	}

	

}
