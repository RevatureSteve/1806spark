package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.revature.domain.Users;
import com.revature.service.UsersBusinessLogic;

/**
 * Servlet implementation class Login
 */
@JsonPropertyOrder({ "uId", "email", "password", "fname", "lname", "posId", "posType" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		
		
		System.out.println("logging on");
		
		ObjectMapper mapper = new ObjectMapper();
		ServletInputStream json = request.getInputStream();
		ObjectNode node = mapper.readValue(json, ObjectNode.class);
		
		String email = null;
		String password = null;
		
		if(node.has("email")) {
			email = node.get("email").textValue();
		}
		if(node.has("password")) {
			password = node.get("password").textValue();
		}
		
		System.out.println(email + password);
		
		Users user = new UsersBusinessLogic().login(email, password);
		
		System.out.println(user);
		
		
		
		  		if (user != null) {
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				
				response.setHeader("Content-Type", "application/json");
				response.getWriter().write(mapper.writeValueAsString(user));
			} else {
				response.setStatus(401);
				response.getWriter().write("");
			}
		
	}}
		









