package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet{

	/*
	 *  url /login
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(getServletName() + " doGet");
		resp.sendRedirect("form.html");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(getServletName() + " doPost");
		  	
		//Store user information into the Session
		HttpSession session = req.getSession();
		session.setAttribute("theUsername", req.getParameter("username"));
		System.out.println(req.getParameter("password") + " login");
		req.getRequestDispatcher("home.jsp").forward(req, resp);
	}
}
