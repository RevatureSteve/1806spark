package com.revature.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForwardVsRedirectServlet extends HttpServlet {
	/*
	 * url - /forwardVsRedirect
	 */

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		System.out.println("forwardVsRedirect -GET");
		// forward to an html file
		// do not put it in WEB-INF, it's private
		RequestDispatcher rd = req.getRequestDispatcher("app.html");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("forwardVsRedirect -POST");
//		req.getRequestDispatcher("app.html").forward(req, resp);
		resp.sendRedirect("hello");
	}
}
