package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.domain.Task;
import com.revature.service.AppService;

/**
 * Servlet implementation class ToDoIdServlet
 */
public class ToDoIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AppService appService = new AppService();
       
    /**
     * @see HttpServlet()
     *  /task/id
     */
    public ToDoIdServlet() {
        super();
    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ToDoIdServlet - GET");
		System.out.println("THE id of the user is: " + request.getParameter("userId"));
		int id = Integer.parseInt(request.getParameter("userId"));
		
		List<Task> tasks = appService.getTasksByUserId(id);
		
		ObjectMapper mapper = new ObjectMapper();
		
		String json = mapper.writeValueAsString(tasks);
		response.setContentType("application/json");
		response.getWriter().write(json);
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
