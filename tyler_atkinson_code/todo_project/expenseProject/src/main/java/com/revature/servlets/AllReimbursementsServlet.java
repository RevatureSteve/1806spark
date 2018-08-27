package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.domain.Reimbursement;
import com.revature.service.AppService;

/**
 * Servlet implementation class AllReimbursementsServlet
 */
public class AllReimbursementsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AppService appService = new AppService();  
	
    public AllReimbursementsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Reimbursement> reimbursements = appService.getAllReimbursements();
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(reimbursements);
		resp.setContentType("application/json");
		PrintWriter out = resp.getWriter();
		out.print(json);
		
			
	}
			
}
