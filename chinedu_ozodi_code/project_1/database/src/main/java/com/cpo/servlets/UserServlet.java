package com.cpo.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cpo.doa.UserDaoDatabase;
import com.cpo.model.Reimbursement;
import com.cpo.model.User;
import com.cpo.services.ReimbursementService;
import com.cpo.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class UserServlet URL - /User
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		
		if (request.getParameter("email") != null) {
			String email = request.getParameter("email");
			User user = UserService.getInstance().getUserByEmail(email);
			System.out.println("User Servlet -GET get user: " + user);
			String json = mapper.writeValueAsString(user);
			PrintWriter pw = response.getWriter();
			response.setContentLength(json.length());
			response.setContentType("application/json");
			pw.write(json);
		} else if (request.getParameter("userId") != null) {
			int id = Integer.parseInt(request.getParameter("userId"));
			User user = UserService.getInstance().getUserId(id);
			System.out.println("User Servlet -GET get user: " + user);
			String json = mapper.writeValueAsString(user);
			PrintWriter pw = response.getWriter();
			response.setContentLength(json.length());
			response.setContentType("application/json");
			pw.write(json);
		} else {
			List<User> users = UserService.getInstance().getAllUsers();
			System.out.println("User Servlet -GET sending all users, count: " + users.size());
			String json = mapper.writeValueAsString(users);
			PrintWriter pw = response.getWriter();
			response.setContentLength(json.length());
			response.setContentType("application/json");
			pw.write(json);
		}

	}

	/**
	 * Used to create new user
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("UserServlet -POST create user");
		BufferedReader bf = request.getReader();

		ObjectMapper mapper = new ObjectMapper();
		User user = mapper.readValue(bf, User.class);

		System.out.println("User: " + user);

		// check database for user

		UserService.getInstance().createUser(user);
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("UserServlet -PUT update user");
		BufferedReader bf = request.getReader();

		ObjectMapper mapper = new ObjectMapper();
		User user = mapper.readValue(bf, User.class);

		System.out.println("User: " + user);

		// check database for user

		UserService.getInstance().updateUser(user);
	}

}
