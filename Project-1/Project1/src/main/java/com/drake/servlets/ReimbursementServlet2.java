package com.drake.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.drake.domain.Reimbursement;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * Servlet implementation class ReimbursementServlet
 */
public class ReimbursementServlet2 extends HttpServlet {
	
	/*
	 * url - /reimbursement
	 */
	
	private  ReimbursementServlet reimBL = new  ReimbursementServlet();
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Reimbursement> reimbursements = reimBL.getAllReimbursemets();
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(reimbursements);
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.print(json);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("Hit post method");
		
		Reimbursement reimb = new Reimbursement();
		
		ObjectMapper mapper = new ObjectMapper();
		ServletInputStream data = req.getInputStream();
		ObjectNode node = mapper.readValue(data, ObjectNode.class);
		
		reimb = new Reimbursement(node.get("u_id").intValue(), Double.parseDouble(node.get("amt").textValue()), node.get("desc").textValue(), null, Integer.parseInt(node.get("type").textValue()));
		
		System.out.println(reimb);
		
		reimBL.createReimbursement(reimb);
	
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
System.out.println("Hit put /reimbursement");
		
		int rId;
		int mgrId;
		int status;
		
		ObjectMapper mapper = new ObjectMapper();
		ServletInputStream data = req.getInputStream();
		ObjectNode node = mapper.readValue(data, ObjectNode.class);
		
		rId = node.get("rId").intValue();
		status = node.get("status").intValue();
		mgrId = node .get("mgrId").intValue();
		
		Reimbursement reimb = reimBL.updateReimbursement(rId, mgrId, status);
		
		System.out.println(reimb);
		
		String json = mapper.writeValueAsString(reimb);
		resp.setContentType("application/json");
		PrintWriter out = resp.getWriter();
		out.print(json);
	}

	
}