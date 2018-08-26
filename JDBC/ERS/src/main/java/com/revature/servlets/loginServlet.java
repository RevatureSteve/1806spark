package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.revature.POJO.Reimbursement;
import com.revature.POJO.User;
import com.revature.service.AppService;

/**
 * Servlet implementation class loginServlet
 */
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AppService appService = new AppService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		int pos = Integer.parseInt(request.getParameter("pos_id"));
		User u = appService.login(email, pass, pos);
		System.out.println(u);
		ObjectMapper mapper = new ObjectMapper();

		String json = mapper.writeValueAsString(u);
		response.setContentType("application/json");
		System.out.println(json);
		response.getWriter().write(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("called");
		ObjectMapper mapper = new ObjectMapper();
		ServletInputStream json = request.getInputStream();
		ObjectNode node = mapper.readValue(json, ObjectNode.class);

		String email = node.get("email").textValue();
		String pass = node.get("password").textValue();
		int pos = node.get("pos_id").intValue();
		User u = appService.login(email, pass, pos);
		
		String ujson = mapper.writeValueAsString(u);
		response.setContentType("application/json");
		System.out.println(ujson);
		response.getWriter().write(ujson);
	}

}
