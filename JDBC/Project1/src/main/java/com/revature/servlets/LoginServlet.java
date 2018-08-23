package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.domain.Users;
import com.revature.service.BusinessLogic;

//import oracle.net.aso.u;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BusinessLogic businessLogic = new BusinessLogic();   
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * This servlet is used to login
	 * URL endpoint is /Login
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LoginServlet - POST");
		Users users = new Users();
		
		
		//JSON format of our User
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		System.out.println("Email is: " + email);
		System.out.println("Password is: " + password);
		
		users = businessLogic.login(email, password);
		
		//converting object to JSON format
		ObjectMapper mapper = new ObjectMapper();
		
		//JSON format of the user
		String json = mapper.writeValueAsString(users);
		
		//client side info
		response.setContentType("application/json");
		
		//format object into a text output string
		PrintWriter out = response.getWriter();
		out.println(json);
		
		
	}

}
