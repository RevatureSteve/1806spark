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
 *  ResolvedReimbursementIdServlet
 */
public class ResolvedReimbursementIdServlet extends HttpServlet {
	
	/**
	 * Generated serialUID
	 */
	private static final long serialVersionUID = 8983318504271246673L;
	
    //instantiating new object
	private ReimbursementService reimSV = new ReimbursementService();

	
    //httpServelet 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("userId"));
		
		List <Reimbursement> reimbursements = reimSV.getResolvedReimbursementsById(id);
		ObjectMapper mapper = new ObjectMapper();
		
		String json = mapper.writeValueAsString(reimbursements);
		response.setContentType("application/json");
		
		PrintWriter out = response.getWriter();
		out.print(json);
		
	}

}
