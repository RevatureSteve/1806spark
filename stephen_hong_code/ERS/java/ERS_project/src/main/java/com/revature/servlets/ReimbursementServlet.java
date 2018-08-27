package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Reimbursement;
import com.revature.services.ERSService;

@WebServlet("/reimbursement")
public class ReimbursementServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	ERSService service = new ERSService();

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("[LOG] - API request to /reimbursement");
		
		ArrayList<Reimbursement> r = ERSService.getAllReimbursements();
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(r);
		res.setContentType("application/json");
		PrintWriter pw = res.getWriter();
		pw.write(json);
	}
}
