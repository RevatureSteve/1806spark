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

import com.revature.pogo.FlashCard;

public class FlashCardDaoImpl implements FlashCardDao {

	private final static String USERNAME = "flashcard_db";
	private final static String PASSWORD = "p4ssw0rd";
	private final static String URL = "jdbc:oracle:thin:@pvtmad.cz07tejakuok.us-east-2.rds.amazonaws.com:1521:ORCL";

	
	/*
	 *	Why use a preparedStatement over a statement?
	 *		- Poor readability of a statement
	 *	"INSERT INTO flash_cards(fc_question, fc_answer) VALUES('" + fc.getFcQuestion() + ',' + fc.getFcAnswer() + "')";
	 *		- statement can have SQL Injections while preparedStatment prevents them better
	 *		Why is that? preparedStatment precompiles the SQL String without the user input, looks for SQL Keywords
	 *				will only ever execute those keyword regardless of what the user enters
	 *
	 */
	// CREATE
	@Override
	public int createFlashCard(FlashCard fc) {
		int rowsAffected = 0;
		try(Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
			/*
			 * 	Need to stop autocommit to run multiple sql statement as a single tx?
			 */
			String sql = "INSERT INTO flash_cards(fc_question, fc_answer) VALUES(?,?)";
//			Statement statement = conn.createStatement(); notice that statement doesn't take a SQL argument while preparedStatement does!
			PreparedStatement ps = conn.prepareStatement(sql); // take in the SQL statement without variable first, use ? instead
			// After setting your SQL, we now need to register the parameters of theSQL Statement
			// However many ? you have, you need a ps.set method for each one
			ps.setString(1, fc.getFcQuestion()); // What is the datatype of the 1st?... That is String for the Question, and it is the 1st ?
			ps.setString(2, fc.getFcAnswer()); // Again ? is the ? number, the 2nd argument is the value
			rowsAffected = ps.executeUpdate();
			conn.commit(); // if you setAutoCommit(false); you must use the commit() on the connection
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowsAffected;
	}
	
	// READ
	@Override
	public List<FlashCard> getFlashCard() {
		// flashcard_db p4ssw0rd
		// pvtmad.cz07tejakuok.us-east-2.rds.amazonaws.com, 1521, ORCL <--- this makes
		// up the entire URL

		// Get a Connection to the OracleDB
		// Use the DriverManager
		List<FlashCard> myFlashCards = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
			String sql = "SELECT * FROM flash_cards";

			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			System.out.println(rs);

			// loop through the resultset of flashcard records
			while (rs.next()) {
				/*
				 * getInt(column index) or getInt(column label)
				 * 
				 */
//							rs.getInt(1) is the fc_id value
//							rs.getString("fc_question") is the question value
//							rs.getString("fc_answer") is the answer value
				FlashCard fc = new FlashCard(rs.getInt(1), rs.getString("fc_question"), rs.getString("fc_answer"));
				myFlashCards.add(fc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return myFlashCards;

	}

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

	@Override
	public void createFlashCardProc(FlashCard fc) {
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
			String sql = "{call insert_fc_procedure(?, ?, ?)}"; // surround {}, it works without but nothing gets returned...
			String msg = "";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, fc.getFcQuestion());
			cs.setString(2, fc.getFcAnswer());
			cs.setString(3, msg);
			
			int rowsAffected = cs.executeUpdate();
			System.out.println("rows affected: " + rowsAffected);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
