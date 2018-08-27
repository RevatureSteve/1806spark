package com.revature.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.services.ERSService;

public class LoadInfoHelper {
	
	private final String uri = "/ERS_project/";

	public Object process(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		System.out.println("[LOG] - Processing request with LoadInfoHelper: " + req.getRequestURI());
		ERSService service = new ERSService();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		String json = "";
		
		if(br != null) {
			json = br.readLine();
		}
		
		ObjectMapper mapper = new ObjectMapper();
		
		switch(req.getRequestURI()) {
		case uri + "landing.loadinfo":
			User user = mapper.readValue(json, User.class);
			ArrayList<Reimbursement> reimbs = service.getUserReimbursements(user);
			return reimbs;
		case uri + "allReimbs.loadinfo":
			ArrayList<Reimbursement> allReimbs = service.getAllReimbursements();
			return allReimbs;
		case uri + "userForReimbursement.loadinfo":
			Integer id = mapper.readValue(json, Integer.class);
			User author = service.getUserById(id);
			return author;
		case uri + "allUsers.loadinfo":
			ArrayList<User> users = service.getAllUsers();
			return users;
		default:
			return null;
		}
	}
}
