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
 *  ReimbursementPendingIdServlet Class
 */
public class PendingReimbursementIdServlet extends HttpServlet {
	
	/**
	 * Generated serialVersionUID
	 */
	private static final long serialVersionUID = 2086018587350874688L;
	
	//instantiating new object
	private ReimbursementService reimSV = new ReimbursementService();


    //httpServlet doGet method
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("userId"));
		
		List <Reimbursement> reimbursements = reimSV.getPendingReimbursementsById(id);
		ObjectMapper mapper = new ObjectMapper();
		
		String json = mapper.writeValueAsString(reimbursements);
		response.setContentType("application/json");
		
		PrintWriter out = response.getWriter();
		out.print(json);
		
	}

	

}
