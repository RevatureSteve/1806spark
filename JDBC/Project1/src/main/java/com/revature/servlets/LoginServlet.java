package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.ErsDao;
import com.revature.dao.ErsDaoImpl;
import com.revature.pogo.Users;

public class LoginServlet extends HttpServlet{
	
	/*
	 * URL - /login
	 */
	
	private ErsDao dao = new ErsDaoImpl();
	
	public LoginServlet() {
        super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		System.out.println("TodoIdServlet -GET");
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Users user = dao.login(email, password);
		
		ObjectMapper mapper = new ObjectMapper();
		
		String json = mapper.writeValueAsString(user);
		
		response.setContentType("application/json");
		response.getWriter().write(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		doGet(request, response);
	}

}
