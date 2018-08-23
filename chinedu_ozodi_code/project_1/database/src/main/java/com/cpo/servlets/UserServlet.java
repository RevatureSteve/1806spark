package com.cpo.servlets;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cpo.doa.UserDaoDatabase;
import com.cpo.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class UserServlet
 * URL - /User
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		ObjectMapper mapper = new ObjectMapper();
//		User user = mapper.readValue(request.getCo, valueType)
		
	}

	/**
	 * Used to create new user
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("UserServlet -POST user login");
		BufferedReader bf = request.getReader();
		
		ObjectMapper mapper = new ObjectMapper();
		User user = mapper.readValue(bf, User.class);
		
		System.out.println("User email: " + user.getEmail());
		
		//check database for user
		
		User dbUser = UserDaoDatabase.getInstance().getUserByEmail(user.getEmail());
		
		
		if (dbUser != null && dbUser.getPassword().equals(user.getPassword())) {
			//Send a positive response, start a session
			HttpSession session = request.getSession();
			session.setAttribute("user", dbUser);
			
			response.setContentType("application/json");
			response.setStatus(200);
			response.getWriter().append("{ \"status\":\"good\" }");
		}
		else {
			response.setContentType("application/json");
			response.setStatus(401);
			response.getWriter().append("{ \"status\": \"bad\" }");
		}
		
		
//		String email = request.getParameter("email");
//		System.out.println("email: " + email);
//		String password = request.getParameter("password");
//		String fname = request.getParameter("fname");
//		String lname =request.getParameter("lname");
//		int position = Integer.parseInt(request.getParameter("position"));
		
//		User user = new User(email,password,fname,lname,position);
		

//		UserDaoDatabase.getInstance().createUser(user);
	}

}
