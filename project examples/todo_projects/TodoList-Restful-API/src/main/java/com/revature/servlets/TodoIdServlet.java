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
       
<<<<<<< HEAD
	
	private AppService appService = new AppService();
    /**
     * @see HttpServlet#HttpServlet()
     * url- /task/id
     */
    public TodoIdServlet() {
        super();
        // TODO Auto-generated constructor stub
=======
    /**
     * @see HttpServlet#HttpServlet()
     * URL - /task/id
     */
	private AppService appService = new AppService();
	
    public TodoIdServlet() {
        super();
>>>>>>> cf2b544b60c7138473f850a6d5d9eaee78ad8cef
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
<<<<<<< HEAD
		// TODO Auto-generated method stub
		System.out.println("todoidservlet - get");
		
		
		//get the request the parameter and convert from string to int
		int id = Integer.parseInt(request.getParameter("userId"));
		
		System.out.println("the id of the user is: " + id);
		
		
		// use the int id to retrieve the tasks of that userId from the appservice 
		//	which will probably call the dao and the dao hits the DB
		List<Task> userTasks = appService.getTasksByUserId(id);
		
		
		//now i have list of usertask but need to convert to a JSON string efore responding back
=======
		System.out.println("TodoIdServlet -GET");
		
		// Get the request parameter and convert from String to int 
		int id = Integer.parseInt(request.getParameter("userId"));
		System.out.println("The id of the User is: " +  id);
		
		// Use the int id to retrieve the tasks of that userId from the AppService (which will probably call the dao and the dao hits the DB)
		List<Task> userTasks = appService.getTasksByUserId(id);
		
		
		// Now i have list of userTask but I need to convert to a JSON string before responding back
>>>>>>> cf2b544b60c7138473f850a6d5d9eaee78ad8cef
		ObjectMapper mapper = new ObjectMapper();
		
		String json = mapper.writeValueAsString(userTasks);
		response.setContentType("application/json");
<<<<<<< HEAD
		response.getWriter().write(json); //send back the JSON STRING of USerTasks 
=======
		response.getWriter().write(json); // send back the JSON String of UserTasks
>>>>>>> cf2b544b60c7138473f850a6d5d9eaee78ad8cef
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
<<<<<<< HEAD
		// TODO Auto-generated method stub
=======
>>>>>>> cf2b544b60c7138473f850a6d5d9eaee78ad8cef
		doGet(request, response);
	}

}
