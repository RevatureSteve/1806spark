package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LifeCycleServlet extends HttpServlet {
	
	/*
	 * URL -/life
	 * 
	 * Every object in Java has a lifecycle: new > use > destroy
	 * 
	 * Lifecycle of a servlet-  methods being called when its being used
	 * 		init()- called on 1st request to specific servlet by default (only once)
	 * 				* To change the default init method, use the load-on-startup child tag of the servlet tag in the web.xml
	 * 					- I would want to "eagerly load"- allow the first request for a user to be faster!
	 * 		service()- called every request, parses the request and determines request method type (GET, POST etc..)
	 * 			parses the request meta data for the method type
	 * based upon the request method type (GET, POST, PUT, ETC...), calls the corresponding do* method		
	 * 		destroy()- not part of request cycle, randomly called by web container to save memory
	 * 
	 ******load-on-startup for LifeCycle Servlet's init  invoked when tomcat starts HelloWorldServlet, is not, so it will 
	 *have its init is invoked on the first request
	 * 
	 * Servlet heirarchy
	 * -Servlet Interface
	 * -Generic Servlet Abstract Class
	 * -HttpServlet Abstract Class
	 * -Developers Servlets like LifeCycleServlet
	 * 
	 * Methods of servlet interface
	 * -init
	 * -service
	 * -destroy
	 * ALL ABSTRACT
	 * 
	 * Methods of GenericServlet
	 * -init
	 * -service
	 * -destroy
	 * ONLY INIT AND DESTROY ARE IMPLEMENTED, service is not since we don't know the protocol at this class level
	 * 
	 * Methods of HTTP Servlet
	 * 	-init, service, and destory
	 * 	-implements service to handle httprequests
	 * -do* methods like doGet(), doPost(), doDelete() etc...
	 * 
	 * 
	 */
@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
	System.out.println("This is lifecycle servlet");
}



@Override
public void destroy() {
	System.out.println("lifecycle- destroy() called");
	super.destroy();
}

@Override
public void init() throws ServletException {
	System.out.println("Lifecycle init () called");
	super.init();
}

@Override
public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
	System.out.println("Lifecycle service() called");
	super.service(req, res);
}


}
