package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.domain.Reimbursement;
import com.revature.domain.Users;
import com.revature.service.BusinessLogic;

public class UserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private BusinessLogic businessLogic = new BusinessLogic();

	/*
	 * This servlet is used for getting all users
	 * URL endpoint is /allUsers
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		System.out.println("UserServlet - GET");
		
		List<Users> users = businessLogic.getAllUsers();

		//converting object to JSON format
		ObjectMapper mapper = new ObjectMapper();

		//Here is the JSON format of our task list
		String json = mapper.writeValueAsString(users);

		//lets the client know what type of text we sent back (i.e JSON)
		resp.setContentType("application/json");

		//here we format the object into a text output stream
		PrintWriter out = resp.getWriter();
		out.println(json);

	}

}
