/**
 * 
 */
package com.revature.servelets;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;


/**
 * @author sethc
 *
 */

/*
 * how do i make a class follow a servlet?
 * 	-you specifically mean an httpServlet right? 
 * 	 - great that is simple!!!
 *  - extend httpServelet 
 *  
 *  **note: HttpServlet is a class found from the specific implementation
 *  		of web container software you chose like tomcat or weblogic**
 */
public class HelloWorldServlet extends HttpServlet {
	
	/*
	 *  a servlet tohandle request and send back responses 
	 *  now i must decide what endpoint this servlet will handle
	 *  
	 *  url- / hello
	 */

     // handle a get request at the endpoint /hello
	// this method must override the parent's method
	// IVQ: remember to do* signatures (doGet, doPost etc signatures)
	
	protected void doGet(HttpServlet req, HttpServletResponse resp) throws IOException, ServletException{
    System.out.println("Hello World -Get");
	}

}
