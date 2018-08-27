package com.cpo.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cpo.model.Reimbursement;
import com.cpo.services.ReimbursementService;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class ReimbursementServlet endpoint -/reimbursement
 */
public class ReimbursementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReimbursementServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		

		if (request.getParameter("userId") != null) {
			int userId = Integer.parseInt(request.getParameter("userId"));
			if (userId > 0) {
				List<Reimbursement> reimbs = ReimbursementService.getInstance().getReimbursementByUId(userId);
				System.out.println("ReimbursementServlet -GET sending reimbs for user id " + userId + ", count: " + reimbs.size());
				String json = mapper.writeValueAsString(reimbs);
				PrintWriter pw = response.getWriter();
				response.setContentLength(json.length());
				response.setContentType("application/json");
				pw.write(json);
			}
		} else {
			List<Reimbursement> reimbs = ReimbursementService.getInstance().getAllReimbursements();
			System.out.println("ReimbursementServlet -GET sending all reimbs, count: " + reimbs.size());
			String json = mapper.writeValueAsString(reimbs);
			PrintWriter pw = response.getWriter();
			response.setContentLength(json.length());
			response.setContentType("application/json");
			pw.write(json);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("ReimbursementServlet -POST create reimb");
		BufferedReader bf = request.getReader();

		ObjectMapper mapper = new ObjectMapper();
		Reimbursement reimb = mapper.readValue(bf, Reimbursement.class);

		System.out.println("Reimbursement: " + reimb);
		ReimbursementService.getInstance().createReimbursement(reimb);

	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("ReimbursementServlet -POST create reimb");
		BufferedReader bf = request.getReader();

		ObjectMapper mapper = new ObjectMapper();
		Reimbursement reimb = mapper.readValue(bf, Reimbursement.class);

		System.out.println("Reimbursement: " + reimb);
		ReimbursementService.getInstance().updateReimbursement(reimb);

	}

}
