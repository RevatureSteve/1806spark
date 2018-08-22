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
		String status = request.getParameter("status");
		int id = Integer.parseInt(request.getParameter("userId"));
		List<Reimbursement> requests = service.getReimbursementByStatusAndId(id, status);
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(requests);
		response.setContentType("application/json");
		response.getWriter().print(json);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		BufferedReader bufferedReader = request.getReader();
		Reimbursement requests = mapper.readValue(bufferedReader, Reimbursement.class);
		
		service.updateRequestStatus(requests);
	}

}
