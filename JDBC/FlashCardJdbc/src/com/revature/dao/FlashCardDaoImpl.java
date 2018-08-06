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

import com.revature.pojo.BankUsers;

public class FlashCardDaoImpl implements FlashCardDao{
	private final static String USERNAME = "flashcard_db";
	private final static String PASSWORD = "p4ssw0rd";
	private final static String URL = "jdbc:oracle:thin:@gooddata.chd4toccqgaj.us-east-2.rds.amazonaws.com:1521:ORCL";
	
	
	//"INSERT INTO flash_cards(fc_question, fc_answer) VALUES('" + fc.getFcQuestion() + ',' + fc.getFcAnswer()+ "')";
//CREATE
	//con.setAutoCommit (false);
	//con.commit();
	@Override
	public int createFlashCard(BankUsers fc) {
		int rowsAffected = 0;
try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);){
	String sql = "INSERT INTO flash_cards(fc_question, fc_answer) VALUES (?,?)";
	//Statement statement = con.createStatement();
	PreparedStatement ps = con.prepareStatement(sql);
	ps.setString(1, fc.getFcQuestion());
	ps.setString(2, fc.getFcAnswer());
	rowsAffected = ps.executeUpdate();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
		return rowsAffected;
	}
	@Override
	public void creatFlashCardProc(BankUsers fc) {
		try (Connection con = DriverManager.getConnection(URL,USERNAME, PASSWORD);){
			String sql = "{call insert_fc_procedure(?, ?, ?)}";
			String msg = "";
			CallableStatement cs = con.prepareCall(sql);
			cs.setString(1, fc.getFcQuestion());
			cs.setString(2, fc.getFcAnswer());
			cs.setString(3, msg);
			int rowsAffected = cs.executeUpdate();
			System.out.println("Rows Affectected: " + rowsAffected);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

//READ
	@Override
	public List<BankUsers> getAllFlashCards() {
		List<BankUsers> myFlashCards = new ArrayList<>();
		try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
			String sql = "SELECT * FROM flash_cards";
			
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while(rs.next()) {
				
				BankUsers fc = new BankUsers(rs.getInt(1), rs.getString("fc_question"), rs.getString("fc_answer"));
				myFlashCards.add(fc);
			}
			//loop through the resultset of flashcard records
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return myFlashCards;
	}

	@Override
	public BankUsers getFlashCardById(int id) {
		BankUsers fc = null;
		try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);){
			String sql = "SELECT * FROM flash_cards WHERE fc_id =" + id;
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			if(rs.next()) {
				fc = new BankUsers(rs.getInt(1), rs.getString("fc_question"), rs.getString("fc_answer"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return fc;
	}

	


}
