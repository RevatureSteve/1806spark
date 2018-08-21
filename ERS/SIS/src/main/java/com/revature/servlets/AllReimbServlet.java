package com.revature.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojos.Reimbursement;
import com.revature.service.Service;


public class AllReimbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Service ss = new Service();
  
    public AllReimbServlet() {
       
    }
    
    public void init () {
    	System.out.println("Lets Begin");
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("All Reimbursements -GET");
		int empId = Integer.parseInt(request.getParameter("empId"));
		System.out.println("The id is " + empId);
		List<Reimbursement> rb = ss.getAllReimbursements(empId);
		
		
		System.out.println("Getting Reimbursements");
		ObjectMapper map = new ObjectMapper();
		String rbs = map.writeValueAsString(rb);
		
		response.setContentType("application/json");
		response.getWriter().write(rbs);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
