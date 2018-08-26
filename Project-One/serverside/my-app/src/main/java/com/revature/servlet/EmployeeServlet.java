package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.logic.ReqLogic;
import com.revature.logic.UserLogic;
import com.revature.pojo.TranstarReims;
import com.revature.pojo.TranstarUsers;

/**
 * Servlet implementation class EmployeeServlet
 */
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserLogic users = new UserLogic();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
System.out.println("GET- REQ");
		
		List<TranstarUsers> userList = users.getUsers();
		ObjectMapper mapper = new ObjectMapper();
		
		String json = mapper.writeValueAsString(userList);
		response.setContentType("application/json");
		
		PrintWriter out = response.getWriter();
		out.print(json);
	}
}



