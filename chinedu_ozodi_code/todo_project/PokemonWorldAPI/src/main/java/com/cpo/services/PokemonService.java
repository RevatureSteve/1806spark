package com.cpo.services;

import java.util.List;

import com.cpo.dao.PokeAPIDao;
import com.cpo.dao.PokemonDatabaseDao;
import com.cpo.models.Pokemon;

public class PokemonService {
	
	private static PokemonService instance;
	
	PokemonDatabaseDao pdd = new PokemonDatabaseDao();

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
	
	public void createPokemonData(Pokemon pokemon) {
		pdd.createPokemonData(pokemon);
	}
	
	public void createPokemon(Pokemon pokemon) {
		pdd.createPokemon(pokemon);
	}
	
	public List<Pokemon> getPokemonData() {
		return pdd.GetPokemonData();
	}
	
	public List<Pokemon> getPokemonByLocalTileId( int id) {
		return pdd.getPokemonByLocalTileId(id);
	}
	
	public List<Pokemon> getPokemonByTrainerId( int id) {
		return pdd.getPokemonByTrainerId(id);
	}
	
	public List<Pokemon> getPokemonByLocalTilePosition( int worldTileId, int x, int y) {
		return pdd.getPokemonByLocalTilePosition(worldTileId, x, y);
	}

	public int updatePokemon(Pokemon pokemon) {
		return pdd.updatePokemon(pokemon);
	}
}
