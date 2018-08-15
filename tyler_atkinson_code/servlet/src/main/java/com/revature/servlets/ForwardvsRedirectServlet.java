package com.revature.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForwardvsRedirectServlet extends HttpServlet {
	
	/*
	 * URL - /forwardVsRedirect
	 */
@Override
	protected void doGet (HttpServletRequest req, HttpServletResponse resp)throws IOException, ServletException {
		System.out.println("Forward vs Redirect -GET");
	
		RequestDispatcher rd = req.getRequestDispatcher("app.html");
		rd.forward(req, resp);
		

	}
	

/*
 * How can I invoke this methodVV
 * -postman: change request to post
 * 
 */

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
	 System.out.println("FVR Post");
	 resp.sendRedirect("http://www.google.com");
 }

}
