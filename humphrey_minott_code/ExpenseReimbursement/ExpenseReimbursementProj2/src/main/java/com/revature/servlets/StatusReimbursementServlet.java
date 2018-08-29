package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.domain.Reimbursement;
import com.revature.service.ServiceMethods;


public class StatusReimbursementServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    ServiceMethods service = new ServiceMethods(); 
 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int statusId= 0;
		String status = request.getParameter("status");
		if(status.equalsIgnoreCase("pending")) {
			statusId= 1;
		}
		if(status.equalsIgnoreCase("accepted")) {
			statusId= 2;
		}
		if(status.equalsIgnoreCase("denied")) {
			statusId= 3;
		}
		System.out.println(status);
		List<Reimbursement> requests = service.getReimbursementByStatus(statusId);
		System.out.println(requests);
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(requests);
		PrintWriter pw = response.getWriter();
		pw.write(json);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
	}

}
