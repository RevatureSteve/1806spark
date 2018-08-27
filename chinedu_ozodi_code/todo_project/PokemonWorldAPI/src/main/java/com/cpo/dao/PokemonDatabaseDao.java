package com.cpo.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cpo.model.User;
import com.cpo.models.Pokemon;
import com.cpo.util.SetConnectionPropertiesUtil;

public class PokemonDatabaseDao implements PokemonDao {

	public PokemonDatabaseDao() {
	}
	//-------CREATE-------
	@Override
	public int createPokemonData(Pokemon pokemon) {
		int ra = 0;
		// Going to contain code for JDBC
		try (Connection conn = SetConnectionPropertiesUtil.getConnection();) {

			String sql = "INSERT INTO pokemon_data VALUES (?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, pokemon.getPokeId());
			ps.setString(2, pokemon.getName());
			ps.setInt(3, pokemon.getExperience());
			ps.setInt(4, pokemon.getHeight());
			ps.setString(5, pokemon.getImageUrl());
			ra = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return ra;
	}
	
	@Override
	public int createPokemon(Pokemon pokemon) {
		int ra = 0;
		// Going to contain code for JDBC
		try (Connection conn = SetConnectionPropertiesUtil.getConnection();) {

			String sql = "INSERT INTO pokemon(pd_id, poke_name,experience,p_status_id, lt_id, trainer_id) VALUES (?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, pokemon.getPokeId());
			ps.setString(2, pokemon.getName());
			ps.setInt(3, pokemon.getExperience());
			ps.setInt(4,pokemon.getStatusId());
			ps.setInt(5,pokemon.getLtId());
			ps.setInt(6, pokemon.getTrainerId());
			ra = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return ra;
	}

	//-------READ--------
	@Override
	public List<Pokemon> GetPokemonData() {
		// Going to contain code for JDBC
		List<Pokemon> allPokemon = new ArrayList<Pokemon>();
		try (Connection conn = SetConnectionPropertiesUtil.getConnection();) {

			String sql = "SELECT * FROM pokemon_data";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Pokemon pokemon = new Pokemon(rs.getInt(1), rs.getString("poke_name"),rs.getInt("base_experience"),rs.getInt("height"), rs.getString("img_url"));
				allPokemon.add(pokemon);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return allPokemon;
	}
	
	@Override
	public List<Pokemon> getPokemonByLocalTileId(int id) {
		// Going to contain code for JDBC
				List<Pokemon> allPokemon = new ArrayList<Pokemon>();
				try (Connection conn = SetConnectionPropertiesUtil.getConnection();) {

					String sql = "SELECT * FROM pokemon p RIGHT OUTER JOIN pokemon_data pd ON (p.pd_id = pd.poke_id) RIGHT OUTER JOIN pokemon_status ps ON (p.p_status_id = ps.p_status_id) WHERE lt_id = ? ";
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setInt(1, id);
					ResultSet rs = ps.executeQuery();
					while (rs.next()) {
						Pokemon pokemon = new Pokemon(rs.getInt("p_id"),rs.getInt("pd_id"), rs.getString("poke_name"),rs.getInt("base_experience"),rs.getInt("height"), rs.getString("img_url"),
									rs.getInt("p_status_id"),rs.getString("p_status"),rs.getInt("trainer_id"), rs.getInt("lt_id"));
						allPokemon.add(pokemon);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

				return allPokemon;
	}
	
	@Override
	public List<Pokemon> getPokemonByTrainerId(int id) {
		// Going to contain code for JDBC
				List<Pokemon> allPokemon = new ArrayList<Pokemon>();
				try (Connection conn = SetConnectionPropertiesUtil.getConnection();) {

					String sql = "SELECT * FROM pokemon p RIGHT OUTER JOIN pokemon_data pd ON (p.pd_id = pd.poke_id) RIGHT OUTER JOIN pokemon_status ps ON (p.p_status_id = ps.p_status_id) WHERE trainer_id = ? ORDER BY p.p_status_id";
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setInt(1, id);
					ResultSet rs = ps.executeQuery();
					while (rs.next()) {
						Pokemon pokemon = new Pokemon(rs.getInt("p_id"),rs.getInt("pd_id"), rs.getString("poke_name"),rs.getInt("base_experience"),rs.getInt("height"), rs.getString("img_url"),
									rs.getInt("p_status_id"),rs.getString("p_status"),rs.getInt("trainer_id"), rs.getInt("lt_id"));
						allPokemon.add(pokemon);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

				return allPokemon;
	}

	@Override
	public List<Pokemon> getPokemonByLocalTilePosition(int worldTileId, int x, int y) {
		// Going to contain code for JDBC
				List<Pokemon> allPokemon = new ArrayList<Pokemon>();
				try (Connection conn = SetConnectionPropertiesUtil.getConnection();) {

					String sql = "SELECT * FROM pokemon p \r\n" + 
							"RIGHT OUTER JOIN pokemon_data pd ON (p.pd_id = pd.poke_id)\r\n" + 
							"RIGHT OUTER JOIN pokemon_status ps ON (p.p_status_id = ps.p_status_id)\r\n" + 
							"WHERE lt_id = (SELECT lt_id FROM local_tiles WHERE wt_id = ? AND local_x = ? AND local_y = ?) ";
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setInt(1, worldTileId);
					ps.setInt(2, x);
					ps.setInt(3, y);
					ResultSet rs = ps.executeQuery();
					while (rs.next()) {
						Pokemon pokemon = new Pokemon(rs.getInt("p_id"),rs.getInt("pd_id"), rs.getString("poke_name"),rs.getInt("base_experience"),rs.getInt("height"), rs.getString("img_url"),
									rs.getInt("p_status_id"),rs.getString("p_status"),rs.getInt("trainer_id"), rs.getInt("lt_id"));
						allPokemon.add(pokemon);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

				return allPokemon;
	}
	
	@Override
	public Pokemon getPokemonDataById(int id) {
		return null;
	}
	
	//-------UPDATE-------
	
	@Override
	public int updatePokemon(Pokemon pokemon) {
		int ra = 0;
		// Going to contain code for JDBC
		try (Connection conn = SetConnectionPropertiesUtil.getConnection();) {

			String sql = "UPDATE pokemon SET poke_name = ?, experience = ?, trainer_id = ?, lt_id = ?, p_status_id = ? WHERE p_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, pokemon.getName());
			ps.setInt(2, pokemon.getExperience());
			ps.setInt(3, pokemon.getTrainerId());
			if (pokemon.getLtId() == 0) {
				ps.setString(4,null);
			}
			else {
				ps.setInt(4,pokemon.getLtId());
			}
			ps.setInt(5,pokemon.getStatusId());
			ps.setInt(6, pokemon.getId());
			ra = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return ra;
	}

	
}
