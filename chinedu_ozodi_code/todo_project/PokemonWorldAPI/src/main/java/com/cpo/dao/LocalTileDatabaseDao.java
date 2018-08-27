package com.cpo.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cpo.models.LocalTile;
import com.cpo.util.SetConnectionPropertiesUtil;

public class LocalTileDatabaseDao implements LocalTileDao {

	public LocalTileDatabaseDao() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int createLocalTile(LocalTile localTile) {
		int ra = 0;
		// Going to contain code for JDBC
		try (Connection conn = SetConnectionPropertiesUtil.getConnection();) {
			String sql = "INSERT INTO local_tiles(wt_id,local_x, local_y, lt_type_id) VALUES (?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, localTile.getTileParentId());
			ps.setInt(2, localTile.getX());
			ps.setInt(3, localTile.getY());
			ps.setInt(4, localTile.getTileTypeId());
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
	public LocalTile getLocalTileByLocation(int worldTileId, int x, int y) {
		// Going to contain code for JDBC
				LocalTile lt = null;
				try (Connection conn = SetConnectionPropertiesUtil.getConnection();) {

					String sql = "SELECT * FROM local_tiles lt RIGHT OUTER JOIN lt_types ltt on (lt.lt_type_id = ltt.lt_type_id) WHERE wt_id = ? AND local_x = ? AND local_y = ?";
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setInt(1, worldTileId);
					ps.setInt(2, x);
					ps.setInt(3, y);
					ResultSet rs = ps.executeQuery();
					if (rs.next()) {
						lt = new LocalTile(rs.getInt("lt_id"),rs.getInt("wt_id"), null, rs.getInt("local_x"),rs.getInt("local_y"), rs.getInt("lt_type_id"), rs.getString("lt_type"));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

				return lt;
	}
	
	@Override
	public List<LocalTile> getLocalTilesByLocation(int worldTileId) {
		// Going to contain code for JDBC
				List<LocalTile> lts = new ArrayList<LocalTile>();
				try (Connection conn = SetConnectionPropertiesUtil.getConnection();) {

					String sql = "SELECT * FROM local_tiles lt RIGHT OUTER JOIN lt_types ltt on (lt.lt_type_id = ltt.lt_type_id) WHERE wt_id = ? ORDER BY local_y, local_x";
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setInt(1, worldTileId);
					ResultSet rs = ps.executeQuery();
					while (rs.next()) {
						lts.add(new LocalTile(rs.getInt("lt_id"),rs.getInt("wt_id"), null, rs.getInt("local_x"),rs.getInt("local_y"), rs.getInt("lt_type_id"), rs.getString("lt_type")));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

				return lts;
	}

}
