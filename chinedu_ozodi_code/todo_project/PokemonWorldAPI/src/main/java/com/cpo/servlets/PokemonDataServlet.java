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
 * -/PokemonData
 * Servlet implementation class PokemonDataServlet
 */
public class PokemonDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PokemonDataServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		List<Pokemon> pokemon = PokemonService.getInstance().getPokemonData();
		System.out.println("PokeDataServlet -GET sending pokemon data, count: " + pokemon.size());
		String json = mapper.writeValueAsString(pokemon);
		PrintWriter pw = response.getWriter();
		response.setContentLength(json.length());
		response.setContentType("application/json");
		pw.write(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Pull pokemon data from the pokeAPI
		System.out.println("PokemonDataServlet -POST new pokemon to be created");
		BufferedReader bf = request.getReader();
		
		ObjectMapper mapper = new ObjectMapper();
		Pokemon pokemon = mapper.readValue(bf, Pokemon.class);
		
		System.out.println("Pokemon name: " + pokemon.getName()  + " " + pokemon.getPokeId());
		
		//Add to db
		PokemonService.getInstance().createPokemonData(pokemon);
		
		
	}

}
