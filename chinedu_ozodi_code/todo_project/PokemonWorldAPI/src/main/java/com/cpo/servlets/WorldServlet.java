package com.cpo.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cpo.models.PokeWorld;
import com.cpo.services.WorldService;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * -/world Endpoint
 * Servlet implementation class WorldServlet
 */
public class WorldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		PokeWorld world = WorldService.getInstance().getWorld();
		System.out.println("WORLD -GET sending world data, count: " + world);
		String json = mapper.writeValueAsString(world);
		PrintWriter pw = response.getWriter();
		response.setContentLength(json.length());
		response.setContentType("application/json");
		pw.write(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//Create World
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		WorldService.getInstance().createWorld();
		
		
	}

}
