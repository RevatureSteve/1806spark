package com.revature.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojo.Reimbursement;
import com.revature.service.ReimbursementService;

/**
 * 	url - /employee/pending
 */
public class EmployeePendingReimbursementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ReimbursementService rs = new ReimbursementService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("user_id"));


		List<Reimbursement> rb = rs.getPendingReimbursementById(id);

		ObjectMapper mapper = new ObjectMapper();

		String json = mapper.writeValueAsString(rb);

		response.setContentType("application/json");
		System.out.println(json);
		response.getWriter().write(json);
	}

	

}
