package com.cpo.models;

public class PokemonRequest {

	private int worldTileId;
	private int x;
	private int y;
	private int localTileId;
	private int pId;
	
	public PokemonRequest() {
	}

	public int getLocalTileId() {
		return localTileId;
	}

	public void setLocalTileId(int localTileId) {
		this.localTileId = localTileId;
	}

	public int getX() {
		return x;
	}



	public void setX(int x) {
		this.x = x;
	}



	public int getY() {
		return y;
	}



	public void setY(int y) {
		this.y = y;
	}



	public int getWorldTileId() {
		return worldTileId;
	}

	public void setWorldTileId(int worldTileId) {
		this.worldTileId = worldTileId;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	@Override
	public String toString() {
		return "PokemonRequest [worldTileId=" + worldTileId + ", pId=" + pId + "]";
	}

	
}
