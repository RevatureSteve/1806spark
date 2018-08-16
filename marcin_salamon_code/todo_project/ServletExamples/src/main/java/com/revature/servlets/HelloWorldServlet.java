package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * how do I make a class follow is-a servlet
 * you mean specifically HttpServletgm
 * extends HttpServlet
 */
public class HelloWorldServlet extends HttpServlet{

	/*
	 * a servlet to handle requests and send back responses
	 * now i must decide what endpoint this servlet will handle
	 * 
	 * URL- /hello
	 */
	
	//handles a get request at the endpoint
	//this method must override the parent's method
	//IQ: remember the do* signatures
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		System.out.println("Hello World -GET");
		
		resp.getWriter().write("<h1>Hello World</h1>");
	}
}
