package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.revature.service.AppService;

public class GetUserInfoServlet extends HttpServlet{
	
	private AppService appService = new AppService();
	
	protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		System.out.println("All Reimbursements by Status and Employee Id -GET");
	
		String email = null;
		String fName = null;
		String lName = null;
		int u_Id = 0;
		
		
		System.out.println("Update User -POST");
		
		ObjectMapper mapper = new ObjectMapper();
		ServletInputStream body = req.getInputStream();
		ObjectNode n = mapper.readValue(body,  ObjectNode.class);
		
		if(n.has("email")) {
			email = n.get("email").textValue();
		}
		
		if(n.has("fname")) {
			fName = n.get("fname").textValue();
		}
		if(n.has("lname")) {
			lName = n.get("lname").textValue();
		}
		if(n.has("u_Id")) {
			u_Id = n.get("u_Id").intValue();
		}
		
		System.out.println(email +"" + fName + ""+ lName +""+ u_Id);
		
		int resultSet = new AppService().updateUserInfo(email, fName, lName, u_Id);
		
		
		String json = mapper.writeValueAsString(resultSet);
		
		resp.setContentType("application/json");
		resp.getWriter().write(json);
}

}
