package com.cpo.models;

import java.util.List;

public class LocalTile extends Tile {
	
	private List<Pokemon> pokemon;

	public LocalTile() {
	}
	
	public LocalTile(int tileId, String tileName, int x, int y)  {
		super(tileId, tileName, x, y);
	}
	
	public LocalTile(int tileId, String tileName, int x, int y, List<Pokemon> pokemon)  {
		super(tileId, tileName, x, y);
		this.pokemon = pokemon;
	}
	

}
