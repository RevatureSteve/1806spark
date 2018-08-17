package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojo.User;
import com.revature.service.ManagerService;

public class ManagersServlet extends HttpServlet{

	
	private ManagerService managerService = new ManagerService();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		System.out.println("This is getting managers");
		
		User user = managerService.getManagerByEmail("rhys@gmail.com");
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(user);
		
		resp.setContentType("application/json");
		resp.getWriter().write(json);
	}
}
