package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.domain.Reimbursement;
import com.revature.service.ReimbursementBuisnessLogic;

/**
 * Servlet implementation class ReimbursementPendingIdServlet
 */
public class ReimbursementPendingIdServlet extends HttpServlet {
	
	/*
	 * url - pending/id
	 */

	private ReimbursementBuisnessLogic reimBL = new ReimbursementBuisnessLogic();

	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("userId"));
		
		List <Reimbursement> reimbursements = reimBL.getPendingReimbursementsById(id);
		ObjectMapper mapper = new ObjectMapper();
		
		String json = mapper.writeValueAsString(reimbursements);
		response.setContentType("application/json");
		
		PrintWriter out = response.getWriter();
		out.print(json);
		
	}

	

}
