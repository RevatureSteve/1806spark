package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.UserDaoImpl;
import com.revature.domain.Reimbursements;

/**
 * Servlet implementation class ViewAllReimbursements
 */
public class ViewAllReimbursements extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		List<Reimbursements> reimbursements = new UserDaoImpl().getAllReimbursements();
		
		String json = mapper.writeValueAsString(reimbursements);
		
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		out.print(json);
		
		
	}


}
