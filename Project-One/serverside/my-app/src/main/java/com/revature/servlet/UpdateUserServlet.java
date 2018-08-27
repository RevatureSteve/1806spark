package com.revature.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.revature.logic.UserLogic;
import com.revature.pojo.TranstarUsers;

/**
 * Servlet implementation class UpdateUserServlet
 */
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = null;
		String fname= null;
		String lname = null;
		int userId = 0;
		
		System.out.println("POST- update user");
		
		ObjectMapper mapper = new ObjectMapper();
		ServletInputStream body = request.getInputStream();
		ObjectNode n = mapper.readValue(body, ObjectNode.class);
		
		if(n.has("email")) {
			email = n.get("email").textValue();
		}
		
		if(n.has("fname")) {
			fname = n.get("fname").textValue();
		}
		if(n.has("lname")) {
			lname = n.get("lname").textValue();
		}
		if(n.has("user_id")) {
			userId = n.get("user_id").intValue();
		}
	
		System.out.println(email + fname + lname + userId);
		
		int resultSet = new UserLogic().updateUser(email, fname, lname, userId);
		

		
		
		String json = mapper.writeValueAsString(resultSet);
		
		response.setContentType("application/json");
		response.getWriter().write(json);
	}

}
