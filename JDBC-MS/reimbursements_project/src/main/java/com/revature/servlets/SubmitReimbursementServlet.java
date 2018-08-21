package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.revature.service.ReimbursementsService;

/**
 * Servlet implementation class SubmitReimbursementServlet
 */
public class SubmitReimbursementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SubmitReimbursementServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * employee/reimbursements/submit
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Update employee up");
		ObjectMapper mapper = new ObjectMapper();
		ServletInputStream json = request.getInputStream();
		ObjectNode node = mapper.readValue(json, ObjectNode.class);

		int id = node.get("uId").intValue();
		double amount = node.get("amount").doubleValue();
		String description = node.get("description").textValue();
		byte[] imgStr = node.get("img").binaryValue();
		int rqTypeId = node.get("rqTypeId").intValue();
		System.out.println(id + ""+amount+description+imgStr+rqTypeId);
		int success = ReimbursementsService.createNewReimbursement(id, amount, description, imgStr, rqTypeId);
		// user printwriter note this is not json String just misc toString code
		PrintWriter out = response.getWriter();
		out.print(1);
	}
}
