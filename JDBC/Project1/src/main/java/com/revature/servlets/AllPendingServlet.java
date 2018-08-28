package com.revature.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.ErsDao;
import com.revature.dao.ErsDaoImpl;
import com.revature.pogo.Reimbursement;

public class AllPendingServlet extends HttpServlet {
	
	/*
	 * URL - /allPending
	 */
	
	private ErsDao dao = new ErsDaoImpl();
	
    public AllPendingServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AllPendingServlet -GET");

		List<Reimbursement> allPending = dao.viewAllPendingRequests();

		ObjectMapper mapper = new ObjectMapper();

		String json = mapper.writeValueAsString(allPending);

		response.setContentType("application/json");
		response.getWriter().write(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
