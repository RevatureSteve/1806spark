package com.revature.servlet;

import java.io.Console;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 
 * How do I maake a class follow as a aServlet?
 * 	 You specifically  mean an HTTP Servlet right?
 * 		Great that SIMPLE!!!
 * 			....extends HttpServlet (abstract class).
 * 
 * 		* note HttpServelet is a class found from the specific implementation of web container software you chose like tomcat or weblogin
 */
public class HelloWorldServlet extends HttpServlet {
	
	/*
	 * A servlet to handle requests an send back responses
	 * Not I must decide what endpoint this Servlet will handle.
	 * URL: /hello
	 *
	 */
	
	//hangle s get reques tat the endpoint / hello
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
			System.out.println("Hello World -GET");
	}
	

}
