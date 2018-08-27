package com.cpo.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cpo.models.PokeWorld;
import com.cpo.models.Trainer;
import com.cpo.util.SetConnectionPropertiesUtil;

public class TrainerDatabaseDao implements TrainerDao {
	
	private static TrainerDatabaseDao instance;

	private TrainerDatabaseDao() {
	}
	
	public static TrainerDatabaseDao getInstance() {
		if (instance == null) {
			instance = new TrainerDatabaseDao();
		}
		return instance;
	}
	
	@Override
	public int createTrainer(Trainer trainer) {
		int ra = 0;
		// Going to contain code for JDBC
		try (Connection conn = SetConnectionPropertiesUtil.getConnection();) {

			String sql = "INSERT INTO pokemon_trainers VALUES (?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, trainer.getTrainerId());
			ps.setString(2, trainer.getTrainerName());
			ps.setInt(3, trainer.getPokeballCount());
			ps.setInt(4, trainer.getCandyCount());
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
	public Trainer getTrainerById(int id) {
		// Going to contain code for JDBC
				Trainer trainer = null;
				try (Connection conn = SetConnectionPropertiesUtil.getConnection();) {

					String sql = "SELECT * FROM pokemon_trainers WHERE trainer_id = ?";
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setInt(1, id);
					ResultSet rs = ps.executeQuery();
					if (rs.next()) {
						trainer = new Trainer(rs.getInt("trainer_id"),rs.getString("trainer_name"),rs.getInt("pokeball_count"), rs.getInt("candy_count"));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

				return trainer;
	}
}
