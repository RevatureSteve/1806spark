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

public class ToDoServlet extends HttpServlet {
	/*
	 * url - /task
	 */
	
	private AppService appService = new AppService();//available for other methods in the future

	// based on Restful standards this method should return ALL tasks
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
	//3 ways of sending back a response
			//printer Writer, forward, redirect
//		List<Task> tasks = new ArrayList<>();
		//original hardcoded test but making dynamic from the DB!
//		tasks.add(new Task (1, 1, "go,  for run", 1, "pending"));
//		tasks.add(new Task (2, 1, "go for walk", 2, "completed"));
//		tasks.add(new Task (3, 1, "go,  for sprint", 3, "cancelled"));
		
		//How can I retrieve ALL the tasks from the database?
		//This servlet calls the Service, Service calls the dao, dao calls the db
		List<Task> tasks = appService.getAllTasks();
		
		/*
		 * fasterxml jackson, the standard for converting java object to and from json string
		 */
		ObjectMapper mapper = new ObjectMapper();
		
		String json = mapper.writeValueAsString(tasks);
		resp.setContentType("application/json");

//use a printwriter...note this is not a JSON String just misc toString code
PrintWriter out = resp.getWriter();//notice we retrieve the PrintWriter from: the HttpServletResponse
out.print(json);
	}
}
