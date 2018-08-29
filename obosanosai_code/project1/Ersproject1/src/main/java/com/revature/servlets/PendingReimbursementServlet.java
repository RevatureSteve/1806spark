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
import com.revature.service.ReimbursementService;

/**
 * pendingreimbursementServlet class
 */
public class PendingReimbursementServlet extends HttpServlet{
	
	/**
	 * Generated serialVersionUID
	 */
	private static final long serialVersionUID = 8519577159116229479L;
	
	//instantiaitng new object
	private ReimbursementService reimSV = new ReimbursementService();
	
	//httpServlet doGet method
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		List <Reimbursement> reimbursements = reimSV.getPendingReimbursements();
		ObjectMapper mapper = new ObjectMapper();
		
		String json = mapper.writeValueAsString(reimbursements);
		resp.setContentType("application/json");
		
		PrintWriter out = resp.getWriter();
		out.print(json);
		
	}
	
}
