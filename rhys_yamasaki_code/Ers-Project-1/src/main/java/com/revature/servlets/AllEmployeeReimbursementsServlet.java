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

public class AllEmployeeReimbursementsServlet extends HttpServlet{

	private ReimbursementService rs = new ReimbursementService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		List<Reimbursement> ReimbursementList = rs.getAllReimbursements();
		
		System.out.println(ReimbursementList);
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(ReimbursementList);
		
		response.setContentType("application/json");
		
		response.getWriter().write(json);
		
	}
}
