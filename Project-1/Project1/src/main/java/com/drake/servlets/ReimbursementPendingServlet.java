package com.drake.servlets;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.drake.domain.Reimbursement;

public class ReimbursementPendingServlet extends HttpServlet{
	
	private ReimbursementServlet reimBL = new ReimbursementServlet();
	
	/*
	 * url - /pending
	 */

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		List <Reimbursement> reimbursements = reimBL.getPendingReimbursements();
		ObjectMapper mapper = new ObjectMapper();
		
		String json = mapper.writeValueAsString(reimbursements);
		resp.setContentType("application/json");
		
		PrintWriter out = resp.getWriter();
		out.print(json);
		
	}
	
}