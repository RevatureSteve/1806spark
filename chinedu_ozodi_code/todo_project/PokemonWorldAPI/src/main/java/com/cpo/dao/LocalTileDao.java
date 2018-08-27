package com.cpo.dao;

import java.util.List;

import com.cpo.models.LocalTile;

public interface LocalTileDao {

	int createLocalTile(LocalTile localTile);
	
	LocalTile getLocalTileByLocation(int worldTileId, int x, int y);

	List<LocalTile> getLocalTilesByLocation(int worldTileId);
}
