package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
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
		Users currentUser = new Users();

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		

//		currentUser.setEmail(email);
//		currentUser.setPassword(password);

		currentUser = new UserBuisnessLogic().login(email, password);

		System.out.println("email: " + email + " password: " + password);

//		if (currentUser != null) {
//			// this is a cookie
//			HttpSession session = request.getSession();
//			session.setAttribute("user", currentUser);
//			System.out.println(currentUser);
////			request.getRequestDispatcher("http://localhost:4200/profile").forward(request, response);
//		} else {
////			response.sendRedirect("http://localhost:4200/login");
//		}
		
		ObjectMapper mapper = new ObjectMapper();
		
		String json = mapper.writeValueAsString(currentUser);
		
		response.setContentType("application/json");
		response.getWriter().write(json);
		
	}

}
