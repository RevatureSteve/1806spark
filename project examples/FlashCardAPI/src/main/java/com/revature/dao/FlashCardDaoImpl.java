package com.revature.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.FlashCard;

public class FlashCardDaoImpl implements FlashCardDao {

	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USERNAME = "flashcard_db";
	private final String PASSWORD = "p4ssw0rd";
	
	static{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}


	@Override
	public List<FlashCard> findAll() {
		List<FlashCard> fcList = new ArrayList<>();
		try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);){
			String sql = "SELECT * FROM flash_card";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				fcList.add(new FlashCard(rs.getInt("fc_id"), rs.getString("fc_question"), rs.getString("fc_answer")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	return fcList;
		
	}
	//Quick Test -delete after!
//	public static void main(String[] args){
//		System.out.println("testing");
//		List<FlashCard> fc = new FlashCardDaoImpl().findAll();
//		System.out.println(fc);
//	}
} 
