package com.revature.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorldRedirectServlet extends HttpServlet {

	/*
	 * Send the client an html page
	 * 	 
	 * 		url - /redirectHelloWorld 
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws IOException, ServletException{
		System.out.println("HelloWorldRedirectServlet - doGet");

		/*
		 * redirect
		 * -give a url or html page (any resource will do)
		 * -the response will tell the client to send another request for this resource
		 * -Pro: Can manipulate the url
		 * -Con: slower as total of 2 requests
		 */ 
//		response.sendRedirect("hello");
		 /*
		  * forward
		  * -give a html page
		  * - the contents of the specified resource will be sent back to the client
		  * - Pro: Faster as total of 1 request
		  * - Con: Url doesn't change
		  */
		

		
		RequestDispatcher rd = req.getRequestDispatcher("helloWorld.html");
		rd.forward(req, response);
	}
	
}
