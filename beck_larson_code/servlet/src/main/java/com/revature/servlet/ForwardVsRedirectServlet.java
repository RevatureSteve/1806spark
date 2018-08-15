package com.revature.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForwardVsRedirectServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		System.out.println("forwardVsRedirect - GET");
		
		RequestDispatcher rd = req.getRequestDispatcher("app.html");
		rd.forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		System.out.println("forwardVsRedirct - POST");
		resp.sendRedirect("hello");
	}
}
