package com.cpo.services;

import java.util.List;

import com.cpo.dao.LocalTileDatabaseDao;
import com.cpo.dao.WorldDatabaseDao;
import com.cpo.dao.WorldTileDatabaseDao;
import com.cpo.models.LocalTile;
import com.cpo.models.PokeWorld;
import com.cpo.models.Pokemon;
import com.cpo.models.WorldTile;

public class WorldService {
	
	private static WorldService instance;
	int worldIndex = 5;
	
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
		
		int worldLength = 10;
		int worldWidth = 5;
		int localLength = 10;
		int localWidth = 5;
		float chanceOfPokemonOnTile = .5f;
		PokeWorld world = new PokeWorld(worldIndex, "Pokemon World", worldLength, worldWidth);
		List<Pokemon> pokemonData = PokemonService.getInstance().getPokemonData();
		System.out.println("[LOG] available pokemon: " + pokemonData.size());
		wdd.createWorld(world);
		System.out.println("[LOG] created world " + wdd);
		for (int y = 0; y < worldLength; y++) {
			for ( int x = 0; x < worldWidth; x++) {
				//Create WorldTiles
				WorldTile wt = new WorldTile(worldIndex,null,x,y,1,localLength,localWidth);
				System.out.println("[LOG] creating tile " + wt);
				wtdd.createWorldTile(wt);
				System.out.println("[LOG] getting tile " + wt);
				wt = wtdd.getWorldTileByPosition(worldIndex, x, y);
				//Create LocalTiles
				for (int ly = 0; ly < localLength; ly++) {
					for (int lx = 0; lx < localWidth; lx++) {
						LocalTile lt = new LocalTile(wt.getTileId(), null, lx, ly, 1);
						System.out.println("[LOG] creating local tile " + lt);
						ltdd.createLocalTile(lt);
						System.out.println("[LOG] getting local tile" + lt);
						lt = ltdd.getLocalTileByLocation(wt.getTileId(), lx, ly);
						//Save Pokemon
						double random = Math.random();
						if (random < chanceOfPokemonOnTile) {
							System.out.println("[LOG] Creating Pokemon");
							//Pick random pokemon
							int pokemonPick = (int) (Math.random() * pokemonData.size());
							System.out.println("[LOG] pokemon number: " + pokemonPick + " of " + pokemonData.size());
							Pokemon pickedPokemon = pokemonData.get(pokemonPick);
							pickedPokemon.setStatusId(1);
							pickedPokemon.setLtId(lt.getTileId());
							System.out.println("[LOG] picked pokemon: " + pickedPokemon);
							//Save Pokemon
							PokemonService.getInstance().createPokemon(pickedPokemon);
						}
					}
				}
			}
		}
	}
	public PokeWorld getWorld() {
		PokeWorld world = wdd.getWorldById(worldIndex);
		System.out.println("[LOG] world " + world);
		System.out.println("[LOG] getting tiles");
		List<WorldTile> wts = wtdd.getWorldTilesByWorldId(worldIndex);
//		System.out.println("[LOG] world tiles count: " + wts.size());
		
//		for (int i = 0; i < wts.size(); i++) {
//			WorldTile wt = wts.get(i);
////			System.out.println("[LOG] getting local tiles for wt " + wt.getTileId());
//			List<LocalTile> lts = ltdd.getLocalTilesByLocation(wt.getTileId());
////			System.out.println("[LOG] local tile count: " + lts.size());
//			for (int k = 0; k < lts.size(); k++) {
//				LocalTile lt = lts.get(k);
////				System.out.println("[LOG] getting pokemon for lt " + lt.getTileId());
//				List<Pokemon> pokemon = PokemonService.getInstance().getPokemonByLocalTileId(lt.getTileId());
//				lt.setPokemon(pokemon);
////				System.out.println("[LOG] pokemon count: " + pokemon.size());
//			}
//			wt.setLocalTiles(lts);
//		}
		world.setWorldTiles(wts);
		return world;
	}
}