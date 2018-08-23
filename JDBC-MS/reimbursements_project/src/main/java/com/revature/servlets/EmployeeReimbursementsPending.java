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
import com.revature.service.ReimbursementsService;

/**
 * Servlet implementation class EmployeeReimbursementsPending
 */
public class EmployeeReimbursementsPending extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeReimbursementsPending() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * /employee/reimbursements/pending
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Employee pending reimbursements up");

		ObjectMapper mapper = new ObjectMapper();

		String id = request.getParameter("id");
		int numId = Integer.parseInt(id);
		// User verified = VerificationService.verifyUsernameAndPassword(email,
		// password);
		List<Reimbursement> reimbs = ReimbursementsService.getPendingOfUser(numId);

		String jsonOut = mapper.writeValueAsString(reimbs);

		// user printwriter note this is not json String just misc toString code
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		out.print(jsonOut);
	}
}
