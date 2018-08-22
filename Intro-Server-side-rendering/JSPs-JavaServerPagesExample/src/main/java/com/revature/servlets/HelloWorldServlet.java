package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorldServlet extends HttpServlet {

	/** 
	 * 	urls that end in /hello 
	 */
	private static final long serialVersionUID = -8313834183301309288L;

	/*
	 * Remember the doGet/doPost Signature - IQ
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		System.out.println("HelloWorldServlet - doGet");
		 
		String name = getServletContext().getInitParameter("myName");
		System.err.println(name);
	}
	
	
	
	
	
} 
