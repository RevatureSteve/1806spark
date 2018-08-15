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
     * 	URL - /task/id
     */
	private AppService appService = new AppService();
	
    public TodoIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("TodoIdServlet - GET");
		
		//	Get the request parameter and convert from String to int
		int id = Integer.parseInt(request.getParameter("userId"));
		System.out.println("The id of the User is: " + id);
		
		//	Use the int id to retrieve the tasks of that userId from the AppService, which will probably call the dao and the dao hits the db
		List<Task> userTasks =  appService.getTasksBytUserId(id);
		
		//	Now I have a list of userTask but I need to convert to a JSON string before responding back
		ObjectMapper mapper = new ObjectMapper();
		
		String json = mapper.writeValueAsString(userTasks);
		response.setContentType("application/json");
		response.getWriter().write(json); //	send back the JSON String of UsserTasks
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
