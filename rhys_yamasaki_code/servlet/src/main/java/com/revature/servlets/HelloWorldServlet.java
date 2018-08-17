package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 	How do I make a class follow is-a Servlet?
 * 		- You specifically mean an HttpServlet right?
 * 		- Great that's SIMPLE!!!	
 * 		- .... extends HttpServlet
 * 
 *  *note: HttpServlet is a class found from the specific implementation
 *  		of Web Container software you choose like tomcat or weblogic*
 */

public class HelloWorldServlet extends HttpServlet{
	
	/*
	 *  A servlet to handle requests and send back responses
	 *   Now I must decide what endpoint this Servlet will handle
	 *   
	 *   URL- /hello
	 */
	
	// handle a get request at the endpoint /hello
	// this method must override the parent's method
	// IQ: remember the do* signatures
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		System.out.println("Hello World -GET");
		// point of a PrintWriter to respond directly from a Servlet!
		PrintWriter out = resp.getWriter();
		out.write("<h1>Hello World! " + req.getParameter("username") + "</h1>");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("hello world -init called");
		super.init();
	}
	
}
