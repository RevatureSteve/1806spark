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
 * Servlet implementation class TodoIdServlet
 */
public class TodoIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     * URL - /task/id
     */
	private AppService appService = new AppService();
	
    public TodoIdServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("TodoIdServlet - GET");
		
		//get the request parameter and conver from string to int
		int id = Integer.parseInt(request.getParameter("userId"));
		System.out.println("The id of the User is: " + request.getParameter("userId"));
		
		//use the int id to retrieve the task of that userId from the AppService (which will probably call the dao and the dao hits the db)
		List<Task> userTasks = appService.getTaskByUserId(id);
		
		// Now I have a list of userTask but I need to convert to a JASON string before responding back
		ObjectMapper mapper = new ObjectMapper();
		
		String json = mapper.writeValueAsString(userTasks);
		
		response.setContentType("application/json");
		response.getWriter().write(json);//send back the JSON String UserTasks
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
