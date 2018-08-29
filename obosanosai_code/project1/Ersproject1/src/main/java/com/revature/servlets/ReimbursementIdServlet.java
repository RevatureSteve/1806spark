package com.revature.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.domain.Reimbursement;
import com.revature.service.ReimbursementService;

/**
 * ReimbursementIdServlet Class
 */
public class ReimbursementIdServlet extends HttpServlet {
	
	/**
	 * Generated serialVersionUID
	 */
	private static final long serialVersionUID = 2460369399538000847L;
	
	
	//instantiating new object
	
	private ReimbursementService reimSV = new ReimbursementService();

   // httpSerlet doGet method
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("userId"));
		System.out.println(id);
		List<Reimbursement> reimbursements = reimSV.getReimbursementById(id);
		
		//Mapping the object gotten and turning it to json object
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(reimbursements);
		response.setContentType("application/json");
		response.getWriter().write(json);
	}

	

}
