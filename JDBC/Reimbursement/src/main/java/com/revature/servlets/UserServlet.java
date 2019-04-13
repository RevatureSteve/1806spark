package com.revature.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.Service;
import com.revature.pojo.Reimbursement;
import com.revature.pojo.User;

public class UserServlet extends HttpServlet {
	
	Service service = new Service();
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("put reached");
		BufferedReader bufferedReader = req.getReader();
		ObjectMapper mapper = new ObjectMapper();
		User userUpdate = mapper.readValue(bufferedReader,User.class);
		service.updateUser(userUpdate);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<User> users = service.getUser();
		PrintWriter printWriter = resp.getWriter();
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(users);
		resp.setContentType("application/json");
		printWriter.write(json);
		System.out.println(json);
}
}
