package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.FlashCard;

public class FlashCardDaoImpl implements FlashCardDao {
	private static final String USERNAME = "flashcard_db";
	private static final String PASSWORD = "p4ssw0rd";
	private static final String URL = "jdbc:oracle:thin:@marcin-salamon-oracle.ch2v7k2we1qt.us-east-2.rds.amazonaws.com:1521:ORCL";

	/*
	 * Why use a preparedStatement over a statement?
	 * 	-poor readability of a statement
	 */
	@Override
	public int createFlashCard(FlashCard fc) {
		int rowsAffected = 0;
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
			String sql = "INSERT INTO flash_cards(fc_question, fc_answer) VALUES(?,?)";
			PreparedStatement ps = conn.prepareStatement(sql); //take in the SQL statement without variable first! use question marks instead
			ps.setString(1, fc.getQuestion());
			ps.setString(2, fc.getAnswer());
			rowsAffected = ps.executeUpdate();
			return rowsAffected;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}
	
	public void createFlashCardProc(FlashCard fc) {
		try(Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
			String sql = "{call insert_fc_procedure(?,?,?)}"; //surround with curly braces to work with returns
			String msg = "wow!";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, fc.getQuestion());
			cs.setString(2, fc.getAnswer());
			cs.setString(3,  msg);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<FlashCard> getAllFlashCards() {
		// flashcard_db p4ssw0rd
		// marcin-salamon-oracle.ch2v7k2we1qt.us-east-2.rds.amazonaws.com

		ArrayList<FlashCard> flash_arrlist = new ArrayList<FlashCard>();
		// get a connection to the OracleDB
		// use the DriverManager
		try {
			String sql = "SELECT * FROM flash_cards";
			Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				flash_arrlist.add(new FlashCard(rs.getInt(1), rs.getString("fc_question"), rs.getString("fc_answer")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flash_arrlist;
	}

	public FlashCard getFlashCardById(int id) {
		FlashCard fc = null;
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
			String sql = "SELECT * FROM flash_cards WHERE fc_id = " + id;
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			if (rs.next()) {
				fc = new FlashCard(rs.getInt("fc_id"), rs.getString(2), rs.getString("fc_answer"));
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return fc;
	}

	

}
