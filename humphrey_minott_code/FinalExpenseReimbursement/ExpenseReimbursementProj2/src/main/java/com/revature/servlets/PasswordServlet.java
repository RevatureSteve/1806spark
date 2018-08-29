package com.revature.servlets;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.domain.User;
import com.revature.service.ServiceMethods;


public class PasswordServlet extends HttpServlet {
	
	ServiceMethods service = new ServiceMethods();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		BufferedReader bufferedReader = request.getReader();
		User employee = mapper.readValue(bufferedReader, User.class);
		
		service.updateEmployeePassword(employee, employee.getPassword());
	}

}
