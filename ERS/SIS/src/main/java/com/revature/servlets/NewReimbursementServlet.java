package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.service.Service;

public class NewReimbursementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Service ss = new Service();
 
    public NewReimbursementServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String amount  = request.getParameter("amount");
		String rDescription = request.getParameter("rDescription");
		String uId = request.getParameter("uId");
		String type =request.getParameter("type");
		String status = request.getParameter("status");
//		ss.createNewReimbursement(amount, rDescription, uId, type, status);
		
		doGet(request, response);
	}

}
