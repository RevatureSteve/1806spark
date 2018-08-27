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
import com.revature.models.Reimbursement;
import com.revature.services.ERSService;

@WebServlet("/updateReimbursement")
public class UpdateReimbusementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("[LOG] - Request sent to UpdateReimbusementServlet.doPost()");

		ERSService service = new ERSService();

		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		String json = "";

		if(br != null) {
			json = br.readLine();
		}

		ObjectMapper mapper = new ObjectMapper();
		Reimbursement temp = mapper.readValue(json, Reimbursement.class);

		temp = service.updateReimbursement(temp);

		PrintWriter pw = res.getWriter();
		res.setContentType("application/json");

		String userJSON = mapper.writeValueAsString(temp);
		pw.write(userJSON);
	}

}
