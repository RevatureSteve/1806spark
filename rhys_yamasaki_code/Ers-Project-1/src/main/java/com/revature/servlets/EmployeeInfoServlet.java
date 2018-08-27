package com.revature.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.Request;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.revature.pojo.User;
import com.revature.service.UserService;

/**
 * /employee
 */
public class EmployeeInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	private UserService us= new UserService();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<User> userList = us.getAllEmployees();
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(userList);
		
		resp.setContentType("application/json");
		
		resp.getWriter().write(json);
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		System.out.println("Updating employee info");
		
		ObjectMapper mapper = new ObjectMapper();
		ServletInputStream data = request.getInputStream();
		ObjectNode n = mapper.readValue(data, ObjectNode.class);
		
		int userId = 0;
		String password = null;
		String fname = null;
		String lname = null;
		
		userId = n.get("user_id").intValue();
		password = n.get("password").textValue();
		fname = n.get("fname").textValue();
		lname = n.get("lname").textValue();
		
		us.updateEmployeeInfo(userId, password, fname, lname);
	}

}
