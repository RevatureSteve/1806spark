package com.revature.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.domain.Task;
import com.revature.service.AppService;

/**
 * Servlet implementation class TodoId
 */
public class TodoIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AppService app = new AppService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TodoIdServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("TodoIdServlet -GET");
		System.out.println("The id of the User is: " + request.getParameter("userId"));

		List<Task> userTasks = app.getTasksByUserId(Integer.parseInt(request.getParameter("userId")));

		ObjectMapper mapper = new ObjectMapper();

		String json = mapper.writeValueAsString(userTasks);
		response.setContentType("application/json");
		response.getWriter().write(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
