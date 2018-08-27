package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pogo.Users;
import com.revature.service.AppService;

/**
 * Servlet implementation class UpdateUserServlet
 * 
 * @author Alex Moraga
 *
 */
public class UpdateUserServlet extends HttpServlet {
	/*
	 * url - /user/update
	 */
	
	private AppService aS = new AppService();

	public UpdateUserServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("UpdateUserServlet -POST"); 
		ObjectMapper mapper = new ObjectMapper();
		// Reads the json that's being sent through the POST request
		ServletInputStream json = request.getInputStream();
		Users user = mapper.readValue(json, Users.class);

		System.out.println("User updating information: " + user);
		
		String email = user.getEmail();
		String password = user.getPassword();
		String fname = user.getFname();
		String lname = user.getLname();
		int u_Id = user.getU_Id();
		System.out.println(email + ""+ password + "" + fname + "" + lname + "" + u_Id);
		int success = aS.updateUser(email, password, fname, lname, u_Id);
		PrintWriter out = response.getWriter();
		out.print(1);
	}
}
