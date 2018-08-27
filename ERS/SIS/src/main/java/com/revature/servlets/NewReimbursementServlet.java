package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.revature.pojos.Reimbursement;
import com.revature.service.Service;

public class NewReimbursementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Service ss = new Service();
 
    public NewReimbursementServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double amount  = Double.parseDouble(request.getParameter("amount"));
		String rDescription = request.getParameter("rDescription");
		int type = Integer.parseInt(request.getParameter("rTypeId"));	
		int status = Integer.parseInt(request.getParameter("rStatusId"));
		int empId = Integer.parseInt(request.getParameter("empId"));
		Reimbursement rb = ss.createNewReimbursement(amount, rDescription, empId, type, status);
		System.out.println(rb);
		ObjectMapper map = new ObjectMapper();
		String s = map.writeValueAsString(rb);
		response.setContentType("application/json");
		System.out.println("Writing...");
		response.getWriter().write(s);
	
		//Servlet Input Stream provides an input stream for reading data from the client.
		//request.getInputStream() ==> Retrieves the body of the request.
		//ServletInputStream input = request.getInputStream();
		
		//ObjectMapper ==> Functionality for reading and writing JSON to and from Java objects to and from JSON.
//		ObjectMapper map = new ObjectMapper();
//		
//		//ObjectNode Node that maps JSON Object structures into JSON content.
//		
//		//readValue() ==> Parses JSON content into Java object.
//		//writeValue() ==> Parse Java object into JSON content.
//		ObjectNode on = map.readValue(input, ObjectNode.class);
		
		//Setting up reimbursement variables.
//		double amount = on.get("amount").doubleValue();
//		String rDescription = on.get("rDescription").textValue();
//		int empId = on.get("empId").intValue();
//		int rType = on.get("type").intValue();
//		int rStatus = on.get("status").intValue();
//		
//		
//		Reimbursement rb = ss.createNewReimbursement(amount, rDescription, empId, rType, rStatus);
//		
//		System.out.println("Got it.");
//		
//		String json = map.writeValueAsString(rb);
//		response.setContentType("application/json");
//		PrintWriter out = response.getWriter();
//		out.print(json);
//		
		
		
		
		
		
		
		
		
		
		
		
		doGet(request, response);
	}

}
