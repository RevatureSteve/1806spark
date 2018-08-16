package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.domain.Users;
import com.revature.service.UserBuisnessLogic;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
	
	/*
	 * url - /users
	 */
	
	private static final long serialVersionUID = 1L;
	private UserBuisnessLogic userBL = new UserBuisnessLogic();
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Users> users = userBL.getAllUsers();
		ObjectMapper mapper = new ObjectMapper();
		
		String json = mapper.writeValueAsString(users);
		response.setContentType("application/json");
		
		PrintWriter out = response.getWriter();
		out.print(json);
	}



}
