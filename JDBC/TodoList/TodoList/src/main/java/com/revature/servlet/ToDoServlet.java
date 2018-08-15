package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.domain.Task;

public class ToDoServlet extends HttpServlet{

	/*
	 * Url - /task
	 * 
	 */
	
	//based on Restful standars this methods should return ALL tasks.
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
	//Three ways of sending back a response
		 	// printwriter, forward, redirect
		
		List<Task> tasks = new ArrayList<>();
		tasks.add( new Task(1,1, "go for run", 1, "pending" ));
		tasks.add( new Task(2,2,"go for a walk", 2, "completed" ));
		tasks.add( new Task(3,3, "go for sprint", 3, "canceled" ));

		
		// use a printwriter...note that this is not a JSON string just misc toString code.
		PrintWriter out = res.getWriter(); //notice we retrieve printwriter from the HttpServletResponse
		out.print(tasks);
	}
	
	
	
	
	
	
	
	
	
	
	
}
