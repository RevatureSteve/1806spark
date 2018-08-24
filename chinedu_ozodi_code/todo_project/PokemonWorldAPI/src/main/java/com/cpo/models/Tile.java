package com.cpo.models;

public abstract class Tile {
	
	protected int tileId;
	protected int tileParentId;
	protected String tileName;
	protected int x;
	protected int y;
	protected int tileTypeId;
	protected String tileType;

	public Tile() {
	}
	
	public Tile(int tileId, int tileParentId, String tileName, int x, int y, int tileTypeId, String tileType) {
		super();
		this.tileId = tileId;
		this.tileParentId = tileParentId;
		this.tileName = tileName;
		this.x = x;
		this.y = y;
		this.tileTypeId = tileTypeId;
		this.tileType = tileType;
	}
	public Tile(int tileParentId, String tileName, int x, int y, int tileTypeId, String tileType) {
		super();
		this.tileParentId = tileParentId;
		this.tileName = tileName;
		this.x = x;
		this.y = y;
		this.tileTypeId = tileTypeId;
		this.tileType = tileType;
	}
	public Tile(int tileParentId, String tileName, int x, int y, int tileTypeId) {
		super();
		this.tileParentId = tileParentId;
		this.tileName = tileName;
		this.x = x;
		this.y = y;
		this.tileTypeId = tileTypeId;
	}

	public int getTileParentId() {
		return tileParentId;
	}

	public void setTileParentId(int tileParentId) {
		this.tileParentId = tileParentId;
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
	
	public int getTileTypeId() {
		return tileTypeId;
	}

	public void setTileTypeId(int tileTypeId) {
		this.tileTypeId = tileTypeId;
	}

	public String getTileType() {
		return tileType;
	}

	public void setTileType(String tileType) {
		this.tileType = tileType;
	}

	@Override
	public String toString() {
		return "Tile [tileId=" + tileId + ", tileName=" + tileName + ", x=" + x + ", y=" + y + "]";
	}

	
}
