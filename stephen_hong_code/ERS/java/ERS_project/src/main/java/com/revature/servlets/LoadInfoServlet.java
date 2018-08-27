package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.util.LoadInfoHelper;

@WebServlet("*.loadinfo")
public class LoadInfoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[LOG] - Request sent to front controller, LoadInfoServlet.doPost()");
		
		Object info = new LoadInfoHelper().process(req, resp);
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(info);
		
		PrintWriter pw = resp.getWriter();
		resp.setContentType("application/json");
		pw.write(json);
	}
}
