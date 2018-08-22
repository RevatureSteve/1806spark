package com.cpo.models;

public abstract class Tile {
	
	protected int tileId;
	protected String tileName;
	protected int x;
	protected int y;

	public Tile() {
	}

	public Tile(int tileId, String tileName, int x, int y) {
		super();
		this.tileId = tileId;
		this.tileName = tileName;
		this.x = x;
		this.y = y;
	}



	public int getTileId() {
		return tileId;
	}

	public void setTileId(int tileId) {
		this.tileId = tileId;
	}

	public String getTileName() {
		return tileName;
	}

	public void setTileName(String tileName) {
		this.tileName = tileName;
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

	@Override
	public String toString() {
		return "Tile [tileId=" + tileId + ", tileName=" + tileName + ", x=" + x + ", y=" + y + "]";
	}

	
}
