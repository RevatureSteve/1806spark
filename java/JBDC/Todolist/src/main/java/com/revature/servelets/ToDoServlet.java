package com.revature.servelets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import com.revature.domain.Task;

public class ToDoServlet extends HttpServlet{
	
	/*
	 * url - /task
	 */
	
	// based on Restful standard this method should return all tasks
   protected void doGet(HttpServlet req, HttpServletResponse resp) throws IOException, ServletException{
	   //3 ways to handle sending back response
	   		//* printwriter,
	        //* forward, 
	   		//* redirect
	   
	   List<Task> tasks = new ArrayList<>();
	   tasks.add(new Task(1,1,"go for fun", 1,"pending"));
	   tasks.add(new Task(2,2,"fgo for fun", 2, "completed"));
	   tasks.add(new Task(3,3, "go for sprint", 3,"canceled"));
	   
	   //used printwriter   ........note this is not a Json string just misc toString code
	   PrintWriter out = resp.getWriter(); // motice we retreive the printWriter from: HttpServletResponse
	   out.print(tasks);
   }
}
