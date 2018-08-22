package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.revature.dao.UserDaoImpl;
import com.revature.domain.User;


public class LoginServlet extends HttpServlet{
	private UserDaoImpl dao = new UserDaoImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = new User();
		ObjectMapper mapper = new ObjectMapper();
		ServletInputStream data = req.getInputStream();
		ObjectNode n = mapper.readValue(data,ObjectNode.class);
		String email = null;
		String password = null;
		if (n.has("email")) {
			email = n.get("email").textValue();
		}if (n.has("password")) {
			password = n.get("password").textValue();
		}if (email != null && password !=null) {
			user = dao.getUserbyEmail(email, password);
			
		String json = mapper.writeValueAsString(user);
		resp.setContentType("application/json");
		resp.getWriter().write(json);
		System.out.println(json);
		}
	}
	
};
