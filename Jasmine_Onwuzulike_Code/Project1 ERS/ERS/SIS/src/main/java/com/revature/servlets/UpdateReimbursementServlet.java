package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.service.Service;


public class UpdateReimbursementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Service ss = new Service();
       
  
    public UpdateReimbursementServlet() {
        super();
   

	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("Update Reimbursement Servlet ---POST");
	int rId = Integer.parseInt(request.getParameter("rId"));
	int rStatusId = Integer.parseInt(request.getParameter("rStatusId"));
	
	int row = ss.updateReimbursements(rId, rStatusId);
	if (row != 0) {
		System.out.println("Success!");
	ObjectMapper map = new ObjectMapper();
	String s = map.writeValueAsString(row);
	response.setContentType("application/json");
	response.getWriter().write(s);
	}
	else {
		System.out.println("Failed");
	}
		
		
		
	}

}
