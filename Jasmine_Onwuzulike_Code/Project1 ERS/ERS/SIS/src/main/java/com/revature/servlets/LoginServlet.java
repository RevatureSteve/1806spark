package com.revature.servlets;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojos.Users;
import com.revature.service.Service;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private Service ss = new Service();
 
    public LoginServlet() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String email = request.getParameter("email");
//		String password = request.getParameter("password");
//		Users test = ss.login(email, password);
//		if (test != null) {
//		System.out.println("Success!");
//		System.out.println(test);
//		}else {
//		System.out.println("Failed");
//		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Login---POST");
		Users usr = new Users();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		usr.setEmail(email);
		usr.setPassword(password);
		System.out.println("Starting login service");
		usr = ss.login(usr.getEmail(), usr.getPassword());
		if (usr != null) {
			System.out.println("Success!");
			System.out.println("User: " + usr);
			ObjectMapper map = new ObjectMapper();
			String s = map.writeValueAsString(usr);
			response.setContentType("application/json");
			System.out.println("Writing...");
			response.getWriter().write(s);
		}
		else {
			System.out.println("Failed");
		}
}

}
