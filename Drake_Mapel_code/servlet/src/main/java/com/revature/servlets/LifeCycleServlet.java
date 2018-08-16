package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LifeCycleServlet extends HttpServlet {
	
	/*
	 * 	URL - /life
	 * 
	 * 	Every object in Java has a lifecycle: new -> use -> destroy
	 * 
	 * 	What is the lifecycle of a Servlet?
	 * 		init()			-(only once, [unless destroy() is called]) called on the first request to that specific servlet by *default*
	 * 		service()		-called every request and it's job is to parse the request and determine the request method type
	 * 		destroy()		-not a part of the request cycle, randomly called by the web container to save memory
	 * 							but it is called at shutdown
	 * 
	 * 	How can I change the default of the init() to be when the server starts instead of first request?
	 * 		Use the load-on-startup child tag of the servlet tag in the web.xml
	 * 			I would want to "eagerly load" (like persistance, but does not fall under that so technically wrong terminology)
	 * 			to allow the first request for a user to be faster!
	 * 
	 * 	What is the hierarchy for servlets?
	 * 		-Servlet Interface
	 * 		-GenericServlet Abstract Class
	 * 		-HttpServlet Abstract Class
	 * 		-Developer's Servlets like LifeCycleServlet
	 * 
	 * 	Methods of Servlet Interface?
	 * 		-init
	 * 		-service
	 * 		-destroy
	 * 		-All abstract
	 * 
	 * 	Methods of GenericServlet?
	 * 		-init
	 * 		-service
	 * 		-destroy
	 * 		init and destroy are implemented, but
	 * 			service is not since we don't know the protocol
	 * 			at this class level
	 * 
	 * 	Methods of HttpServlet?
	 * 		-init, service, destroy
	 * 		-implement service to handle httprequests
	 * 		-do* methods like doGet()
	 */
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		System.out.println("/life -GET");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("LifeCycle -init() called");
		super.init();
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("LifeCycle -service() called (not a business logic method)");
		/*
		 * 	what is the point of the service()?
		 * 		parses the request meta data for the method type
		 * 			based upon the Request Method Types (GET, POST, PUT, etc.)
		 * 			will call the corresponding do* method
		 */
		super.service(req, resp);
	}
	
	@Override
	public void destroy() {
		System.out.println("LifeCycle -destroy() called");
		super.destroy();
	}

}
