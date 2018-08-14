package com.revature.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForwardVsRedirectServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		System.out.println("forwardVsRedirect -GET");
		//forward 
		RequestDispatcher rd = req.getRequestDispatcher("app.html");
		rd.forward(req, resp); //forward takes 2 parameters the req/resp
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("forwardVsRedirect -POST");
		resp.sendRedirect("hello");
	}

}
