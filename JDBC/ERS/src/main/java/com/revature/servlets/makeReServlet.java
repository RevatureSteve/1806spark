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
		System.out.println("called");
		ObjectMapper mapper = new ObjectMapper();
		ServletInputStream json = request.getInputStream();
		ObjectNode node = mapper.readValue(json, ObjectNode.class);

		int id = node.get("userId").intValue();
		double amt = node.get("amount").doubleValue();
		String desc = node.get("description").textValue();
		int type = node.get("type").intValue();
		System.out.println("Id: " + id + " amount: " + amt + " description: " + desc + " type: " + type);
		appService.makeRe(id, amt, desc, type);
		PrintWriter out = response.getWriter();
		
		String ujson = mapper.writeValueAsString("Request sent");
		response.setContentType("application/json");
		response.getWriter().write(ujson);
	}
}
