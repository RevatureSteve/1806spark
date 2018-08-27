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
import com.revature.service.ReimbursementBL;


public class EmployeeResolvedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public EmployeeResolvedServlet() {
        super(); }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ReimbursementBL bl = new ReimbursementBL();
		
		int u_id = Integer.parseInt(request.getParameter("u_id"));
		
		List<Reimbursement> reims = bl.viewResolvedById(u_id);
		ObjectMapper mapper = new ObjectMapper();
		
		String json = mapper.writeValueAsString(reims);
		response.setContentType("application/json");
		
		
		PrintWriter out = response.getWriter();
		out.print(json);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
