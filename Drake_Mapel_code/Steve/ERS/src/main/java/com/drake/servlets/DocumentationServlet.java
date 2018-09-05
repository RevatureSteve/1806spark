package com.drake.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DocumentationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     *  URL - /
     *  remember, must use project root name first
     */
    public DocumentationServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("[LOG]--------DocumentationServlet----GET");
		response.sendRedirect("/ERS/index.html");
	}
	
}