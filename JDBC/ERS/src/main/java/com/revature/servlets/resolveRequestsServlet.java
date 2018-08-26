package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.service.AppService;

/**
 * Servlet implementation class resolveRequests
 */
public class resolveRequestsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AppService appService = new AppService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public resolveRequestsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int rid = Integer.parseInt(request.getParameter("requestId"));
		int sid = Integer.parseInt(request.getParameter("statusId"));
		int mid = Integer.parseInt(request.getParameter("managerId"));
		System.out.println("request id: " + rid + " status id: " + sid + " manager id: " + mid);

		//response.getWriter().append("Served at: ").append(request.getContextPath());
		appService.resolveRe(mid, sid, rid);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
