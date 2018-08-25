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
 * Servlet implementation class ReimbursementsById
 */
public class ReimbursementsByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     *  url - /reimbursements/id
     */

	private ReimbursementService rs = new ReimbursementService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		int id = Integer.parseInt(request.getParameter("userId"));
		
		System.out.println(id);
		
		List<Reimbursement> rb = rs.getReimbursementById(id);
		
		ObjectMapper mapper = new ObjectMapper();
		
		String json = mapper.writeValueAsString(rb);
		
		response.setContentType("application/json");
		System.out.println(json);
		response.getWriter().write(json);
		
	}


}
