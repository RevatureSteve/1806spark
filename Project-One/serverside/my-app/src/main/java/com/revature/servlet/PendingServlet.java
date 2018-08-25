package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.revature.logic.ReqLogic;
import com.revature.pojo.TranstarReims;

/**
 * Servlet implementation class PendingServlet
 */
public class PendingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ReqLogic req = new ReqLogic();
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("GET- REQ");
		
		int userId = Integer.parseInt(request.getParameter("u_id")); 
		int reqType = Integer.parseInt(request.getParameter("req_type")); 
		
		
		System.out.println(userId + " " + reqType);
		
		List<TranstarReims> reimList = req.getReq(reqType, userId);
		ObjectMapper mapper = new ObjectMapper();
		
		String json = mapper.writeValueAsString(reimList);
		response.setContentType("application/json");
		
		PrintWriter out = response.getWriter();
		out.print(json);
	}


}
