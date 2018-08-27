package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pogo.Users;
import com.revature.service.AppService;

/**
 * Servlet implementation class GetAllUsersServlet
 * 
 * @author Alex Moraga
 *
 */

public class GetAllUsersServlet extends HttpServlet {
	
	/*
	 * URL: /user/getAll
	 */
	
	// Creating new object to grab AppService's methods
	private AppService aS = new AppService();

	public GetAllUsersServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("UserInformationByEmail -GET");
		
		List<Users> users = aS.getAllUsers();
		
		// Convert to JSON
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(users);
		
		// Setting response type as applicaton/json
		response.setContentType("application/json");
		// To write as json
		PrintWriter out = response.getWriter();
		out.print(json);	
		}
}
