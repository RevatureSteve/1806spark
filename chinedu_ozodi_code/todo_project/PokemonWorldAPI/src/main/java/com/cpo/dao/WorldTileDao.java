package com.cpo.dao;

import com.cpo.models.WorldTile;

public interface WorldTileDao {
	// CREATE
	int createWorldTile (WorldTile worldTile);
	
	//READ
	WorldTile getWorldTileByPosition(int worldId, int x, int y);

}
