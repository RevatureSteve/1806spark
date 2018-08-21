package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LifeCycleServlet extends HttpServlet { //httpservlet is a type of abstract class because you cannot instantiate
	
	/*
	 * URL - /life
	 * 
	 * every object in Java has a lifecycle: new -> use -> destroy
	 * 
	 * What is the lifecycle of a Servlet?  IQ
	 * 	init()     - (only once)  called on the first request to that specific servlet by *default*. Tomcat instantiating and calling init() 
	 * 	service()	- (called every request) it's job is to parse the request and determine the request method type
	 * 	destroy()	- not apart of the request cycle, randomly called by the webcontainer to save memory... but is called at shutdown of the server
	 * 
	 *  What is the heirachy for servlets? IQ
	 *  		-Servlet Interface
	 *  		-GenericServlet abstract class
	 *  		-HttpServlet abstract class
	 *  		-developer's servlets like LifeCycleServlet
	 *  
	 *  IQ (shouldn't have to be asked, should be told when initially describing the init method)
	 *  How can I change the default of the init() to be when the server starts instead of first request???
	 *  	Use the load-on-startup child tag of the servlet tag in the web.xml
	 *  		I would want to "eagerly load" (not persistence so technically wrong terminology)
	 *  		to allow the first request for a user to be faster!
	 *  
	 *  	load-on-startup for LifeCycleServlet's init invoked when tomcat starts (faster)
	 *  	HelloWorldServlet is not so it's init invoked on first request (slower)
	 *  
	 *  Methods of Servlet Interface?
	 *  	- inut
	 *  	- service
	 *  	- destroy
	 *  	All abstract
	 *  
	 *  Methods of GenericServlet?
	 *  	-inut
	 *  	-service
	 *  	-destroy
	 *  	
	 *  	init/destroyed implemented but service is not because we do not know the protocol at this class level 
	 *  
	 *  Methods of HttpServlet?
	 *  	-init, service, destroy 
	 *  	-implements service to handle httprequests
	 *  	-do* methods like doGet(), doPost(), doDelete() etc. 
	 */
	@Override //need to override 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		System.out.println("/life -GET");	
		
	}
	
	@Override
		public void destroy() {
		System.out.println("life cycle-destroy() called");
			super.destroy();
		}
	
	@Override
		public void init() throws ServletException {
		System.out.println("life cycle -init() called");
			super.init();
		}
	
	@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("lifecycle- service() called (not business logic");
		/*
		 * what is the point of the service?
		 * 	parses the request meta data for the method type
		 * 		based upon the request method type (GET, POST, PUT, etc)
		 * 		will call the corresponding do* method 
		 * 	
		 * 
		 */
			super.service(req, resp);
		}

}
