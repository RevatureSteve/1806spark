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
import com.revature.service.BusinessLogic;

/**
 * Servlet implementation class Reimbursements
 */
public class ReimbursementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BusinessLogic businessLogic = new BusinessLogic();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReimbursementServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * This is used to get all reimbursements 
	 * URL endpoint is /allReimbursements
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ReimbursementServlet - GET");
		List<Reimbursement> reimbs = businessLogic.getReimbursements();
		
		//convert to JSON
		ObjectMapper mapper = new ObjectMapper();
		
		//JSON of our reimbursements
		String json = mapper.writeValueAsString(reimbs);
		
		//client info
		response.setContentType("application/json");
		
		//format JSON into text string
		PrintWriter out = response.getWriter();
		out.println(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
