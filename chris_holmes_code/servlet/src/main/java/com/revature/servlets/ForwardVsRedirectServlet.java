package com.revature.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForwardVsRedirectServlet extends HttpServlet {
	
	/*
	 * URL - /forwardVsRedirect
	 */

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		System.out.println("ForwardVsRedirect - GET");
		//forward the request to an html file
		//DO NOT PUT THE HTML FILE IN WEB-INF, it is private!
		RequestDispatcher rd = req.getRequestDispatcher("app.html");// the path starts at webapp
		rd.forward(req, resp);//forward takes 2 parameters, the req/resp
	}
	
	
	/*
	 * How can I invoke this method?
	 * 		- postman: change the request to POST
	 * 
	 * 
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		System.out.println("ForwardVsRedirect - POST");
		resp.sendRedirect("hello");
	}
	
}
