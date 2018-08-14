package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorldServlet extends HttpServlet{
	/*
	 * How do you make a class follow is-a Servlet?
	 * 		You mean an HTTP Servlet right?
	 * 		...extend HTTPServlet
	 * 
	 * 		*note: httpServlet is a class found fromm the
	 */
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		System.out.println("Hello World -Get");
		PrintWriter out = resp.getWriter();
		out.write("<h1>Hello World! " + req.getParameter("username") + "</h1>");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("hello world -init() called");
		super.init();
	}
}
