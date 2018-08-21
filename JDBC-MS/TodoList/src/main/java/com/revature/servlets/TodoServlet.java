package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.Task;

public class TodoServlet extends HttpServlet{
	/*
	 * url - /task
	 */
	
	
	//based on restufl standards this method should return ALL tasks
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		//3 ways of sending back a response
			//printwriter, forward, redirect
		
		List<Task> tasks = new ArrayList<Task>();
		tasks.add(new Task(1,1, "go for a run", 1, "pending"));
		tasks.add(new Task(2,2, "go for a walk", 2, "completed"));
		tasks.add(new Task(3,3, "go for a spring", 3, "cancelled"));
		
		PrintWriter out = resp.getWriter();
		out.print(tasks);
	}
}
