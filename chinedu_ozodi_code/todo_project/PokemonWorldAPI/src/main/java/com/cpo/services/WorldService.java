package com.cpo.services;

import com.cpo.dao.LocalTileDatabaseDao;
import com.cpo.dao.WorldDatabaseDao;
import com.cpo.dao.WorldTileDatabaseDao;
import com.cpo.models.PokeWorld;
import com.cpo.models.WorldTile;

public class WorldService {
	
	private static WorldService instance;
	
	private WorldDatabaseDao wdd = new WorldDatabaseDao();
	private WorldTileDatabaseDao wtdd = new WorldTileDatabaseDao();
	private LocalTileDatabaseDao ltdd = new LocalTileDatabaseDao();

	public WorldService() {
	}

	public static WorldService getInstance() {
		if (instance == null) {
			instance = new WorldService();
		}
		return instance;
	}
	
	public void createWorld() {
		//Create world
		int worldIndex = 1;
		int worldLength = 10;
		int worldWidth = 5;
		int localLength = 10;
		int localWidth = 5;
		PokeWorld world = new PokeWorld(worldIndex, "Pokemon World", worldLength, worldWidth);
		wdd.createWorld(world);
		for (int y = 0; y < worldLength; y++) {
			for ( int x = 0; x < worldWidth; x++) {
				//Create WorldTiles
				WorldTile wt = new WorldTile();
			}
		}
	}
}
