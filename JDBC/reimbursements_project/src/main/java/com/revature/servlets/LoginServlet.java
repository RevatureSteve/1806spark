package com.revature.servlets;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.service.VerificationService;

public class LoginServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8431430892643244256L;
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		//3 ways of sending back a response
			//printwriter, forward, redirect
		System.out.println("Login up");
		
		
		String email = (String) req.getAttribute("email");
		String password = (String) req.getAttribute("password");
		
		System.out.println(email + " " + password);
		Enumeration n = req.getAttributeNames();
		while(n.hasMoreElements()) {
			System.out.println(n.nextElement().toString());
		}
		boolean verified = VerificationService.verifyUsernameAndPassword(email, password);
		//user printwriter note this is not json String just misc toString code
		PrintWriter out = resp.getWriter();
		out.print(verified);
	}
}
