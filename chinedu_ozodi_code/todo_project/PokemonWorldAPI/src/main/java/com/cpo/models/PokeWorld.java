package com.cpo.models;

import java.io.Serializable;
import java.util.List;

public class PokeWorld extends Tile implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int worldId;
	private String worldName;
	private WorldTile[] worldTiles;

	public PokeWorld() {
		
	}
	
	public void CreateWorld (int worldX, int worldY, int localX, int localY, float pokemonSpawnChance, List<Pokemon> availablePokemon) {
		
	}

}
