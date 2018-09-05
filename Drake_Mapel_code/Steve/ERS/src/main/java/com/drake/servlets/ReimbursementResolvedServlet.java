package com.drake.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.drake.domain.Reimbursement;
import com.drake.service.ReimbursementService;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReimbursementResolvedServlet extends HttpServlet {
	
	/*
	 * url - resolved
	 */
	
	private ReimbursementService reimBL = new ReimbursementService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List <Reimbursement> reimbursements = reimBL.getResolvedReimbursements();
		ObjectMapper mapper = new ObjectMapper();
		
		String json = mapper.writeValueAsString(reimbursements);
		response.setContentType("application/json");
		
		PrintWriter out = response.getWriter();
		out.print(json);
		
	}

}