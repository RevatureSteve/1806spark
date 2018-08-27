package com.revature.service;

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
import com.revature.domain.Reimbursement;


public class EmployeeViewPendingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public EmployeeViewPendingServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ReimbursementBL bl = new ReimbursementBL();
		
		int u_id = Integer.parseInt(request.getParameter("u_id"));
		
		List<Reimbursement> reims = bl.employeeViewPending(u_id);
		ObjectMapper mapper = new ObjectMapper();
		
		String json = mapper.writeValueAsString(reims);
		response.setContentType("application/json");
		
		
		PrintWriter out = response.getWriter();
		out.print(json);
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ReimbursementBL bl = new ReimbursementBL();
		
		int u_id;
		
		ObjectMapper mapper = new ObjectMapper();
		ServletInputStream data = request.getInputStream();
		ObjectNode node = mapper.readValue(data,  ObjectNode.class);
		
		u_id = node.get("u_id").intValue();
		
		List<Reimbursement> reims = bl.employeeViewPending(u_id);
		
		String json = mapper.writeValueAsString(reims);
		response.setContentType("application/json");
		response.getWriter().write(json);
	}

}
