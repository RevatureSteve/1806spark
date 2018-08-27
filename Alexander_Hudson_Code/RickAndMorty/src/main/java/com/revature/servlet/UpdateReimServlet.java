package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.service.AppService;

public class UpdateReimServlet extends HttpServlet{
	
	AppService appService = new AppService();
	
	
	protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		System.out.println("Update reimbursement _GET");
		
		int r_Id = 0;
		int rq_Status_Id = 0;
		int mgr_U_Id = 0;
		
		r_Id = Integer.parseInt(req.getParameter("r_Id"));
		rq_Status_Id = Integer.parseInt(req.getParameter("rq_Status_Id"));
		mgr_U_Id = Integer.parseInt(req.getParameter("mgr_U_Id"));
		
		int reim = appService.updateReim(r_Id, rq_Status_Id, mgr_U_Id);
		ObjectMapper mapper = new ObjectMapper();
		
		String json = mapper.writeValueAsString(reim);
		resp.setContentType("application/json");
		
		PrintWriter out = resp.getWriter();
		out.print(json);
		
		
	}
	

}
