package com.revature.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.UserDaoImpl;
import com.revature.domain.Reimbursements;
import com.revature.domain.User;

public class UpdateRstatusServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
    
	  
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("IT STILL HITS");
		UserDaoImpl udi = new UserDaoImpl();
		ObjectMapper mapper = new ObjectMapper();
		BufferedReader br = request.getReader(); //
		Reimbursements[] r = mapper.readValue(br, Reimbursements[].class);
		for(int i = 0; i < r.length; i++) {
		udi.updateReimbursement(r[i]);
		}
		response.setStatus(201);
	}
	
}
