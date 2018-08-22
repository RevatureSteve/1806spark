package com.revature.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojos.Reimbursement;
import com.revature.service.Service;


public class AllReimbursementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Service ss = new Service();
       
   
    public AllReimbursementServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Get all Reimbursements -GET");
		List<Reimbursement> rb = ss.getAllEmpReimb();
		System.out.println("Got all reimbursements!");
		
		ObjectMapper map = new ObjectMapper();
		String st = map.writeValueAsString(rb);
		response.setContentType("application/json");
		response.getWriter().write(st);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
