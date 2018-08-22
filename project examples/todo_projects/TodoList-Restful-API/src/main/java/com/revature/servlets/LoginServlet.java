package com.revature.servlets;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.domain.User;
import com.revature.service.AppService;

/**
 * Servlet implementation class UserServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     *  URL /login 
     */
	private AppService appService = new AppService();
    public LoginServlet() {
        super();
    }

	/**
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("[LOG]-----LoginSevlet---POST");
		BufferedReader br = request.getReader();
		
		ObjectMapper mapper = new ObjectMapper();
		User inputUser = mapper.readValue(br, User.class);
		System.out.println("[LOG]-----LoginServlet----inputUser: " + inputUser);
		
		User validUser = appService.login(inputUser);
		
		if(validUser != null) {
			// Start a HttpSession (note this breaks Restful architecture)
			// Place User object inside Session
			HttpSession session = request.getSession();
			session.setAttribute("user", validUser);
			
			response.setHeader("Content-Type", "application/json");
			response.getWriter().write(mapper.writeValueAsString(validUser));
		}else {
			response.getWriter().write("");
		}
	}

}
