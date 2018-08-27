package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.util.RequestViewHelper;

@WebServlet("*.view")
public class LoadViewServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("[LOG] - Request sent to LoadViewServlet.doGet()");
		
		String nextView = new RequestViewHelper().process(req, res);
		System.out.println(nextView);
		
		req.getRequestDispatcher(nextView).forward(req, res);
	}
}
