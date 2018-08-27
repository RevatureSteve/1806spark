package com.cpo.dao;

import java.util.List;

import com.cpo.models.WorldTile;

public interface WorldTileDao {
	// CREATE
	int createWorldTile (WorldTile worldTile);
	
	//READ
	WorldTile getWorldTileByPosition(int worldId, int x, int y);

	List<WorldTile> getWorldTilesByWorldId(int worldId);

}
