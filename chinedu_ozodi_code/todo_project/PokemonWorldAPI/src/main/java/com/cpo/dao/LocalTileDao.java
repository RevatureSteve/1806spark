package com.cpo.dao;

import com.cpo.models.LocalTile;

public interface LocalTileDao {

	int createLocalTile(LocalTile localTile);
	
	LocalTile getLocalTileByLocation(int worldTileId, int x, int y);
}
