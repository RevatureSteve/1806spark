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
 * Servlet implementation class UpdateRequestServlet
 */
public class UpdateRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReqLogic req = new ReqLogic();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateRequestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get- update");
		int reqId = 0;
		int reqStatus = 0;
		
		
        reqId = Integer.parseInt(request.getParameter("req_id")); 
        reqStatus = Integer.parseInt(request.getParameter("req_status")); 
        int mgrId = Integer.parseInt(request.getParameter("mgr_id")); 
		
		int reimList = req.updateReq(reqId, reqStatus, mgrId);
		ObjectMapper mapper = new ObjectMapper();
		
		String json = mapper.writeValueAsString(reimList);
		response.setContentType("application/json");
		
		PrintWriter out = response.getWriter();
		out.print(json);
	}


}
