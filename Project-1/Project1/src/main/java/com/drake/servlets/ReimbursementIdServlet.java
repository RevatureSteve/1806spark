package com.drake.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.drake.domain.Reimbursement;
import com.drake.servlets.ReimbursementServlet;

/**
 * Servlet implementation class ReimbursementIdServlet
 */
public class ReimbursementIdServlet extends HttpServlet {
	
	/*
	 * url - /reimbursement/id
	 */
	
	private static final long serialVersionUID = 1L;
	private ReimbursementServlet reimBL = new ReimbursementServlet();

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("userId"));
		System.out.println(id);
		List<Reimbursement> reimbursements = reimBL.getReimbursementById(id);
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(reimbursements);
		response.setContentType("application/json");
		response.getWriter().write(json);
	}

	

}