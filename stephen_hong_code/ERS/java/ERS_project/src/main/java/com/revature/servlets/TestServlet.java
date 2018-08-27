package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.User;

@WebServlet("/test")
public class TestServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("Testing");
		PrintWriter pw = res.getWriter();
		res.setContentType("application/json");
		
		ObjectMapper mapper = new ObjectMapper();
		User temp = new User();
		temp.setId(100);
		String json = mapper.writeValueAsString(temp);
		pw.write(json);
	}
}
