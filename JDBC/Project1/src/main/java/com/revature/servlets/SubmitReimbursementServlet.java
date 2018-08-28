package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.revature.dao.ErsDao;
import com.revature.dao.ErsDaoImpl;

public class SubmitReimbursementServlet extends HttpServlet {

	/*
	 * URL - /submitReimbursement
	 */

	private ErsDao dao = new ErsDaoImpl();

	public SubmitReimbursementServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("SubmitReimbursementServlet -POST");

		ObjectMapper mapper = new ObjectMapper();
		ServletInputStream sis = request.getInputStream();
		ObjectNode on = mapper.readValue(sis, ObjectNode.class);

		int empId = on.get("empId").asInt();
		double amount = on.get("amount").asDouble();
		String description = on.get("description").asText();
		String imageUrl = "reciept";
		int reqTypeId = on.get("reqTypeId").asInt();

		dao.submitReimbursementRequest(empId, amount, description, imageUrl, reqTypeId);
	}

}
