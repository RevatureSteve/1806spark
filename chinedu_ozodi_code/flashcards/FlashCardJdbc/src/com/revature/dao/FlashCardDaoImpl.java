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
	
	static final String USERNAME = "flashcard_db";
	static final String PASSWORD = "p4ssw0rd";
	static final String URL = "jdbc:oracle:thin:@mydbinstance.ckb7pkj7urqv.us-east-2.rds.amazonaws.com:1521:ORCL";

	public FlashCardDaoImpl() {
	}
	// CREATE
	@Override
	public int createFlashCard(FlashCard fc) {
		int rowsAffected = 0;
		try(Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
			String sql = "INSERT INTO flash_cards(fc_question, fc_answer) VALUES (?,?)";
			
//			Statement statement = conn.createStatement();
			PreparedStatement ps = conn.prepareStatement(sql); //Will first take in your sql code without variable (variable place holder
			//Now need to register parameters of the SQL statement
			ps.setString(1, fc.getFc_question());
			ps.setString(2, fc.getFc_answer());
			rowsAffected = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rowsAffected;
	}
	
	@Override
	public int createFlashCardProc(FlashCard fc) {
		try(Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
			String sql = "{call insert_fc_procedure(?,?,?)}"; // Surround in {}
			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, fc.getFc_question());
			cs.setString(2, fc.getFc_answer());
			cs.setString(3, "");
			return cs.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	// READ
	@Override
	public List<FlashCard> getFlashCards() {
		List<FlashCard> fc_list = new ArrayList<FlashCard>(); 
		
		//Get a Connection to the OracleDB
		// Use the DriverManager
		try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);) {
			String sql = "SELECT * FROM flash_cards";
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			System.out.println(resultSet);
			//Loop through the resultset of flashcard records
			while(resultSet.next()) {				
				FlashCard fc = new FlashCard(resultSet.getInt(1), resultSet.getString("fc_question"), resultSet.getString("fc_answer"));
				fc_list.add(fc);
//				System.out.println(fc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return fc_list;
	}

	@Override
	public FlashCard getFlashCardById(int id) {
		//Get a Connection to the OracleDB
				// Use the DriverManager
				FlashCard fc = null;
				
				try(Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);) {
					String sql = "SELECT * FROM flash_cards WHERE fc_id = " + id;
					Statement statement = conn.createStatement();
					ResultSet resultSet = statement.executeQuery(sql);
					
					if(resultSet.next()) {				
						fc = new FlashCard(resultSet.getInt(1), resultSet.getString("fc_question"), resultSet.getString("fc_answer"));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				return fc;
	}




}
