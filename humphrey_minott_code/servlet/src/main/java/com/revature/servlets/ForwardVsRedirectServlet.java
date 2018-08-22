package com.revature.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForwardVsRedirectServlet extends HttpServlet{
	
	/*
	 *  URL - /forwardVsRedirect
	 */
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException,ServletException{
	
		
		
		//Do not put the html file in web-inf, it is private!
		RequestDispatcher rd = req.getRequestDispatcher("app.html"); // The path starts at webapp
		rd.forward(req, resp); 
		
	}
	
	
	/*
	 * 	How can I invoke this method?
	 * 	-Postman: change the request to post
	 * - html form tag with method type Post
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException,ServletException{

		System.out.println("ForwardVsRedirect -Post");
	
		resp.sendRedirect("hello");
	}
	
	
}
