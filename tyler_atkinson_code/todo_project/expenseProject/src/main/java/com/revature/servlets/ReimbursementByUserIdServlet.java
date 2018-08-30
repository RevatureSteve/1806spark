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
import com.revature.service.AppService;

/**
 * Servlet implementation class ReimbursementByUserIdServlet
 */
public class ReimbursementByUserIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private AppService appService = new AppService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReimbursementByUserIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("[LOG]- Reimbursement by emp_u_id");
		
		

		int emp_u_id = Integer.parseInt(request.getParameter("emp_u_id"));
		System.out.println("The reimbursement emp_u_id is: " + emp_u_id);
		List <Reimbursement> reimbursements = appService.getReimbursementByUserId(emp_u_id);
		
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(reimbursements);
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.print(json);
	}

}
