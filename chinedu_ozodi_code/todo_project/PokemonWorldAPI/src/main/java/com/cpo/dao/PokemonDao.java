package com.cpo.dao;

import java.io.IOException;
import java.util.List;

import com.cpo.models.Pokemon;

public interface PokemonDao {

	//Create
	int createPokemonData(Pokemon pokemon);
	
	int createPokemon(Pokemon pokemon);
	
	//Read
	Pokemon getPokemonDataById(int id);
	
	List<Pokemon> GetPokemonData();

}
