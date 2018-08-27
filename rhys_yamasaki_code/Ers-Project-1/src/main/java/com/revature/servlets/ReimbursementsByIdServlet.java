package com.revature.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.revature.pojo.Reimbursement;
import com.revature.service.ReimbursementService;

/**
 * url - /reimbursements/id
 */

public class ReimbursementsByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	private ReimbursementService rs = new ReimbursementService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("user_id"));


		List<Reimbursement> rb = rs.getReimbursementById(id);

		ObjectMapper mapper = new ObjectMapper();

		String json = mapper.writeValueAsString(rb);

		response.setContentType("application/json");
		System.out.println(json);
		response.getWriter().write(json);

	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		ServletInputStream data = request.getInputStream();
		ObjectNode n = mapper.readValue(data, ObjectNode.class);
		
		System.out.println(n);
		System.out.println("Resolving user");
		int userId = n.get("user_id").asInt();
		int rId = n.get("r_id").asInt();
		int statusId = n.get("rq_status_id").asInt();
		
		rs.updateReimbursementById(userId, rId, statusId);
		System.out.println("Resolved user");
	}

}
