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

public class ToDoServlet extends HttpServlet{

	/*
	 * url -/task (this endpoint will get all tasks)
	 * if you wanted a single task create an endpoint for - /task/{id}
	 * 
	 * 
	 * 
	 */
	private AppService appService = new AppService(); //available for other methods in the future 
	
	//based on Restful standards, this method should return all tasks
	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException{
		// 3 ways of sending back a response
				//printwriter, forward, redirect (Ways of sending back response)
		
//		List<Task> tasks = new ArrayList<>();
//		tasks.add(new Task(1,1,"go for run",1,"pending"));
//		tasks.add(new Task(2,2,"go for walk",1,"completed"));
//		tasks.add(new Task(3,3,"go for sprint",1,"cancelled"));
		
		// fasterxml jackson, the standard for converting java object to/from json string
		
		//How can I retrieve all tasks
		// This servlet calls the service, service calls the dao, dao calls the db
		List<Task> tasks = appService.getAllTasks();
		
		
		
		
		
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(tasks);
		
		resp.setContentType("application/json");
		// example using a printwriter to send response ... note this is not a JSON String just misc toString code
		PrintWriter out = resp.getWriter(); //notice PrintWriter comes from the HttpServletResponse getWriter() method\
		out.print(json);
	}
	
	
	
	
}
