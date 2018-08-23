package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.Pojo.Users;
import com.revature.service.AppService;

public class GetUserByEmailServlet extends HttpServlet{
	
	
	private AppService appService = new AppService();
	
	
	protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		System.out.println("Email -GET");
		
		String email = req.getParameter("email");
		System.out.println("User email " + email);
		
		String password = req.getParameter("password");
		
		Users us =appService.getUserByEmail(email, password);
		
		
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(us);
		
		resp.setContentType("application/json");
		resp.getWriter().write(json);
	}

}
