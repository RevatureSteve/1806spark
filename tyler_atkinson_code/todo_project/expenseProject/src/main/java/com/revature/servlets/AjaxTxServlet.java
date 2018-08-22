package com.revature.servlets;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AjaxTxServlet
 */
public class AjaxTxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxTxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.err.println("AjaxProcessTxServlet -POST");
		
		System.out.println(request.getHeader("Key"));
		Map<String, String []> myMap = request.getParameterMap();
		
		Set<String> mySet = myMap.keySet();
		
		System.out.println(mySet.toArray()[0]);
		
	}
	
	}


