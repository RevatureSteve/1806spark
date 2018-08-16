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

	// based on restufl standards this method should return ALL tasks
	private AppService appService = new AppService();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		// 3 ways of sending back a response
		// printwriter, forward, redirect

		// List<Task> tasks = new ArrayList<Task>();
		// //original hard coded test but making dynamic from db
		// tasks.add(new Task(1, 1, "go for a run", 1, "pending"));
		// tasks.add(new Task(2, 2, "go for a walk", 2, "completed"));
		// tasks.add(new Task(3, 3, "go for a spring", 3, "cancelled"));

		// Get all tasks
		List<Task> tasks = appService.getAllTasks();

		/*
		 * converting java objects to and from json string
		 */
		ObjectMapper mapper = new ObjectMapper();

		String json = mapper.writeValueAsString(tasks);

		// user printwriter note this is not json String just misc toString code
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		out.print(json);
	}
}
