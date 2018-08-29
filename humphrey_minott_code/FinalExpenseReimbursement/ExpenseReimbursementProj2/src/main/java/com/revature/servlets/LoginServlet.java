package com.revature.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.domain.User;
import com.revature.service.ServiceMethods;


public class LoginServlet extends HttpServlet {
	
	ServiceMethods service = new ServiceMethods();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LoginServlet -POST");
		
		  BufferedReader bufferedReader = request.getReader();
		  
		  ObjectMapper mapper = new ObjectMapper();
		  User validate = mapper.readValue(bufferedReader,User.class);
		  User dbUser = service.validateUser(validate.getEmail(), validate.getPassword());
		  
			if(dbUser != null){
				// this is a cookie!
				// HttpSession holds a J-SESSION-ID cookie (BADDDDDD!!!!)
//				HttpSession session = request.getSession(); 
				
//				session.setAttribute("user", dbUser);
				System.out.println("Sending user: " + dbUser);
				response.setHeader("Content-Type", "application/json");
				response.getWriter().write(mapper.writeValueAsString(dbUser));
			}else {
				System.out.println("Sending no response");
				response.setStatus(401);
				response.getWriter().write("");
			}
			

		}
}
