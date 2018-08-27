package com.cpo.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cpo.models.Trainer;
import com.cpo.services.TrainerService;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class TrainerServlet
 */
public class TrainerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * - /trainer
	 * 
	 * @see HttpServlet#HttpServlet()
	 */
	public TrainerServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		int trainerId = Integer.parseInt(request.getParameter("id"));
		Trainer trainer = TrainerService.getInstance().getTrainerById(trainerId);
		System.out.println("[LOG] TrainerServlet -GET trainer: " + trainer);
		String json = mapper.writeValueAsString(trainer);
		PrintWriter pw = response.getWriter();
		response.setContentLength(json.length());
		response.setContentType("application/json");
		pw.write(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("[LOG] TrainerServlet -POST new trainer");
		BufferedReader bf = request.getReader();
		
		ObjectMapper mapper = new ObjectMapper();
		Trainer trainer = mapper.readValue(bf, Trainer.class);
		
		System.out.println("Trainer: " + trainer);
		
		//Add to db
		TrainerService.getInstance().createTrainer(trainer);
	}

}
