package com.revature.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.revature.RequestService;
import com.revature.pojo.Reimbursement;

public class RequestServlet extends HttpServlet {
	
	RequestService service = new RequestService();
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("post works");
		BufferedReader bufferedReader = req.getReader();
		ObjectMapper mapper = new ObjectMapper();
		Reimbursement submit = mapper.readValue(bufferedReader,Reimbursement.class);
		System.out.println(submit);
		service.createReimbursement(submit);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Reimbursement> requests = service.getReimbursement();
		PrintWriter printWriter = resp.getWriter();
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(requests);
		resp.setContentType("application/json");
		printWriter.write(json);
		System.out.println(json);
		
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BufferedReader bufferedReader = req.getReader();
		ObjectMapper mapper = new ObjectMapper();
		Reimbursement request = mapper.readValue(bufferedReader,Reimbursement.class);
		service.updateReimbursement(request);
	}

}
