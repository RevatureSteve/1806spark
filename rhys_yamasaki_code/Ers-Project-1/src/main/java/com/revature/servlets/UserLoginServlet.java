package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojo.User;
import com.revature.service.LoginService;

public class UserLoginServlet extends HttpServlet{

	
	private LoginService managerService = new LoginService();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		System.out.println("This is getting managers");
		User user = new User();
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
	
		System.out.println(email);
		System.out.println(password);
		
		user = managerService.validateManagerLogin(email, password);
//		if(user != null) {
//			// this is a cookie!
//			// HttpSession holds a J-SESSION-ID cookie (BADDDDDDDDD!!!)
//			HttpSession session = request.getSession();
//			
//			session.setAttribute("user", user);
//			
//			request.getRequestDispatcher("app.html").forward(request, response);
//		}
		
		
		ObjectMapper mapper = new ObjectMapper();
		
		
		String json = mapper.writeValueAsString(user);
		
		response.setContentType("application/json");
		response.getWriter().write(json);
	}
}
