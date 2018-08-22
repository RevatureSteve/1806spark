package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 *  How do I make a class follow IS-A Servlet?
 *  	- You specifically mean HttpServlet right?
 * 		Great that's simple!!!!	
 * 			...extends HttpServlet
 * 
 * Note: HttpServlet is a class found from the specific implementation of web container software
 *  you chose like tomcat,.... or weblogic
 * 
 */
public class HelloWorldServlet extends HttpServlet {

	/* servlet to handle requests and send back responses
 		Now I must decide what endpoint this Servlet will handle
			This servlet will hand the endpoint /hello   (URL /hello)
	*/
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
	// point of a printWriter to respond directly from the servlet!
	System.out.print("Hello World -Get");
	PrintWriter out = resp.getWriter();
	out.write("<h1>Hello World!");
}



	
	
	
	
	
}
