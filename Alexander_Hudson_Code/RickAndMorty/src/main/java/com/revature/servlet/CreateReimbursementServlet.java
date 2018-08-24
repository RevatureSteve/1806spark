package com.revature.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.Pojo.Reimbursement;
import com.revature.service.AppService;

public class CreateReimbursementServlet extends HttpServlet {

	public CreateReimbursementServlet() {
		super();
	}

	AppService appService = new AppService();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
	
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		System.out.println("Creating Reimbursement -POST");

		ObjectMapper mapper = new ObjectMapper();
		System.out.println("Mapping");

		BufferedReader bf = req.getReader();
		System.out.println("Buffer Reader");

		Reimbursement re = mapper.readValue(bf, Reimbursement.class);

		System.out.println(re);

		appService.createReimbursement(re.getEmp_U_Id(), re.getAmt(), re.getDescription(), re.getRq_Type());
	}

}
