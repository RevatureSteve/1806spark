package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.revature.domain.Reimbursement;
import com.revature.service.ReimbursementBuisnessLogic;

/**
 * Servlet implementation class ReimbursementRIdServlet
 */
public class ReimbursementRIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReimbursementBuisnessLogic reimBL = new ReimbursementBuisnessLogic();

	/*
	 * url - /reimbursement/rid
	 */
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReimbursementRIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Hit post /reimbursement/rid");
		
		int rId;
		int mgrId;
		int status;
		
		ObjectMapper mapper = new ObjectMapper();
		ServletInputStream data = request.getInputStream();
		ObjectNode node = mapper.readValue(data, ObjectNode.class);
		
		rId = node.get("rId").intValue();
		status = node.get("status").intValue();
		mgrId = node .get("mgrId").intValue();
		
		Reimbursement reimb = reimBL.updateReimbursement(rId, mgrId, status);
		
		System.out.println(reimb);
		
		String json = mapper.writeValueAsString(reimb);
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.print(json);
		
	}

}
