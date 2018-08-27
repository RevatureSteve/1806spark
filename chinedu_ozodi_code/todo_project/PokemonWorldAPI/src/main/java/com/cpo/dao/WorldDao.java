package com.cpo.dao;

import com.cpo.models.PokeWorld;

public interface WorldDao {
	
	int createWorld(PokeWorld world);
	
	PokeWorld getWorldById(int id);

}
