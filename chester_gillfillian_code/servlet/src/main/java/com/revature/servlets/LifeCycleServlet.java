/**
 * 
 */
package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ChesTer
 *
 */
public class LifeCycleServlet extends HttpServlet{
	
	/* url - /life
	 * 
	 *Every object in java has a lifeCycle: now -> use -> destroy
	 *
	 *what is the lifecycle of a servlet?
	 *  init()      -(only once) called on the first request to that specific servlet by *default*
	 *  
	 *  service()   - called every request and its job is to parse the request and determine the request method type
	 *  destroy()   - not a part of request cycle, randomly called by the web container to save memory
	 *  					but it is called at shutdown
	 *  
	 *  I.Q (should not have to be asked bc should told when initially describing the init method)
	 *  how can i change the default of the init() to be when the server starts instead of first request?
	 *  		used the load on startup child tag of the servlet tag in the web.xml
	 *  				i would want to eargerly load ( not persistence so technically wrong terminally)
	 *  				to allow the first request for user to be faster
	 *  
	 *  **load on startup for LifeCycleServlet is being used and invoke when tomcat starts
	 *  HelloWorldServlet is not so it will its init invoked on the first request(slower)
	 *  
	 *  what is the hierachy for servlets?
	 *  	-Servlet interface
	 *  	-GenericServlet Abstract Class
	 *  	-HttpServlet Abstract Class
	 *  	-Developer's Servlets like LifeCycleServlet
	 *  
	 *  
	 *  Method of servlet Interface?
	 *  	-init
	 *  	-service
	 *  	-destroy
	 *  	All Abstract
	 *  
	 *  method of generic Servlet?
	 *  	-init 	
	 *  	-service
	 *  	-destroy
	 *  	some of implemented which?
	 *  	init/destroy are implemented but service is not since we dont know the protocol 
	 *  	at this class level
	 *  
	 *  methods of HttpServlet?
	 *  	-init, service, destroy
	 *      -implements service to handle HttpRequests
	 *      -do *methods like doGet(), doPost(), doDelete, etc...
	 *  
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		System.out.println("Hello World life -GET"); }
//	to generete the lifecycle just press control and space then look there names up!
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("LifeCycle -init() called");
		super.init();
	}
	
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		System.out.println("Hello World service -GET"); }
    /*
     *  what is the point of the service()?
     *  	parse the request meta data for the method type
     *  	based upon the request method type (get, post, put, etc)
     *   	will call the corresponding do *method*
     * 
     */
    
	public LifeCycleServlet() {
		// TODO Auto-generated constructor stub
		System.out.println("LifeCycle -service() called (not the busines logoc)");
	}
	
	
	protected void destroy(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		System.out.println("Hello World destroy -GET"); }
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("LifeCycle - destroy() called ");
		super.destroy();
	}

}
