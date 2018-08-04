package com.revature.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.FlashCard;

public class FlashCardDaoImpl implements FlashCardDao {

	@Override
	public FlashCard getFlashCardById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

public static List<FlashCard> getFlashCards() {
		
		//flashcard_db p4ssw0rd
		// orcl.csyg1eonp1ik.us-east-2.rds.amazonaws.com, 1521, ORCL
		

		
				//get a connection to the oracleDB
				//use the driver manager 
		
		List<FlashCard> myFlashCards = new ArrayList<>();
			
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);){
				String sql = "SELECT * FROM flash_cards";
				
				Statement statement = conn.createStatement();
				ResultSet rs = statement.executeQuery(sql);
				
				System.out.println(rs);
				// loop through the resultset of flashcard records
				while(rs.next()) {
					/*
					 * getInt(column index)
					 * or
					 * getInt(column label)
					 */
//					System.out.println("ID: " + rs.getInt(1) + " Question:" + rs.getString("fc_question")
//					+ " Answer: " + rs.getString("fc_answer"));
					
					FlashCard fc = new FlashCard(rs.getInt(1), rs.getString("fc_question"),rs.getString("fc_answer"));
					myFlashCards.add(fc);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return myFlashCards;
	}
	
public static FlashCard getFlashCardById(int id) {
	FlashCard fc = null;

		
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);){
			String sql = "SELECT * FROM flash_cards  WHERE fc_id = " + id;
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			if(rs.next()) {
				fc = new FlashCard(rs.getInt(1), rs.getString("fc_question"),rs.getString("fc_answer"));
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
			return fc;
		

	
}

}
