package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




/**
 * Url: /documentation
 * @author Jasmine C Onwuzulike
 *
 */

public class DocumentationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DocumentationServlet() {
        super();
      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LOG____DocumentationServlet-GET");
	request.getRequestDispatcher("index.html").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
