package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PrintServlet extends HttpServlet{

	/*
	 * Servlet that DIRECTLY sends back a response
	 * 
	 * 		url endpoint - /print
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		System.out.println("PrintServlet - doGet");
		PrintWriter out = resp.getWriter();
		out.write("<h1>Printing directly from a Servlet</h1>");
		out.write("<h1>Printing directly from a Servlet2</h1>");
		out.write("<h1>Printing directly from a Servlet3</h1>");
	}
	
}
