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

public class TodoServlet extends HttpServlet{
	
	/*
	 * url -/task
	 */
//know this VV - based on restful standards, this method should return ALL tasks
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws IOException, ServletException{
		//3 ways of sending back a response- printwriter, forward, and redirect
		
		List <Task> tasks = new ArrayList <> ();
		tasks.add(new Task (1,1,"go for run",1,"pending"));
		tasks.add(new Task (2,2,"go for walk",2,"completes"));
		tasks.add(new Task (3,3,"go for sprint",3,"cancelled"));
		//use a printwriter
		PrintWriter out = resp.getWriter();  //the printwriter is retrieved from: the HttpServlet response
		out.print(tasks);
	}
}
