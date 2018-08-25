package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pogo.Reimbursement;
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
	
//	@Override
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		System.out.println("ValidateServlet -POST");
// 
//		ObjectMapper mapper = new ObjectMapper();
//		// Reads the json that's being sent through the POST request
//		ServletInputStream json = request.getInputStream();
//		Users u = mapper.readValue(json, Users.class);
//
//		System.out.println("User reimbursement information: " + reimb);
//		
//		String email = u.getEmail()
//		String password = u.getPassword()
//		System.out.println(email + ""+ password);
//		int success = aS.login(email + )
//		PrintWriter out = response.getWriter();
//		out.print(1);
//	}

}
