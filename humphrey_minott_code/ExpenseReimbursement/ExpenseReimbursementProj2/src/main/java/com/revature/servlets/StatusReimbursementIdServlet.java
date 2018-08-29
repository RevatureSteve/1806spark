package com.revature.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.domain.Reimbursement;
import com.revature.domain.User;
import com.revature.service.ServiceMethods;


public class StatusReimbursementIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ServiceMethods service = new ServiceMethods();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int statusId = 0;
		System.out.println("Get");
		String status = request.getParameter("status");
		if(status.equalsIgnoreCase("pending")) {
			statusId= 1;
		}
		else if(status.equalsIgnoreCase("Accepted")) {
			statusId= 2;
		}
		if(status.equalsIgnoreCase("denied")) {
			statusId= 3;
		}
		int id = Integer.parseInt(request.getParameter("userId"));
		System.out.println(status + "" + id);
		List<Reimbursement> requests = service.getReimbursementByStatusAndId(id, statusId);
		System.out.println(requests);
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(requests);
		response.setContentType("application/json");
		response.getWriter().print(json);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		BufferedReader bufferedReader = request.getReader();
		Reimbursement requests = mapper.readValue(bufferedReader, Reimbursement.class);
		System.out.println(requests);
		service.updateRequestStatus(requests);
	}

}
