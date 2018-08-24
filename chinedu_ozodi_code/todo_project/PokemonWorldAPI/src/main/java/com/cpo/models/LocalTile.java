package com.cpo.models;

import java.util.List;

public class LocalTile extends Tile {
	
	private List<Pokemon> pokemon;

	public LocalTile() {
	}
	
	public LocalTile(int tileParentId, String tileName, int x, int y, int tileTypeId)  {
		super(tileParentId, tileName, x, y, tileTypeId);
	}
	
	public LocalTile(List<Pokemon> pokemon)  {
		super();
		this.pokemon = pokemon;
	}

	public List<Pokemon> getPokemon() {
		return pokemon;
	}

	public void setPokemon(List<Pokemon> pokemon) {
		this.pokemon = pokemon;
	}

	@Override
	public String toString() {
		return "LocalTile [pokemon=" + pokemon + "]";
	}
	

	
}
