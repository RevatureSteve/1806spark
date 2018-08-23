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
	public Pokemon getPokemonDataById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
