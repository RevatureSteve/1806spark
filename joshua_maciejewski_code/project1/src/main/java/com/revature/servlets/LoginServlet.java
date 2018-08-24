package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.revature.domain.Users;
import com.revature.service.UsersBusinessLogic;

/**
 * Servlet implementation class Login
 */
@JsonPropertyOrder({ "uId", "email", "password", "fname", "lname", "posId", "posType" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	
	//private UsersBusinessLogic login = new UsersBusinessLogic();
    /**
     * @see HttpServlet#HttpServlet()
     */
//    public LoginServlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		
		
		System.out.println("logging on");
		
		ObjectMapper mapper = new ObjectMapper();
		ServletInputStream json = request.getInputStream();
		ObjectNode node = mapper.readValue(json, ObjectNode.class);
		
		String email = null;
		String password = null;
		
		if(node.has("email")) {
			email = node.get("email").textValue();
		}
		if(node.has("password")) {
			password = node.get("password").textValue();
		}
		
		System.out.println(email + password);
		
		Users user = new UsersBusinessLogic().login(email, password);
		
		
		
		System.out.println(user);
		
		String jsonOut = mapper.writeValueAsString(user);
		
		System.out.println(jsonOut);
		
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		out.print(jsonOut);
		
	}}
		
//		BufferedReader br = request.getReader();
//		
//		ObjectMapper mapper = new ObjectMapper();
//		
//		User attempt = mapper.readValue(br, User.class)
//		
//		System.out.println(attempt);
//		
//		if(valid != null ) {
//			HttpSession session = request.getSession();
//			session.setAttribute("user", valid);
//			
//			response.setHeader("Content-Type", "application/json");
//			response.getWriter().write(mapper.writeValueAsString(valid));
//		
//		} else {
//			response.setStatus(401);
//			response.getWrtier().write("");
//		}
//		
//	}


//System.out.println("[LOG]-----LoginSevlet---POST");
//BufferedReader br = request.getReader();
//
//ObjectMapper mapper = new ObjectMapper();
//User inputUser = mapper.readValue(br, User.class);
//System.out.println("[LOG]-----LoginServlet----inputUser: " + inputUser);
//
//User validUser = appService.login(inputUser);
//
//if(validUser != null) {
//	// Start a HttpSession (note this breaks Restful architecture)
//	// Place User object inside Session
//	HttpSession session = request.getSession();
//	session.setAttribute("user", validUser);
//	
//	response.setHeader("Content-Type", "application/json");
//	response.getWriter().write(mapper.writeValueAsString(validUser));
//}else {
//	response.setStatus(401);
//	response.getWriter().write("");
//}
//}
//
//}










