package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.revature.Pojo.Users;
import com.revature.service.AppService;

public class GetUserByEmailServlet extends HttpServlet{
	
	
	private AppService appService = new AppService();
	
	
	protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		System.out.println("Email -Post");
		
		String email = null;
		String password = null;
		
		System.out.println("Login -POST");
		
		
		Users us = new Users();
		System.out.println(us);
		
		ObjectMapper mapper = new ObjectMapper();
		
		ServletInputStream body = req.getInputStream();
		ObjectNode on = mapper.readValue(body, ObjectNode.class);
		
		
		if(on.has("email")) {
			email = on.get("email").textValue();
		}
		
		if(on.has("password")) {
			password = on.get("password").textValue();
		}
		
		
		System.out.println(email + "" + password);
		us = new AppService().getUserByEmail(email, password);
		
		String json = mapper.writeValueAsString(us);
		
		resp.setContentType("application/json");
		resp.getWriter().write(json);
	}

}
