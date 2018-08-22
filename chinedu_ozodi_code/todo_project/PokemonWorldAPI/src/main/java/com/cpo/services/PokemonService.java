package com.cpo.services;

import java.util.List;

import com.cpo.dao.PokeAPIDao;

public class PokemonService {
	
	private static PokemonService instance;

	private PokemonService() {
	}
	
	public static PokemonService getInstance() {
		if (instance == null) {
			instance = new PokemonService();
		}
		return instance;
	}
	
	/**
	 * Scrapes the public pokemon database and saves the listed pokemon id's to the private database
	 * @param pokeIds
	 */
	public void ScrapePokemon(List<Integer> pokeIds) {
		new PokeAPIDao().GetPokemonById(pokeIds);
	}

}
