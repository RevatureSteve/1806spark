package com.cpo.models;

import java.util.List;

public class WorldTile extends Tile{
	
	private int length;
	private int width;
	private List<LocalTile> localTiles;

	public WorldTile() {
		
	}
	public WorldTile(int tileParentId, String tileName, int x, int y, int tileTypeId, int length, int width) {
		super(tileParentId, tileName, x, y, tileTypeId);
		this.length = length;
		this.width = width;
	}
	
	public WorldTile(int tileParentId, String tileName, int x, int y, int tileTypeId, String tileType, int length, int width) {
		super(tileParentId, tileName, x, y, tileTypeId, tileType);
		this.length = length;
		this.width = width;
	}
	
	public WorldTile(int tileParentId, String tileName, int x, int y, int tileTypeId, String tileType, int length, int width, List<LocalTile> localTiles) {
		super(tileParentId, tileName, x, y, tileTypeId, tileType);
		this.length = length;
		this.width = width;
		this.localTiles = localTiles;
	}

	public WorldTile(int tileId, int tileParentId, String tileName, int x, int y, int tileTypeId, String tileType, int length, int width) {
		super(tileId, tileParentId,tileName, x,y, tileTypeId,tileType);
		this.length = length;
		this.width = width;
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
	public List<LocalTile> getLocalTiles() {
		return localTiles;
	}
	public void setLocalTiles(List<LocalTile> localTiles) {
		this.localTiles = localTiles;
	}
	
	@Override
	public String toString() {
		return "WorldTile [length=" + length + ", width=" + width + ", localTiles=" + localTiles + "]";
	}
	
	
}
