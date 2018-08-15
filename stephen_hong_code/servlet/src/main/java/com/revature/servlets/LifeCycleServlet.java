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
	 * 	Every object in Java has a life cycle: new -> use -> destroy
	 * 
	 * 	IQ: What is the life cycle of a Servlet?
	 * 		init()			- (only once) called on the 1st request to that specific servlet by default
	 * 		service()		- called every request and it's job is to parse the request and determine the request method type
	 * 		destroy()		- not part of the request cycle, randomly called by the web container to save memory
	 * 							but is called at shutdown of the server
	 * 
	 * 	IQ (should be told when initially describing the init method)
	 * 	How can I change the default of the init() to be when the server starts instead of 1st request?
	 * 		Use the load-on-startup child tag of the servlet tag in the web.xml
	 * 			I would want to "eagerly load" (not persistence so technically wrong terminally)
	 * 			to allow the 1st request for a user to be faster!
	 * 
	 * 		load-on-startup for LifeCycleServlet's init invoked when Tomcat starts(faster)
	 * 		HelloWorldServlet is not, so it's init invoked on 1st request(slower)
	 * 
	 * 	IQ: What is the hierachy for servlets?
	 * 		- Servlet Interface
	 * 		- GenericServlet Abstract Class
	 * 		- HttpServlet Abstract Class
	 * 		- Developer's Servlets like LifeCycleServlet
	 * 
	 * 	Methods of the Servlet Interface
	 * 		- init()
	 * 		- service()
	 * 		- destroy()
	 * 		All abstract
	 * 
	 * 	Methods of GenericServlet
	 * 		- init()
	 * 		- service()
	 * 		- destroy()
	 * 		init & destroy are implemented but service is not because we don't know the protocol at this class level
	 * 
	 * 	Methods of HttpServlet
	 * 		- init, service, destroy
	 * 		- implements service to handle httprequests
	 * 		- do* methods like doGet(), doPost(), doDelete() etc.
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
		System.out.println("LifeCycle -service() called (not business logic method)");
		/*
		 * 	service() parses the request meta data for the method type
		 * 		based upon the Request Method Type (GET, POST, PUT etc)
		 * 		will call the corresponding do* method
		 */
		super.service(req, resp);
	}
	@Override
	public void destroy() {
		System.out.println("LifeCycle -destroy() called");
		super.destroy();
	}

}