package com.revature.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.domain.Users;
import com.revature.service.AppService;

/**
 * Servlet implementation class EditUsersServlet
 */
public class EditUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private AppService appService = new AppService();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditUsersServlet() {
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
		ObjectMapper mapper = new ObjectMapper();
		BufferedReader bufferedReader = request.getReader();
		Users employee = mapper.readValue(bufferedReader, Users.class);
		
		appService.updateUser(employee);
	}
}
