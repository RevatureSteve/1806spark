package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.revature.dao.ErsDao;
import com.revature.dao.ErsDaoImpl;
import com.revature.pogo.Users;

public class LoginServlet extends HttpServlet {

	/*
	 * URL - /login
	 */

	private ErsDao dao = new ErsDaoImpl();

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("LoginServlet -POST");

		ObjectMapper mapper = new ObjectMapper();
		ServletInputStream sis = request.getInputStream();
		ObjectNode on = mapper.readValue(sis, ObjectNode.class);

		String email = on.get("email").asText();
		String password = on.get("password").asText();

		Users user = dao.login(email, password);

		String json = mapper.writeValueAsString(user);

		response.setContentType("application/json");
		response.getWriter().write(json);
	}

}
