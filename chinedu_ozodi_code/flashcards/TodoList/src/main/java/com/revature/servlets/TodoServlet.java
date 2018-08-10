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

/**
 * url - /task
 * Should return all tasks
 * @author chin2
 *
 */
public class TodoServlet extends HttpServlet {

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		// 3 ways of sending back a response
			// printwriter, forward, redirect
		List<Task> tasks = new ArrayList<Task>();
		tasks.add(new Task(1,1, "go for run",1,"pending"));
		tasks.add(new Task(2,2, "go for walk",1,"completed"));
		tasks.add(new Task(3,3, "go for sprint",1,"cancelled"));
		
		// use a printwriter
		PrintWriter out = resp.getWriter();
		out.print(tasks);
	}

}
