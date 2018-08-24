package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.revature.logic.UserLogic;
import com.revature.pojo.TranstarUsers;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = null;
		String password = null;
		
		System.out.println("POST- Login");
		TranstarUsers user = new TranstarUsers();
		
		ObjectMapper mapper = new ObjectMapper();
		ServletInputStream body = request.getInputStream();
		ObjectNode n = mapper.readValue(body, ObjectNode.class);
		
		if(n.has("email")) {
			email = n.get("email").textValue();
		}
		
		if(n.has("password")) {
			password = n.get("password").textValue();
		}
		System.out.println(email + " " + password);
		user = new UserLogic().login(email, password);
		
		
		
		
		String json = mapper.writeValueAsString(user);
		
		response.setContentType("application/json");
		response.getWriter().write(json);
	}
	


}
