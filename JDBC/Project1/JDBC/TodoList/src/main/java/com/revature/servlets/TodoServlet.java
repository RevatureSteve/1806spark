package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.domain.Task;
import com.revature.service.AppService;

public class TodoServlet extends HttpServlet {
	/*
	 * url - /task
	 */
	private AppService appService = new AppService();//available for other methods in the future
	
	//based on restful standards this method should return all tasks
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		//3 ways of sendig back a response
			//printwriter, forward and redirect
		//List<Task> tasks = new ArrayList<>();
		
/*		//hard code it
		tasks.add(new Task(1, 1, "got for a run", 1, "completed"));
		tasks.add(new Task(2, 2, "got for a jog", 2, "pending"));
		tasks.add(new Task(3, 3, "got for ice cream",3, "completed"));*/
		
		/*
		 * How can I retrieve all the tasks from the database?
		 * 		this servlet calls the service
		 * 		the service calls the dao
		 * 		the dao calls the db
		 */
		List<Task> tasks = appService.getAllTasks();
		
		/*
		 * we needed a new jar so we added fasterxml Jackson to our dependencies
		 * 		this is going to be responsible for converting java objects to JSON
		 */
		ObjectMapper mapper = new ObjectMapper();
		
		String json = mapper.writeValueAsString(tasks);//create our JSON conversion of our task
		resp.setContentType("application/json");//sets it so you can see it client side when you inspect it
		
		//use a printwriter
		//not this is a JSON String, just misc toString code
		PrintWriter out = resp.getWriter();//notice we retrieve the PrintWriter from: the HttpServletResponse
		out.print(json);
	}
}
