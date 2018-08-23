package com.cpo.models;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class PokeWorld extends Tile implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int worldId;
	private String worldName;
	private WorldTile[] worldTiles;
	private int length;
	private int width;

	public PokeWorld() {
		
	}

	public PokeWorld(int worldId, String worldName, int length, int width) {
		super();
		this.worldId = worldId;
		this.worldName = worldName;
		this.length = length;
		this.width = width;
	}



	public int getWorldId() {
		return worldId;
	}

	public void setWorldId(int worldId) {
		this.worldId = worldId;
	}

	public String getWorldName() {
		return worldName;
	}

	public void setWorldName(String worldName) {
		this.worldName = worldName;
	}

	public WorldTile[] getWorldTiles() {
		return worldTiles;
	}

	public void setWorldTiles(WorldTile[] worldTiles) {
		this.worldTiles = worldTiles;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	@Override
	public String toString() {
		return "PokeWorld [worldId=" + worldId + ", worldName=" + worldName + ", worldTiles="
				+ Arrays.toString(worldTiles) + ", length=" + length + ", width=" + width + "]";
	}
}
