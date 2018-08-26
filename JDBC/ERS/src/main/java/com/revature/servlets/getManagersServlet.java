package com.revature.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.POJO.Reimbursement;
import com.revature.POJO.User;
import com.revature.service.AppService;

/**
 * Servlet implementation class getManagersServlet
 */
public class getManagersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AppService appService = new AppService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getManagersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("test");
		List<User> u = appService.getManagers(true, 2);

		ObjectMapper mapper = new ObjectMapper();

		String json = mapper.writeValueAsString(u);
		response.setContentType("application/json");
		response.getWriter().write(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
