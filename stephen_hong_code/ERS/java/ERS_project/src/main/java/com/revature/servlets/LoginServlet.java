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
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.User;
import com.revature.services.ERSService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		System.out.println("[LOG] - Request sent to LoginServlet.doPost()");
		
		ERSService service = new ERSService();
		
		// Use a BufferedReader to read the data from the request
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		String json = "";
		if(br != null) {
			json = br.readLine();
		}
		
		// Parse the json and transform it into a a String array
		ObjectMapper mapper = new ObjectMapper();
		String[] data = mapper.readValue(json, String[].class);
		String username = data[0];
		String password = data[1];
		
		// Get the user from the database
		User temp = service.getUserByUsername(username);
		
		if(temp == null)
			System.out.println("[LOG] - User temp in LoginServlet.doPost() is null");
		else {
			// Hash the given password and test if the hashes match
			String pwHash = service.hashPassword(password, temp.getPwSalt());
			
			if(pwHash.equals(temp.getPwHash())) {
				System.out.println("[LOG] - Login Successful");
				// Set the HTTP session attribute
				HttpSession session = req.getSession();
				session.setAttribute("user", temp);
				System.out.println(session.getAttribute("user"));
			} else {
				temp.setId(-1);
				temp.setFirstName(null);
				temp.setLastName(null);
				temp.setEmail(null);
				temp.setPwHash(null);
				temp.setPwSalt(null);
				temp.setRole(-1);
				temp.setUsername(null);
			}
		}
		
		PrintWriter pw = res.getWriter();
		res.setContentType("application/json");
		
		String userJSON = mapper.writeValueAsString(temp);
		pw.write(userJSON);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		this.doPost(req, res);
	}
}
