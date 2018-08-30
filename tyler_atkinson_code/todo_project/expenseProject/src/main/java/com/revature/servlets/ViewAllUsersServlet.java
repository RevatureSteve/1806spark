package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.domain.Reimbursement;
import com.revature.domain.Users;
import com.revature.service.AppService;

/**
 * Servlet implementation class ViewAllUsersServlet
 */
public class ViewAllUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private AppService appService = new AppService();
	
    public ViewAllUsersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Users> users = appService.getAllUsers();
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(users);
		resp.setContentType("application/json");
		PrintWriter out = resp.getWriter();
		out.print(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
