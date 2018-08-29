package com.revature.servlets;

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
     * @see HttpServlet#HttpServlet()
     *  URL *base*  - / 
     */
    public DocumentationServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GET - forwarding");
		request.getRequestDispatcher("index.html").forward(request, response);
//		response.getWriter().append("Served at: ").append(request.getContextPath());

		System.out.println("[LOG]--------DocumentationServlet----GET");
//		request.getRequestDispatcher("documentation.html").forward(request, response);
//		response.sendRedirect("/TodoList-Restful-API/documentation.html");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
