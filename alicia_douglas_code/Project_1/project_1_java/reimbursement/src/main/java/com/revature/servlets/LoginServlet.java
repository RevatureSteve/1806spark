package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.revature.domain.Users;
import com.revature.service.UserBuisnessLogic;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {

	/*
	 * url - /login
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Login Servlet - GET");
//		request.getRequestDispatcher("http://localhost:4200/login").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Login Servlet - POST");
		Users currentUser = null;

		String email;
		String password;
		ObjectMapper mapper = new ObjectMapper();
		ServletInputStream data = request.getInputStream();
		ObjectNode node = mapper.readValue(data, ObjectNode.class);
		
		email = node.get("email").textValue();
		password = node.get("password").textValue();

//		currentUser.setEmail(email);
//		currentUser.setPassword(password);

		currentUser = new UserBuisnessLogic().login(email, password);

		System.out.println("email: " + email + " password: " + password);

		if (currentUser != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", currentUser);
			
			response.setHeader("Content-Type", "application/json");
			response.getWriter().write(mapper.writeValueAsString(currentUser));
		} else {
			response.setStatus(401);
			response.getWriter().write("");
		}
		
		
		
//		String json = mapper.writeValueAsString(currentUser);
//		
//		response.setContentType("application/json");
//		response.getWriter().write(json);
		
	}

}
