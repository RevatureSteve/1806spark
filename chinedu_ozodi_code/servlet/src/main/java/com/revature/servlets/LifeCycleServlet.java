package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LifeCycleServlet extends HttpServlet {
	/*
	 * URL - /life
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		System.out.println("/life GET");
	}
	
	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("LifeCycle -init() called");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("LifeCycle -seervice() called (not a business logic method)");
		super.service(req, resp);
	}
	
	@Override
	public void destroy() {
		System.out.println("LifeCycle -destroy() called");
		super.destroy();
	}
}
