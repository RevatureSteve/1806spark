package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.revature.domain.Users;
import com.revature.service.UsersBusinessLogic;

/**
 * Servlet implementation class GetAllEmployeesServlet
 */
public class GetAllEmployeesServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private UsersBusinessLogic bl = new UsersBusinessLogic();
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Users> users = bl.viewAllEmployees();
		ObjectMapper mapper = new ObjectMapper();
		
		String json = mapper.writeValueAsString(users);
		response.setContentType("application/json");
		
		PrintWriter out =response.getWriter();
		out.print(json);
	}

//update user profile
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			int u_id;
			String email;
			String password;
			String fname;
			String lname;
			
			
			ObjectMapper mapper = new ObjectMapper();
			ServletInputStream data = request.getInputStream();
			ObjectNode node = mapper.readValue(data,  ObjectNode.class);
			
			u_id = node.get("u_id").intValue();
			email = node.get("email").textValue();
			password = node.get("password").textValue();
			fname = node.get("fname").textValue();
			lname = node.get("lname").textValue();
			
			
			bl.changeEmployeeInfo(u_id, email, password, fname, lname);
			
			
	
			
			
			
			
	}

}
