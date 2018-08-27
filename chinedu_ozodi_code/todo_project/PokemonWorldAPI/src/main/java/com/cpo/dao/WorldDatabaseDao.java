package com.cpo.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cpo.models.LocalTile;
import com.cpo.models.PokeWorld;
import com.cpo.util.SetConnectionPropertiesUtil;

public class WorldDatabaseDao implements WorldDao {

	public WorldDatabaseDao() {
	}

	@Override
	public int createWorld(PokeWorld world) {
		int ra = 0;
		// Going to contain code for JDBC
		try (Connection conn = SetConnectionPropertiesUtil.getConnection();) {

			String sql = "INSERT INTO worlds VALUES (?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, world.getWorldId());
			ps.setString(2, world.getWorldName());
			ps.setInt(3, world.getWidth());
			ps.setInt(4, world.getLength());
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
	public PokeWorld getWorldById(int id) {
		// Going to contain code for JDBC
		PokeWorld pw = null;
		try (Connection conn = SetConnectionPropertiesUtil.getConnection();) {

			String sql = "SELECT * FROM worlds WHERE world_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				pw = new PokeWorld(rs.getInt("world_id"),rs.getString("world_name"),rs.getInt("length"), rs.getInt("width"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return pw;
	}

}
