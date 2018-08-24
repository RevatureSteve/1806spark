package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.revature.domain.Reimbursement;
import com.revature.service.ReimbursementBL;

/**
 * Servlet implementation class CreateReimbursementServlet
 */
public class CreateReimbursementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public CreateReimbursementServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		ReimbursementBL bl = new ReimbursementBL();
		
		ObjectMapper mapper = new ObjectMapper();
		ServletInputStream data = request.getInputStream();
		ObjectNode node = mapper.readValue(data,  ObjectNode.class);
		
		
		Reimbursement reim = new Reimbursement(node.get("empUId").intValue(), Double.parseDouble(node.get("amt").textValue()), 
				node.get("description").textValue(), null, Integer.parseInt(node.get("rqTypeId").textValue())); 
		
		bl.createReimbursement(reim);
		
		
		/*
		 * 		
			this.empUId = empUId;
		setAmt(amt);
		this.description = description;
		this.img = img;
		this.rqTypeId = rqTypeId;
		 */
		
		
		
		
		
		
		
		
	}

}
