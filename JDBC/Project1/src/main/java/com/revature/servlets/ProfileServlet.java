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

public class ProfileServlet extends HttpServlet {

	/*
	 * URL - /profile
	 */

	private ErsDao dao = new ErsDaoImpl();

	public ProfileServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ProfileServlet -PUT");

		ObjectMapper mapper = new ObjectMapper();
		ServletInputStream sis = request.getInputStream();
		ObjectNode on = mapper.readValue(sis, ObjectNode.class);

		int uId = on.get("uId").asInt();
		String email = on.get("email").asText();
		String password = on.get("password").asText();
		String fname = on.get("firstname").asText();
		String lname = on.get("lastname").asText();
		int posId = on.get("posId").asInt();

		Users user = new Users(uId, email, password, fname, lname, posId);

		dao.updateProfile(user);
	}

}
