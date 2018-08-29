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


public class IdReimbursementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ServiceMethods service = new ServiceMethods();


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("userId"));
		List<Reimbursement> requests = service.getReimbursementByUserId(id);
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(requests);
		response.setContentType("application/json");
		PrintWriter pw = response.getWriter();
		pw.print(json);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
	}

}
