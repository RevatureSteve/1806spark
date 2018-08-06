package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
//double check you imported the correct class
import java.util.List;

import com.revature.pogo.FlashCard;

public class FlashCardDaoImpl implements FlashCardDao {
	
	private static final String USERNAME =  "revatureeddie";
	private static final String PASSWORD = "p4ssw0rd";
	private static final String URL = "jdbc:oracle:thin:@octowolf.crtsillkaxup.us-east-2.rds.amazonaws.com:1521:ORCL";

	/*
	 * Why use a preparedStatement over a statement?
	 * 		-poor readability of a statement
	 * "INSERT with variables of a statement: VALUES('" + fc.getFcQuestion() + "', '" + fc.getFcAnswer() + "')";
	 * 		-statement can have SQL Injections while preparedStatement prevents them better
	 * 		Why is that? perpearedStatement precompiles the SQL String without the user input, looks for SQL Keywords
	 * 			will only ever execute those keywords regardless of what the user enters
	 */
	@Override
	public int createFlashCard(FlashCard fc) {
		
		int rowsAffected = 0;
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);){
			/*
			 * need to stop autocommit to run multiple sql statements as a single tx?
			 */
			conn.setAutoCommit(false);
			
			String sql = "INSERT INTO flash_cards (fc_question, fc_answer) VALUES(?, ?)";
//			Statement statement = conn.createStatement(); notice that statement doesn't take a SQL argument while perparedStatement does!
			PreparedStatement ps = conn.prepareStatement(sql); //take in the SQL statement without variable first, use ? instead!
//			After seeing your SQL statement we now need to register the parameters of the SQL statement
			//however many ? you have, you need a ps.set method for each one
			ps.setString(1, fc.getFcQuestion()); //what is the datatype of the 1st ?... that is String for the Question, and it is the 1st ?
			ps.setString(2, fc.getFcAnswer()); //again 2 is the ? number, the 2nd argument is the value
			rowsAffected = ps.executeUpdate();
			conn.commit(); //if you setAutoCommit(false); you must use the commit() on the Connection
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowsAffected;
	}
	
	@Override
	public void createFlashCardProc(FlashCard fc) {
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);){
			String sql = "{call insert_fc_procedure(?, ?, ?)}"; //surround { }, it works without but nothing gets returned...
			String msg = "";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, fc.getFcQuestion());
			cs.setString(2, fc.getFcAnswer());
			cs.setString(3, msg);
			
			int rowsAffected = cs.executeUpdate();
			System.out.println("Rows Affected " + rowsAffected);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<FlashCard> getAllFlashCards() {
//		Get a connection to the OracleDB
//		Use the DriverManager
		List<FlashCard> myFlashCards = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
			String sql = "SELECT * FROM flash_cards";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			System.out.println(rs);
//			loop through resultset of flashcard records
			while (rs.next()) {
				/*
				 * getInt(column Index) or getInt(column label)
				 */
//				rs.getInt(1) is the fc_id value
//				rs.getString("fc_question") is the question value
//				rs.getString("fc_answer") is the answer value
				FlashCard fc = new FlashCard(rs.getInt(1), rs.getString("fc_question"), rs.getString("fc_answer"));
				myFlashCards.add(fc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return myFlashCards;
	}
	
	/**
	 * need a single flashcard back from the database?
	 * 		create a get method and search by a unique field (column)
	 */
	@Override
	public FlashCard getFlashCardById(int id) {
		FlashCard fc = null;
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
			String sql = "SELECT * FROM flash_cards WHERE fc_id = " + id;
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			if (rs.next()) {
				fc = new FlashCard(rs.getInt(1), rs.getString("fc_question"), rs.getString("fc_answer"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fc;
	}

}
