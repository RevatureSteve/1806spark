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
	 * url- /task/{id/name/status}
	 * 
	 * 
	 * doGet is a method name for java, not http requests 
	 * 
	 * 
	 * 
	 * below are interview questions
	 */
	//based on Restful standards this method should return ALL tasks 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		//3 ways of sending back a response 
			// printwriter, forward, redirect
		
		List<Task> tasks = new ArrayList<>();
		tasks.add(new Task(1, 1, "go for run", 1, "pending"));
		tasks.add(new Task(2, 2, "go for walk", 1, "completed"));
		tasks.add(new Task(3, 3, "go for sprint", 1, "cancelled"));
		
		//use a printwriter... note this is not a JSON String  just misc toString code
		PrintWriter out = resp.getWriter(); // notice we retrieve the PrintWriter from: the HttpServletRespone 
		out.print(tasks);
	}
	

}
