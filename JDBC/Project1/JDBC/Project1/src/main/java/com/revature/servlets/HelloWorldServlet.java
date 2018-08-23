package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.service.BusinessLogic;

public class HelloWorldServlet extends HttpServlet{

	
	private BusinessLogic businessLogic = new BusinessLogic();
	/*
	 * This servlet is used for testing
	 * 
	 * URL endpoint is /hello
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		System.out.println("HelloWorldServlet - GET");
	}
}