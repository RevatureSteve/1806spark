package com.revature.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.User;
import com.revature.services.ERSService;;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[LOG] - Request sent to RegistrationServlet.doPost()");
		
		ERSService service = new ERSService();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		String json = "";
		
		if(br != null) {
			json = br.readLine();
		}
		
		ObjectMapper mapper = new ObjectMapper();
		User temp = mapper.readValue(json, User.class);
		
		String pwSalt = service.generateSalt();
		String pwHash = service.hashPassword(temp.getPwHash(), pwSalt);
		temp.setPwHash(pwHash);
		temp.setPwSalt(pwSalt);
		
		temp = service.createNewUser(temp);
		
		PrintWriter pw = resp.getWriter();
		resp.setContentType("application/json");
		
		String userJSON = mapper.writeValueAsString(temp);
		pw.write(userJSON);
	}

}
