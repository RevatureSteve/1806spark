package com.drake.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.drake.domain.User;
import com.drake.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class UserServlet extends HttpServlet {

	/*
	 * url - /users
	 */
	
	private static final long serialVersionUID = 1L;
	private UserService userBL = new UserService();
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> users = userBL.getAllUsers();
		ObjectMapper mapper = new ObjectMapper();
		
		String json = mapper.writeValueAsString(users);
		response.setContentType("application/json");
		
		PrintWriter out = response.getWriter();
		out.print(json);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("User post");
		
		ObjectMapper mapper = new ObjectMapper();
		ServletInputStream data = req.getInputStream();
		ObjectNode node = mapper.readValue(data, ObjectNode.class);
		
		User user = new User(node.get("email").textValue(), node.get("password").textValue(), node.get("fname").textValue(), node.get("lname").textValue(), Integer.parseInt(node.get("pos_id").textValue()));
		
		userBL.createNewUser(user);
		
	}
	
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("hit post /users");
		
		int u_id;
		String email;
		String fname;
		String lname;
		
		ObjectMapper mapper = new ObjectMapper();
		ServletInputStream data = req.getInputStream();
		ObjectNode node = mapper.readValue(data, ObjectNode.class);
		
		u_id = node.get("u_id").intValue();
		email = node.get("email").textValue();
		fname = node.get("fname").textValue();
		lname = node.get("lname").textValue();
		
		User user = new User(u_id, email, fname, lname);
		System.out.println(user);
		
		User updatedUser = userBL.updateUser(user);
		
		System.out.println("after update -- servlet");
		
		String json = mapper.writeValueAsString(updatedUser);
		resp.setContentType("application/json");
		PrintWriter out = resp.getWriter();
		out.print(json);
		
		System.out.println("After print to json --servlet");
	}
	
}