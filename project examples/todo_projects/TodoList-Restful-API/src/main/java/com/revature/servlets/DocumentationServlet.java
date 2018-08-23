package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
<<<<<<< HEAD
 *  -/
=======
>>>>>>> 32d44e3ef05b21c7ba723ba186649a891c72cee6
 * Servlet implementation class DocumentationServlet
 */
public class DocumentationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
<<<<<<< HEAD
     * @see HttpServlet#HttpServlet()
=======
     *  URL *base*  - / 
>>>>>>> 32d44e3ef05b21c7ba723ba186649a891c72cee6
     */
    public DocumentationServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
<<<<<<< HEAD
		System.out.println("GET - forwarding");
		request.getRequestDispatcher("index.html").forward(request, response);
//		response.getWriter().append("Served at: ").append(request.getContextPath());
=======
		System.out.println("[LOG]--------DocumentationServlet----GET");
//		request.getRequestDispatcher("documentation.html").forward(request, response);
//		response.sendRedirect("/TodoList-Restful-API/documentation.html");
>>>>>>> 32d44e3ef05b21c7ba723ba186649a891c72cee6
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
<<<<<<< HEAD
		// TODO Auto-generated method stub
=======
>>>>>>> 32d44e3ef05b21c7ba723ba186649a891c72cee6
		doGet(request, response);
	}

}
