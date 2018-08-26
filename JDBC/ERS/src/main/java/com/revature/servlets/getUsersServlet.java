package com.revature.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.POJO.Reimbursement;
import com.revature.POJO.User;
import com.revature.service.AppService;

/**
 * Servlet implementation class getUsersServlet
 */
public class getUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AppService appService = new AppService();
	
    /**
     * Default constructor. 
     */
    public getUsersServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		List<User> re = appService.getUsers();
		System.out.println(re);

		ObjectMapper mapper = new ObjectMapper();

		String json = mapper.writeValueAsString(re);
		response.setContentType("application/json");
		response.getWriter().write(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
