package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.revature.domain.Decision;
import com.revature.domain.Reimbursement;
import com.revature.domain.User;
import com.revature.service.ReimbursementsService;
import com.revature.service.VerificationService;

/**
 * Servlet implementation class UpdateReimbursementsServlet
 */
public class UpdateReimbursementsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateReimbursementsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Update up");

		ObjectMapper mapper = new ObjectMapper();
		ServletInputStream json = request.getInputStream();
		Decision[] decisions = mapper.readValue(json, Decision[].class);
		
		int success = ReimbursementsService.updateReimbursements(decisions);
		System.out.println(decisions);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		out.print(success);
	}

}
