package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.revature.domain.Reimbursement;
import com.revature.domain.User;
import com.revature.service.ReimbursementsService;
import com.revature.service.UserService;
import com.revature.service.VerificationService;

/**
 * Servlet implementation class UsersServlet
 */
public class UsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 *users/employee
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Users servlet up");

		ObjectMapper mapper = new ObjectMapper();
		List<User> employees = UserService.getEmployees();
		
		String jsonOut = mapper.writeValueAsString(employees);

		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		out.print(jsonOut);
	}

}
