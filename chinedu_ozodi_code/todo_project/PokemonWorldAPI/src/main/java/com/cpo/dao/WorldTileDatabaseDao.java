package com.cpo.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cpo.models.WorldTile;
import com.cpo.util.SetConnectionPropertiesUtil;

public class WorldTileDatabaseDao implements WorldTileDao {

	public WorldTileDatabaseDao() {
	}

	@Override
	public int createWorldTile(WorldTile worldTile) {
		int ra = 0;
		// Going to contain code for JDBC
		try (Connection conn = SetConnectionPropertiesUtil.getConnection();) {
			String sql = "INSERT INTO world_tiles(wt_name,world_x, world_y, wt_type_id, world_id, width, length) VALUES (?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
//			System.out.println("[LOG] parent id: " + worldTile.getTileParentId());
			ps.setString(1, worldTile.getTileName());
			ps.setInt(2, worldTile.getX());
			ps.setInt(3, worldTile.getY());
			ps.setInt(4, worldTile.getTileTypeId());
			ps.setInt(5, worldTile.getTileParentId());
			ps.setInt(6, worldTile.getWidth());
			ps.setInt(7, worldTile.getLength());
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
	public WorldTile getWorldTileByPosition(int worldId, int x, int y) {
		// Going to contain code for JDBC
		WorldTile wt = null;
		try (Connection conn = SetConnectionPropertiesUtil.getConnection();) {

			String sql = "SELECT * FROM world_tiles wt RIGHT OUTER JOIN wt_types wtt on (wt.wt_type_id = wtt.wt_type_id) WHERE world_id = ? AND world_x = ? AND world_y = ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, worldId);
			ps.setInt(2, x);
			ps.setInt(3, y);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				wt = new WorldTile(rs.getInt(1), rs.getInt("world_id"), rs.getString("wt_name"), rs.getInt("world_x"),
						rs.getInt("world_y"), rs.getInt("wt_type_id"), rs.getString("wt_type"), rs.getInt("length"),
						rs.getInt("width"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return wt;

	}
	
	@Override
	public List<WorldTile> getWorldTilesByWorldId(int worldId) {
		// Going to contain code for JDBC
		List<WorldTile> wts = new ArrayList<WorldTile>();
		try (Connection conn = SetConnectionPropertiesUtil.getConnection();) {

			String sql = "SELECT * FROM world_tiles wt RIGHT OUTER JOIN wt_types wtt on (wt.wt_type_id = wtt.wt_type_id) WHERE world_id = ? ORDER BY world_y, world_x";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, worldId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				wts.add(new WorldTile(rs.getInt(1), rs.getInt("world_id"), rs.getString("wt_name"), rs.getInt("world_x"),
						rs.getInt("world_y"), rs.getInt("wt_type_id"), rs.getString("wt_type"), rs.getInt("length"),
						rs.getInt("width")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return wts;

	}
}
