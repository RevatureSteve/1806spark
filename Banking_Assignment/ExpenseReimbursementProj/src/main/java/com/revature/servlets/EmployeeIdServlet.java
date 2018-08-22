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



public class EmployeeIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ServiceMethods service = new ServiceMethods();


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		User employees = service.getEmployeeById(id);
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(employees);
		response.setContentType("application/json");
		response.getWriter().print(json);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("LoginServlet -POST");
	
	  BufferedReader bufferedReader = request.getReader();
	  
	  ObjectMapper mapper = new ObjectMapper();
	  User validate = mapper.readValue(bufferedReader,User.class);
	  User dbUser = service.validateUser(validate.getEmail(), validate.getPassword());
		if(dbUser != null){
			// this is a cookie!
			// HttpSession holds a J-SESSION-ID cookie (BADDDDDD!!!!)
			HttpSession session = request.getSession(); 
			
			session.setAttribute("user", dbUser);

			request.getRequestDispatcher("app.html").forward(request, response);
		}else{
			response.sendRedirect("login.html");
		}
		

	}
}