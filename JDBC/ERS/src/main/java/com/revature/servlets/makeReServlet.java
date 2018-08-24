package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.revature.POJO.Reimbursement;
import com.revature.service.AppService;

/**
 * Servlet implementation class makeRe
 */
public class makeReServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AppService appService = new AppService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public makeReServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		int id = Integer.parseInt(request.getParameter("userId"));
		double amt = Double.parseDouble(request.getParameter("amount"));
		String desc = request.getParameter("description");
		int type = Integer.parseInt(request.getParameter("type"));
		response.getWriter().append("Served at: ").append(request.getContextPath());
		appService.makeRe(id, amt, desc, type);
		*/
		System.out.println("called");
		ObjectMapper mapper = new ObjectMapper();
		ServletInputStream json = request.getInputStream();
		ObjectNode node = mapper.readValue(json, ObjectNode.class);

		int id = node.get("userId").intValue();
		System.out.println(id);
		double amt = node.get("amount").doubleValue();
		System.out.println(amt);
		String desc = node.get("description").textValue();
		System.out.println(desc);
		int type = node.get("type").intValue();
		System.out.println(type);
		appService.makeRe(id, amt, desc, type);
		// user printwriter note this is not json String just misc toString code
		PrintWriter out = response.getWriter();
	}
	
	/*        example body input
	    {
			"userId":3, 
			"amount":2.00, 
			"description":"hi", 
			"type":5
		}
	 */
}
