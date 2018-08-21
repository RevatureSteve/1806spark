package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.revature.domain.User;
import com.revature.service.UserService;
import com.revature.service.VerificationService;

/**
 * Servlet implementation class UserInformationUpdateServlet
 */
public class UserInformationUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserInformationUpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * /employee/update
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Update employee up");
		ObjectMapper mapper = new ObjectMapper();
		ServletInputStream json = request.getInputStream();
		ObjectNode node = mapper.readValue(json, ObjectNode.class);

		String email = node.get("email").textValue();
		String password = node.get("password").textValue();
		String fname = node.get("fname").textValue();
		String lname = node.get("lname").textValue();
		int id = node.get("uId").intValue();
		int posId = node.get("positionId").intValue();
		String posName = node.get("position").textValue();
		
		User user = new User(id, email, password, fname, lname, posId, posName);
		System.out.println(user);
		User returnedUser = null;
//				UserService.updateUserInfo(user);
		String jsonOut = mapper.writeValueAsString(returnedUser);

		// user printwriter note this is not json String just misc toString code
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		out.print(jsonOut);
	}

}
