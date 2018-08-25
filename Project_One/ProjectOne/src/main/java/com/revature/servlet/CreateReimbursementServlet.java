package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pogo.Reimbursement;
import com.revature.service.AppService;

/**
 * Servlet implementation class CreateReimbursementServlet
 * 
 * @author Alex Moraga
 *
 */
public class CreateReimbursementServlet extends HttpServlet {
	/*
	 * url - /reimbursement/c
	 */
	
	private AppService aS = new AppService();

	public CreateReimbursementServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("CreateReimbursementServlet -POST"); 
		ObjectMapper mapper = new ObjectMapper();
		// Reads the json that's being sent through the POST request
		ServletInputStream json = request.getInputStream();
		Reimbursement reimb = mapper.readValue(json, Reimbursement.class);

		System.out.println("User reimbursement information: " + reimb);
		
		int amt = reimb.getAmt();
		int emp_U_Id = reimb.getEmp_U_Id();
		int mgr_U_Id = reimb.getMgr_U_Id();
		int rq_Type_Id = reimb.getRq_Type_Id();
		String description = reimb.getDescription();
		System.out.println(amt + ""+ emp_U_Id + "" + mgr_U_Id + "" + rq_Type_Id + "" + description);
		int success = aS.createReimbursement(amt, emp_U_Id, mgr_U_Id, rq_Type_Id, description);
		PrintWriter out = response.getWriter();
		out.print(1);
	}

}
