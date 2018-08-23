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
 * Servlet implementation class ApprovedReimbursementServlet
 */
public class ApprovedReimbursementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BusinessLogic businessLogic = new BusinessLogic();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApprovedReimbursementServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * This is to get all approved reimbursements
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ApprovedReimbursementServlet -GET");
		
		List<Reimbursement> approvedReimbs = businessLogic.getApprovedReimbursements();
		
		//convert to JSON
		ObjectMapper mapper = new ObjectMapper();
		
		//JSON of our approved reimbursements
		String json = mapper.writeValueAsString(approvedReimbs);
		
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
