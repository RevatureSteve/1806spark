package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReimbursementServlet extends HttpServlet {
	/*
	 * 	url - /reimbursement
	 */
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		//	3 ways of sending back a response
		//	printwriter, forward, redirect
		
		// use a printwriter...note this is not a JSON String, just misc toString code
		
		System.out.println("test");
	}
}
