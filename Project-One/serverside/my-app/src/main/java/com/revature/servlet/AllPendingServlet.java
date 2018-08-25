package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.logic.ReqLogic;
import com.revature.pojo.TranstarReims;

/**
 * Servlet implementation class AllPendingServlet
 */
public class AllPendingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReqLogic req = new ReqLogic();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllPendingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("GET- REQ");
		
		List<TranstarReims> reimList = req.getAllReq();
		ObjectMapper mapper = new ObjectMapper();
		
		String json = mapper.writeValueAsString(reimList);
		response.setContentType("application/json");
		
		PrintWriter out = response.getWriter();
		out.print(json);
	}



}
