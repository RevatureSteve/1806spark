package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.ErsDao;
import com.revature.dao.ErsDaoImpl;
import com.revature.pogo.Users;

public class SubmitReimbursementServlet extends HttpServlet {

	/*
	 * URL - /submitReimbursement
	 */

	private ErsDao dao = new ErsDaoImpl();
	
	public SubmitReimbursementServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("TodoIdServlet -GET");

		int emp_u_id = Integer.parseInt(request.getParameter("empId"));
		double amount = Double.parseDouble(request.getParameter("amount"));
		String description = request.getParameter("description");
		String img = request.getParameter("imageUrl");
		int rq_type_id = Integer.parseInt(request.getParameter("reqTypeId"));

		dao.submitReimbursementRequest(emp_u_id, amount, description, img, rq_type_id);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
