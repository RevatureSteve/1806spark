package com.revature.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.domain.User;
import com.revature.service.ServiceMethods;



public class GetAllEmployeesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ServiceMethods service = new ServiceMethods();


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		List<User> employees = service.getAllEmployees();
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(employees);
		response.setContentType("application/json");
		System.out.print("sending" + json);
		response.getWriter().print(json);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Post----");
		  BufferedReader bufferedReader = request.getReader();
		  
		  ObjectMapper mapper = new ObjectMapper();
		  User employee = mapper.readValue(bufferedReader,User.class);
		  service.registerEmployee(employee);
		

	}

}
