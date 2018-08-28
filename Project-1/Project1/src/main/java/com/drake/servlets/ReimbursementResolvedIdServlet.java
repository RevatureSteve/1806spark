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

/**
 * Servlet implementation class ReimbursementResolvedIdServlet
 */
public class ReimbursementResolvedIdServlet extends HttpServlet {
	
	/*
	 * url - resolved/id
	 */

	private ReimbursementServlet reimBL = new ReimbursementServlet();

	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("userId"));
		
		List <Reimbursement> reimbursements = reimBL.getResolvedReimbursementsById(id);
		ObjectMapper mapper = new ObjectMapper();
		
		String json = mapper.writeValueAsString(reimbursements);
		response.setContentType("application/json");
		
		PrintWriter out = response.getWriter();
		out.print(json);
		
	}

}