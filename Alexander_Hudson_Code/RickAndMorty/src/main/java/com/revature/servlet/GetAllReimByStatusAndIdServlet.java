package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.Pojo.Reimbursement;
import com.revature.service.AppService;

public class GetAllReimByStatusAndIdServlet extends HttpServlet{
	
	private AppService appService = new AppService();
	
	protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		System.out.println("All Reimbursements by Status and Employee Id -GET");
		
		int emp_U_Id = Integer.parseInt(req.getParameter("emp_U_Id"));
	
		List <Reimbursement> re = appService.getAllReimbursementsByStatusAndId(emp_U_Id);
		
		//converting to json
			ObjectMapper mapper = new ObjectMapper();
			
			//employee json information
			String json = mapper.writeValueAsString(re);
			resp.setContentType("application/json");
			
			//format into text output
			PrintWriter out = resp.getWriter();
			out.println(json);
	}

}
