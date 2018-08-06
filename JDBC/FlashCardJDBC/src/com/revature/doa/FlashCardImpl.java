package com.revature.doa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.FlashCard;

public class FlashCardImpl implements FlashCards {
	
	

	

	
	private static final String USERNAME = "Flashcard_DB";
	private static final String PASSWORD = "p4ssw0rd";
	private static final String URL ="jdbc:oracle:thin:@revaturedatabase.c4iijzopvhom.us-east-2.rds.amazonaws.com:1521:ORCL";
	
	
	//CREATE: A method that will use a create sql statement.
	@Override
	
	public int createFlashCard(FlashCard fc) {
		
		return 0;
	}
	//READ: A method that will use a select sql statement
	@Override
	public List getFlashCards() {
		  List<FlashCard> myFlashCards = new ArrayList<>();
			try(Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
				String sql = "SELECT * FROM flash_cards;";
				Statement statment = conn.createStatement();
				ResultSet rs = statment.executeQuery(sql);
			//loop through the 
			while(rs.next()) {
				System.out.println("ID " + rs.getInt(1) + "Question" + rs.getString("fc_question")
	+ "Answer" + rs.getString("fc_answer"));		}
			System.out.println(rs);
			FlashCard fc = new FlashCard(rs.getInt(1), rs.getString("fc_question"), rs.getString("fc_answer"));
			
		}catch (SQLException e)
			{
			e.printStackTrace();
			}
			return myFlashCards;
	}

	@Override
	public FlashCard getFlashCardById(int id) {
		FlashCard fc = null;
		try(Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
			String sql = "SELECT * FROM flash_card WHERE fc_id = " + id ;
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			if (rs.next()) {
				fc = new FlashCard(rs.getInt(1), rs.getString("fc_question"), rs.getString("fc_answer"));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return fc;
	}


	//UPDATE: A method that will use a update sql statement.

		//DELETE: A method that will use a delete sql statement. 
	}
	
