package com.revature.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForwardVsRedirectServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		System.out.println("ForwardVsRedirect -GET");
		// forward the request to a html file
		// donot put the html files  in web-inf, it is private
		
	RequestDispatcher rd =	req.getRequestDispatcher("app.html"); // the pat start with web.xml
	rd.forward(req, resp);  // forward take 2 parameter the req and resp
	}
    
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
	     System.out.println("forwardVsRedirect -POST");
	     req.getRequestDispatcher("app.html").forward(req, resp);
	}
}
