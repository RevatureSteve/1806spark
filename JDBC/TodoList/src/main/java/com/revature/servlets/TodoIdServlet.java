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
	
    /**
     * @see HttpServlet#HttpServlet()
     * URL - /task/{id}
     */
	
=======
       
    /**
     * @see HttpServlet#HttpServlet()
     * URL - /task/id
     */
>>>>>>> 8ff4b17dd674ea7826c6e1af98f02d7fae8acae8
	private AppService appService = new AppService();
	
    public TodoIdServlet() {
        super();
<<<<<<< HEAD
        // TODO Auto-generated constructor stub
=======
>>>>>>> 8ff4b17dd674ea7826c6e1af98f02d7fae8acae8
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("TodoIdServlet -GET");
		
<<<<<<< HEAD
		// Get the request parameter and convert from String to int
		int id = Integer.parseInt(request.getParameter("userId"));
		System.out.println("The id of the User is: " + id);
		
		// Use the int id to retrieve the taska that userId from the AppService (which will probably call the dao and the dao hits the db
		List<Task> userTasks = appService.getTasksByUserId(id);
		
		// Now I have list of userTask but I need to convert to a JSON string before responding back
=======
		// Get the request parameter and convert from String to int 
		int id = Integer.parseInt(request.getParameter("userId"));
		System.out.println("The id of the User is: " +  id);
		
		// Use the int id to retrieve the tasks of that userId from the AppService (which will probably call the dao and the dao hits the DB)
		List<Task> userTasks = appService.getTasksByUserId(id);
		
		
		// Now i have list of userTask but I need to convert to a JSON string before responding back
>>>>>>> 8ff4b17dd674ea7826c6e1af98f02d7fae8acae8
		ObjectMapper mapper = new ObjectMapper();
		
		String json = mapper.writeValueAsString(userTasks);
		response.setContentType("application/json");
		response.getWriter().write(json); // send back the JSON String of UserTasks
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
<<<<<<< HEAD
		// TODO Auto-generated method stub
=======
>>>>>>> 8ff4b17dd674ea7826c6e1af98f02d7fae8acae8
		doGet(request, response);
	}

}
