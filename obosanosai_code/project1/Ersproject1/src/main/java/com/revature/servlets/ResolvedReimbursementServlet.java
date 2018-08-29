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
 *ResolvedReimbursement class
 */
public class ResolvedReimbursementServlet extends HttpServlet {
	
	/**
	 * Generated serialUID
	 */
	private static final long serialVersionUID = 7760545534039563009L;
	
	//instatiating new object
	
	private ReimbursementService reimSV = new ReimbursementService();
	
	//httpServlet doGet method
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List <Reimbursement> reimbursements = reimSV.getResolvedReimbursements();
		ObjectMapper mapper = new ObjectMapper();
		
		String json = mapper.writeValueAsString(reimbursements);
		response.setContentType("application/json");
		
		PrintWriter out = response.getWriter();
		out.print(json);
		
	}

	
}
