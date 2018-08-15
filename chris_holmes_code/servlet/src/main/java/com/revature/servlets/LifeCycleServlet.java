package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LifeCycleServlet extends HttpServlet{
	
	/*
	 * URL - /life
	 * 
	 * Every object in Java has a lifecycle: new -> use -> destroy
	 * 
	 * What is the lifecycle of a Servlet?
	 * 		init()		- (only once) called on the first request to that specific servlet by default
	 * 		service()	- called every request and its job is to parse the request and determine the request method type
	 * 		destroy()	- not a part of the request cycle, randomly called by the webcontainer to save memory
	 * 						but it is called at shutdown
	 * 
	 * I.Q.(shouln't have to be asked, should be told initially when describing init
	 * How can I change the default of the init() to be when the server starts instead of the first request?
	 * 		Use the load-on-startup child tag of the servlet tag in the web.xml
	 * 			I would want to "eagerly load" (not persistence so technically wrong terminally)
	 * 			to allow the first request for a user to be faster!
	 * 
	 * 		load-on-startup for LifeCycleServlet' init invoked when tomcat starts
	 * 		HelloWorldServlet is not so its init invoked on first request(slower)
	 * 
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		System.out.println("/life -GET");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("LifeCycle -init() called");
		super.init();
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("LifeCycle - service called (not a business logic method");
		super.service(req, resp);
		/*
		 * what is the point of the service()?
		 * 		parses the request meta data for the method type
		 * 			based upon the Request Method Types (GET, POST, PUT etc)
		 * 			will call the corresponding do* method
		 * 
		 * 
		 * What is the heirarchy for servlets?
		 * 		- Servlet Interface
		 * 		- GenericServlet Abstract Class
		 * 		- HttpServlets 
		 * 		- Developer's Servlets like LifeCycleServlet
		 * 
		 * Methods of Servlet Interface?
		 * 		- init
		 * 		- service
		 * 		- destroy
		 * 		All abstract
		 * 
		 * Methods of GenericServlet?
		 * 		- init
		 * 		- service
		 * 		- destroy
		 * 		init and destroy is implemented but
		 * 			service is not since we don't know the protocol
		 * 			at this class level
		 * 
		 * Methods of HttpServlet
		 * 		- init, service, destroy
		 * 		- implements service to handle httprequests
		 * 		-do* methods like doGet(), doPost(), doDelete(), etc.
		 *
		 */
	}
	
	@Override
	public void destroy() {
		System.out.println("LifeCycle -destroy() called");
		super.destroy();
	}
}
