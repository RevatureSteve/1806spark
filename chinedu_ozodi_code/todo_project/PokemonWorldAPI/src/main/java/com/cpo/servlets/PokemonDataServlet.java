package com.cpo.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cpo.services.PokemonService;

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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Pull pokemon data from the pokeAPI
		response.getWriter().append("Served at: ").append(request.getContextPath());
		List<Integer> pokemon = new ArrayList<Integer>();
		pokemon.add(1);
		pokemon.add(2);
		PokemonService.getInstance().ScrapePokemon(pokemon);
	}

}
