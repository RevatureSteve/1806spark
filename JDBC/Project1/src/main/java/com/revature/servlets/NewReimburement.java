package com.revature.servlets;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.revature.domain.Reimbursement;
import com.revature.service.BusinessLogic;

/**
 * Servlet implementation class NewReimburement
 */
public class NewReimburement extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BusinessLogic businessLogic = new BusinessLogic();    
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewReimburement() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("NewReimbursement - POST");
		Reimbursement reimb = new Reimbursement();
		
		//BufferedReader bf = request.getReader();
		//System.out.println("[LOG]---NewReimbursementServlet---BufferedReader Successful");
		
		ObjectMapper mapper = new ObjectMapper();
		System.out.println("[LOG]---NewReimbursementServlet---ObjectMapper Successful");
		
		ServletInputStream inputStream = request.getInputStream();
		System.out.println("[LOG]---NewReimbursementServlet---ServletInputStream Successful");
		
		ObjectNode node = mapper.readValue(inputStream, ObjectNode.class);
		System.out.println("[LOG]---ObjectNode---ObjectNode Successful");
		
		/*node.get("Emp_U_Id").intValue(), 
		Double.parseDouble(node.get("Amt").textValue()),
		null,
		node.get("description").textValue(),
		node.get("Rq_Type_Id")*/
		
		reimb = new Reimbursement();
		
		businessLogic.newReimbursement(reimb);
	}

}
