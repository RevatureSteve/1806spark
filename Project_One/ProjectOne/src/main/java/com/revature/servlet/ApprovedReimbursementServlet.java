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
 * Servlet implementation class ApprovedReimbursement
 * 
 * @author Alex Moraga
 *
 */

public class ApprovedReimbursementServlet extends HttpServlet{
	/*
	 * url - /reimbursement/approved
	 */
	
	// creating object to access AppService properties through aS
	private AppService aS = new AppService();

	public ApprovedReimbursementServlet() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ApprovedReimbursement --GET");
		
		List<Reimbursement> Reimb = aS.getAllApprovedReimb();
		// Convert json object to json string
		ObjectMapper mapper = new ObjectMapper();
		
		String json = mapper.writeValueAsString(Reimb);
		// Setting the response type as json
		response.setContentType("application/json");
		
		// PrintWriter to print out a mis toString code
		// Example: Allows to print out the toString code onto Postman
		PrintWriter out = response.getWriter();
		out.print(json);
		
	}
	
}
