package com.cpo.servlets;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cpo.model.User;
import com.cpo.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class LoginServlet Endpoint: /login
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("[LOG] LoginServlet -POST user login");
		BufferedReader bf = request.getReader();

		ObjectMapper mapper = new ObjectMapper();
		User user = mapper.readValue(bf, User.class);

		System.out.println("User email: " + user.getEmail());

		// check database for user

		User dbUser = UserService.getInstance().getUserByEmail(user.getEmail());

		if (dbUser != null && dbUser.getPassword().equals(user.getPassword())) {
			// Send a positive response, start a session
			HttpSession session = request.getSession();
			session.setAttribute("user", dbUser);

			response.setContentType("application/json");
			response.setStatus(200);
			String json = mapper.writeValueAsString(dbUser);
			response.getWriter().append(json);
		} else {
			response.setContentType("application/json");
			response.setStatus(200);
			response.getWriter().append("");
		}
	}

}
