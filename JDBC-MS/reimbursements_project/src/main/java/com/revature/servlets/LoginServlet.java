package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.revature.domain.User;
import com.revature.service.VerificationService;

public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8431430892643244256L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		// 3 ways of sending back a response
		// printwriter, forward, redirect
		System.out.println("Login up");

		ObjectMapper mapper = new ObjectMapper();
		ServletInputStream json = req.getInputStream();
		ObjectNode node = mapper.readValue(json, ObjectNode.class);

		String email = null;
		String password = null;
		if (node.has("email")) {
			email = node.get("email").textValue();
		}
		if (node.has("password")) {
			password = node.get("password").textValue();
		}

		System.out.println(email + password);
		User verified = VerificationService.verifyUsernameAndPassword(email, password);

		String jsonOut = mapper.writeValueAsString(verified);

		// user printwriter note this is not json String just misc toString code
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		out.print(jsonOut);
	}
}
