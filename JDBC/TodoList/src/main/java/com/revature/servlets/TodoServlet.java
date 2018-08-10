package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.domain.Task;

public class TodoServlet extends HttpServlet {
	/*
	 * url - /task
	 */
	
	//based on restful standards this method should return all tasks
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		//3 ways of sendig back a response
			//printwriter, forward and redirect
		List<Task> tasks = new ArrayList<>();//hard code it
		tasks.add(new Task(1, 1, "got for a run", 1, "completed"));
		tasks.add(new Task(2, 2, "got for a jog", 2, "pending"));
		tasks.add(new Task(3, 3, "got for ice cream",3, "completed"));
		
		//use a printwriter
		//not this is a JSON String just misc toString code
		PrintWriter out = resp.getWriter();//notice we retrieve the PrintWriter from: the HttpServletResponse
		out.print(tasks);
	}
}
