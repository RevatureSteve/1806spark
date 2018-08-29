package com.revature.servlets;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.domain.Reimbursement;
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
		ObjectMapper mapper = new ObjectMapper();
		BufferedReader bufferedReader = request.getReader();
		User employee = mapper.readValue(bufferedReader, User.class);
		
		service.updateEmployeeName(employee, employee.getFname(),employee.getLname());
	}
}