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

public class DeniedReimbursementServlet extends HttpServlet {
	/*
	 * url - /reimbursement/denied
	 */
	
	// creating object to access AppService properties through As
	private AppService aS = new AppService();

	public DeniedReimbursementServlet() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("DeniedReimbursement --GET");
		
		List<Reimbursement> Reimb = aS.getAllDeniedReimb();
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
