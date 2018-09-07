package com.drake.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.drake.domain.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {

	/*
	 * url - /login
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Login Servlet - POST");
		User currentUser = null;

		String email;
		String password;
		ObjectMapper mapper = new ObjectMapper();
		ServletInputStream data = request.getInputStream();
		ObjectNode node = mapper.readValue(data, ObjectNode.class);
		
		email = node.get("email").textValue();
		password = node.get("pass_word").textValue();

		currentUser = new UserServlet().login(email, password);

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
		
		
	}

}