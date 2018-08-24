package com.revature.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojos.Users;
import com.revature.service.Service;


public class GetAllEmployeesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private Service ss = new Service();
    
    public GetAllEmployeesServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Get all employees -GET");
		List<Users> u = ss.getAllEmployees();
		
		ObjectMapper map = new ObjectMapper();
		System.out.println("Converting...");
		String s = map.writeValueAsString(u);
		
		response.setContentType("application/json");
		System.out.println("Writing...");
		response.getWriter().write(s);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
