package com.revature.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
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
		
		Users user = new Users();
		
		BufferedReader bf = request.getReader();
		System.out.println("[LOG]---LoginServlet---BufferedReader Successful");
		
		//converting object to JSON format
		ObjectMapper mapper = new ObjectMapper();
		System.out.println("[LOG]---LoginServlet---ObjectMapper Successful");
				
		/*//JSON format of our User (not advised because the password and email are displayed within the url which is B A D)
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		System.out.println("Email is: " + email);
		System.out.println("Password is: " + password);*/
		
		//taking the JSON and treating it as a node
		ObjectNode node = mapper.readValue(bf, ObjectNode.class);
		System.out.println("[LOG]---LoginServlet---ObjectNode Successful");
				
		String email = node.get("email").textValue();
		String password = node.get("password").textValue();
		System.out.println("[LOG]---LoginServlet---converting email and password from JSON to string respectively: " + email + " and " + password);
		
		user = businessLogic.login(email, password);
		System.out.println("[LOG]---LoginServlet---sending string to the Service Login()");
		

		//JSON format of the user
		String json = mapper.writeValueAsString(user);
		
		//client side info
		response.setContentType("application/json");
		
		//format object into a text output string
		PrintWriter out = response.getWriter();
		out.println(json);

	}

}
