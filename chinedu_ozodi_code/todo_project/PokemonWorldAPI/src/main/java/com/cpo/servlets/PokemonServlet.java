package com.cpo.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cpo.models.Pokemon;
import com.cpo.services.PokemonService;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * -/pokemon Servlet implementation class PokemonServlet
 */
public class PokemonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PokemonServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		
		if (request.getParameter("worldTileId") != null) {
			
			int worldTileId = Integer.parseInt(request.getParameter("worldTileId"));
			if (worldTileId > 0) {
				//return all pokemon from world tile
				int x = Integer.parseInt(request.getParameter("x"));
				int y = Integer.parseInt(request.getParameter("y"));
				List<Pokemon> pokemon = PokemonService.getInstance().getPokemonByLocalTilePosition(worldTileId, x, y);
				System.out.println("PokemonServlet -GET sending pokemon data, count: " + pokemon.size());
				String json = mapper.writeValueAsString(pokemon);
				PrintWriter pw = response.getWriter();
				response.setContentLength(json.length());
				response.setContentType("application/json");
				pw.write(json);
			}
		} else if (request.getParameter("trainerId") != null) {
			int trainerId = Integer.parseInt(request.getParameter("trainerId"));
			System.out.println("[LOG] getting trainer pokemon: " + trainerId);
			List<Pokemon> pokemon = PokemonService.getInstance().getPokemonByTrainerId(trainerId);
			System.out.println("PokemonServlet -GET sending pokemon data, count: " + pokemon.size());
			if (pokemon.size() > 0) {
				System.out.println(pokemon.get(0));
			}
			String json = mapper.writeValueAsString(pokemon);
			PrintWriter pw = response.getWriter();
			response.setContentLength(json.length());
			response.setContentType("application/json");
			pw.write(json);
		}
		else {
			response.getWriter().append("Served at: ").append(request.getContextPath());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("PokemonServlet -PUT pokemon");
		BufferedReader bf = request.getReader();

		ObjectMapper mapper = new ObjectMapper();
		Pokemon pokemon = mapper.readValue(bf, Pokemon.class);
		
		if (pokemon != null) {
			System.out.println("Pokemon: " + pokemon);
			
			// check database for user
			PokemonService.getInstance().updatePokemon(pokemon);
		}

	}

}
