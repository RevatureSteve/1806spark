package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// DocumentationServlet class.

public class DocServlet extends HttpServlet {
	
	/**
	 * Generated serialVersionUID
	 */
	private static final long serialVersionUID = 5305819214983656725L;

	
	public DocServlet() {
        super();
    }

	//httpservlet doGet method to get the Api documentation from the index.html
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("[LOG]++++++DocumentationServlet++++++GET method");
		request.getRequestDispatcher("index.html").forward(request, response);
		response.sendRedirect("/documentation/index.html");
	}

	// dopost method..
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
