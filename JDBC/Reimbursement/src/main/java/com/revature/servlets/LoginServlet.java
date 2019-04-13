package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.revature.Service;
import com.revature.dao.DaoImpl;
import com.revature.dao.ReimbursementDao;
import com.revature.pojo.User;

public class LoginServlet extends HttpServlet {

	//protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
	//
	//}
	
	Service service = new Service();
	ReimbursementDao dao = new DaoImpl();
	protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		System.out.println("Login up");
		System.out.println("bf up");
		User user = new User();
		ObjectMapper mapper = new ObjectMapper();
		ServletInputStream data = req.getInputStream();
		System.out.println(data);
		ObjectNode n = mapper.readValue(data, ObjectNode.class);
		System.out.println(n);
		String email = null;
		String password = null;
		
		if(n.has("email")) {
			email = n.get("email").textValue();
			};
		if(n.has("password")) {
				password = n.get("password").textValue();
				}
		
		user = service.validateUser(email, password);
		 
	 


	String json = mapper.writeValueAsString(user);
	resp.setContentType("application/json");
	resp.getWriter().write(json);
	System.out.println(json);

	 } 
         
}
