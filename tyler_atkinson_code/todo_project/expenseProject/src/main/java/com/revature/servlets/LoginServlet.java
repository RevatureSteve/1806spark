package com.revature.servlets;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.domain.Users;
import com.revature.service.AppService;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private AppService appService = new AppService();
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("[LOG]-----LoginSevlet---POST");
		BufferedReader br = request.getReader();
		
		ObjectMapper mapper = new ObjectMapper();
		Users inputUser = mapper.readValue(br, Users.class);
		System.out.println("[LOG]-----LoginServlet----inputUser: " + inputUser);
		
		Users validUser = appService.login(inputUser);
		
		if(validUser != null) {

		response.setHeader("Content-Type", "application/json");
		response.getWriter().write(mapper.writeValueAsString(validUser));
		}else {
			response.setStatus(401);
			response.getWriter().write("");
		}
	}


	
}