package com.revature.servlets;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.domain.User;

/**
 * Servlet implementation class UpdateUserServlet
 */
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("IT HITS");
		UserDaoImpl udi = new UserDaoImpl();
		ObjectMapper mapper = new ObjectMapper();
		BufferedReader br = request.getReader();
		User u = mapper.readValue(br, User.class);
		udi.updateUser(u);
		response.setStatus(201);
		response.getWriter().write("was successful");
	}

}
