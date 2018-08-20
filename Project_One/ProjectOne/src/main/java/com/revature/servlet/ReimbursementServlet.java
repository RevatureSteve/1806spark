package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pogo.Reimbursement;
import com.revature.service.AppService;

/**
 * Servlet implementation class ReimbursementServlet
 * 
 * @author Alex Moraga
 *
 */
public class ReimbursementServlet extends HttpServlet {
	/*
	 * url - /reimbursement
	 */

	// this object is on the instance scope, so that every non-static method in this class can use the same object 
	private AppService aS = new AppService();

	public ReimbursementServlet() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ReimbursementServlet --GET");
		
		List<Reimbursement> Reimb = aS.getAllReimbursements();
		
		/*
		 * fasterxml jackson, the standard for converting
		 * 		java object <---> json string
		 */
		ObjectMapper mapper = new ObjectMapper();
		
		String json = mapper.writeValueAsString(Reimb);
		// Setting the response type as json
		response.setContentType("application/json");
		
		// Printwriter to print out a misc toString code
		PrintWriter out = response.getWriter();
		out.print(json);
		
	}
	
	
	
}
