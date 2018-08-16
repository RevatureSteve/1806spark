package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LifeCycleServlets extends HttpServlet {

	/*
	 * URL - /life
	 * 
	 * every object in Java has a lifecycle: new -> use -> destroy
	 * 
	 * what is the lifecycle of a servlet?
	 * itit()			only once, called on the first request to that specific servlet by *default*
	 * service()		called every request and it's job is to parse the request and determine the request method type
	 * destroy()		not a part of the request cycle, randomly called by the web container to save memory
	 * 						called at shutdown of the server
	 * 
	 * what is the hierarchy for servlets
	 * Servlet Interface
	 * GenericServlet Abstract Class
	 * HttPServlet Abstract Class
	 * Developer's Servlets like LifeCycleServlets
	 * 
	 * methods of servlet Interface
	 * -init
	 * -service
	 * -destroy
	 * All abstract
	 * 
	 * methods of GenericServlet
	 * -init
	 * -service
	 * -destroy
	 * init and destroy are implemented, service is not, because we don't know the protocol
	 * 
	 * methods of HttpServlet
	 * -init, service, destroy
	 * -implements service to handle httprequests
	 * 
	 * I.Q.
	 * how can i change the default of the init() to be when the server starts instead of first request?
	 * use the load-on-startup child tag of the servlet tag in the web.xml
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		System.out.println("/life -GET");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("LifeCycle -init() called");
		
		// TODO Auto-generated method stub
		super.init();
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * parses the request meta data for the method type
		 * based upon the Request Method Types (GET POST PUT etc
		 * will call the corresponding do* method
		 */
		System.out.println("LifeCycle -service() called (not business logic)");
		super.service(req, resp);
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
		System.out.println("LifeCycle -destroy() called");
		super.destroy();
	}
}
