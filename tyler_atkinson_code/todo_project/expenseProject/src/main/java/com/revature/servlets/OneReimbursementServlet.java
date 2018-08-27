package com.revature.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.domain.Reimbursement;
import com.revature.service.AppService;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * Servlet implementation class OneReimbursementServlet
 */
public class OneReimbursementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    
	private AppService appService = new AppService();
	
	public OneReimbursementServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("[LOG]-ONE Reimbursement");
		
		int u_id = Integer.parseInt(request.getParameter("byId"));
		System.out.println("The reimbursement id is: " + u_id);
		List<Reimbursement> reimbursements = appService.getReimbursementsById(u_id);
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(reimbursements);
		response.setContentType("application/json");
		response.getWriter().write(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
