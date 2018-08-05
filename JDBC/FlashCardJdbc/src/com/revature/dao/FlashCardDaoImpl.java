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

import com.revature.pojo.FlashCard;

public class FlashCardDaoImpl implements FlashCardDao {

	private final static String USERNAME = "flashcard_db";
	private final static String PASSWORD = "p4ssw0rd";
	private final static String URL = "jdbc:oracle:thin:@octocat.cxwq5mzpnovv.us-east-2.rds.amazonaws.com:1521:ORCL";

	//create
	@Override
	public int createFlashcard(FlashCard fc) {
		
		int rowsAffected = 0;
		
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
			conn.setAutoCommit(false);
			
			String sql = "INSERT INTO flash_card(fc_question, fc_answer) VALUES (?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, fc.getFcQuestion());
			ps.setString(2, fc.getFcAnswer());
			
			rowsAffected = ps.executeUpdate();
			conn.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowsAffected;
	}
	
	@Override
	public void createFlashcardProc(FlashCard fc) {
		
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
			String sql = "{call insert_fc_procedure(?, ?, ?)}";
			String msg = "";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, fc.getFcQuestion());
			cs.setString(2, fc.getFcAnswer());
			cs.setString(3, msg);
			int rowsAffected = cs.executeUpdate();
			System.out.println("rows affected: " + rowsAffected);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//read
	@Override
	public List<FlashCard> getAllFlashCards() {

		/*
		 * flashcard_db p4ssw0rd octocat.cxwq5mzpnovv.us-east-2.rds.amazonaws.com 1521
		 * ORCL
		 */
		/*
		 * String username = "flashcard_db"; String password = "p4ssw0rd"; String url =
		 * "jdbc:oracle:thin:@octocat.cxwq5mzpnovv.us-east-2.rds.amazonaws.com:1521:ORCL";
		 */

		// get a connection to the OracleDB
		// Use the DriverManager

		// make a list for the flashcards
		List<FlashCard> myFlashCards = new ArrayList<>();

		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
			String sql = "SELECT * FROM Flash_cards";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			System.out.println(rs);
			// loop through the resultSet of flashcards records
			while (rs.next()) {
				/*
				 * getInt(colummn Index) or getInt(colummn label)
				 */
				/*
				 * System.out.println("ID: " + rs.getInt(1) + " Question: " +
				 * rs.getString("fc_question") + " Answer: " + rs.getString("fc_answer"));
				 */
				FlashCard fc = new FlashCard(rs.getInt("fc_id"), rs.getString(2), rs.getString("fc_answer"));
				// System.out.println(fc);
				myFlashCards.add(fc);
			}

			/*
			 * In the event you get an error called "No Suitable Driver" you must add the
			 * jar
			 */
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return myFlashCards;// get me the flashcards
	}

	public FlashCard getFlashCardById(int id) {
		FlashCard fc = null;
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
			String sql = "SELECT * FROM flash_card WHERE fc_id = " + id;
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			if (rs.next()) {
				fc = new FlashCard(rs.getInt("fc_id"), rs.getString(2), rs.getString("fc_answer"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fc;
	}


}
