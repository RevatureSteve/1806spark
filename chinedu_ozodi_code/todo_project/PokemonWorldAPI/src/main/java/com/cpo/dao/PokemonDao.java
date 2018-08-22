package com.cpo.dao;

import java.io.IOException;
import java.util.List;

import com.cpo.models.Pokemon;

public interface PokemonDao {

	List<Pokemon> GetPokemonById(List<Integer> ids);

}
