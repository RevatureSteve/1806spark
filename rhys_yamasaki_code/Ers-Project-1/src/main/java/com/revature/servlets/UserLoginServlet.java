package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.revature.pojo.User;
import com.revature.service.UserService;

public class UserLoginServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private UserService managerService = new UserService();
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		System.out.println("This is requesting user login");
		handleRequest(req, resp);
	}
	
	protected void handleRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		
		User user = new User();
		
		ObjectMapper mapper = new ObjectMapper();
		ServletInputStream data = req.getInputStream();
		ObjectNode n = mapper.readValue(data, ObjectNode.class);
		
		String email = null;
		String password = null;
		if(n.has("email")) {
			email = n.get("email").textValue();
		}
		if (n.has("password")) {
			password = n.get("password").textValue();
		}
		
		System.out.println(email);
		System.out.println(password);
		
		user = managerService.validateManagerLogin(email, password);
//		if(user != null) {
//			HttpSession session = request.getSession();
//			
//			session.setAttribute("user", user);
//			
//			request.getRequestDispatcher("app.html").forward(request, response);
//		}
		
				
		String json = mapper.writeValueAsString(user);
		
		resp.setContentType("application/json");
		resp.getWriter().write(json);
	}
}
