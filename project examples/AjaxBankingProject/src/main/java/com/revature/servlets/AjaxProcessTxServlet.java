package com.revature.servlets;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AjaxProcessTxServlet
 */
@WebServlet("/ajaxProcessTx")
public class AjaxProcessTxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxProcessTxServlet() {
        super();
    }



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.err.println("AjaxProcessTxServlet -POST");
//	
//		System.out.println(request.getHeader("key"));
//		
//		ObjectMapper jackson = new ObjectMapper();
		
		System.out.println(request.getHeader("key"));
		Map<String, String[]> myMap = request.getParameterMap();
		
		Set<String> mySet =  myMap.keySet();
		
//		mySet.forEach((s)->System.out.println(s));
		System.out.println(mySet.toArray()[0]);
		
		
	}

}
