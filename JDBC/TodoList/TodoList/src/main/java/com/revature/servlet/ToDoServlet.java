package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.domain.Task;
import com.revature.service.AppService;

public class ToDoServlet extends HttpServlet{

	/*
	 * Url - /task
	 * 
	 */
	
	
	private AppService appservice = new AppService();
	//based on Restful standars this methods should return ALL tasks.
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
	//Three ways of sending back a response
		 	// printwriter, forward, redirect
//		
//		List<Task> tasks = new ArrayList<>();
//		tasks.add( new Task(1,1, "go for run", 1, "pending" ));
//		tasks.add( new Task(2,2,"go for a walk", 2, "completed" ));
//		tasks.add( new Task(3,3, "go for sprint", 3, "canceled" ));

		/*How can I retrieve all the tasks from the database?
		 * 
		 * The servlet calls the service, the serive calls the DAO.
		 * 
		 * 
		 */
		
		List<Task> task = appservice.getAllTasks();
		
		
		
	
		
		
		
		
		//Converting objects to and from JSON 
		ObjectMapper mapper = new ObjectMapper();
			//String json = mapper.writeValueAsString(tasks);
			
			//Sets the response content type
			res.setContentType("application/json");
		
		
		
		// use a printwriter...note that this is not a JSON string just misc toString code.
		//PrintWriter out = res.getWriter(); //notice we retrieve printwriter from the HttpServletResponse
		//out.print(json);
	}
	
	
	
	
	
	
	
	
	
	
	
}
