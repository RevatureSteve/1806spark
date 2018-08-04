package com.revature;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.dao.FlashCardDao;
import com.revature.pojo.FlashCard;

public class FlashCardDaoImpl implements FlashCardDao{
	
	private static final String USERNAME= "flashcard_db";
	private static final String PASSWORD= "p4ssw0rd";
	private static final String URL= "jdbc:oracle:thin:@tylertraining.cnmoc1mujdcw.us-east-2.rds.amazonaws.com:1521:ORCL";

	@Override
	public List<FlashCard> getAllFlashCards() {
		List<FlashCard> myFlashCards = new ArrayList<>();
		
		try {
			String sql = "SELECT * FROM flash_cards";  //Query
			Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			System.out.println(rs);
			//loop through the result set of flash card libraries
			while(rs.next()) {
				
				System.out.println("ID: " + rs.getInt(1) + "Question: " + rs.getString("fc_question") //can use getString(column) ....ctrl space for options
				+ " Answer: " + rs.getString("fc_answer"));
				
			FlashCard fc = new FlashCard(rs.getInt(1), rs.getString("fc_question"),rs.getString("fc_answer")  );	
			System.out.println(fc);
			myFlashCards.add(fc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	return myFlashCards;
		
	}

	@Override
	public FlashCard getFlashCardByID(int id) {
FlashCard fc = null;
		
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);){
			String sql = "SELECT * FROM flash_cards WHERE fc_id = 21";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			if(rs.next()) {
			fc = new FlashCard(rs.getInt(1), rs.getString("fc_question"),rs.getString("fc_answer") );
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	return fc;
		
	}


	@Override
	public int createFlashCard(FlashCard fc) {
		int rowsAffected = 0;
		try (Connection conn = DriverManager.getConnection(URL,  USERNAME,  PASSWORD);){
			String sql = "INSERT INTO flash_cards(fc_question, fc_answer) VALUES(?,?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			//After setting your SQL we now need to register teh parameters of the SQL statement 
			ps.setString(1,  fc.getFcQuestion());//what is the data type of the first...that is String for the question and it is the ist
			ps.setString(2, fc.getFcAnswer());
			rowsAffected = PreparedStatement.executeUpdate(sql);
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		return rowsAffected;
	}

	@Override
	public void createFlashCardProc(FlashCard fc) {
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);){
			String sql = "call insert_fc_procedure(?,?,?)";
			String msg = msg;
			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1,  fc.getFcQuestion());
			cs.setString(2,fc.getFcAnswer() );
			cs.setString(3,msg);
			
			int rowsAffected = cs.executeUpdate();
			System.out.println("rows affected: " + rowsAffected);
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
