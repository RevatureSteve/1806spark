package com.drake.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DocumentationServlet
 */
public class DocumentationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     *  URL - /Project1 
     */
    public DocumentationServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("[LOG]--------DocumentationServlet----GET");
//		request.getRequestDispatcher("documentation.html").forward(request, response);
		response.sendRedirect("/Project1/index.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}