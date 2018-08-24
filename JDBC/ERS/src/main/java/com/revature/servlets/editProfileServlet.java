package com.revature.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.POJO.Reimbursement;
import com.revature.service.AppService;

/**
 * Servlet implementation class editProfileServlet
 */
public class editProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AppService appService = new AppService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public editProfileServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("userId"));
		String email = request.getParameter("email");
		String fname = request.getParameter("firstName");
		String lname = request.getParameter("lastName");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		appService.UpdateProfile(email, fname, lname, id);
	}

}
