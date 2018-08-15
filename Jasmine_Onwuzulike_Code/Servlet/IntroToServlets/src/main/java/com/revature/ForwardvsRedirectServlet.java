package com.revature;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForwardvsRedirectServlet extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException  {
		System.out.print("GET");
		
		
	PrintWriter out = res.getWriter();
	out.println("<h1>Hello Word</h1>");
		
		
		
	}
	
	
	//Do not put HTML in WEB-INF; it is provate.
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		System.out.print("POST");
		RequestDispatcher rd = req.getRequestDispatcher("app.html");
		rd.forward(req, res);
	}
	
}
