package com.revature.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.model.FlashCard;

public class DaoFcImpl implements Dao {

	private static final String url = "jdbc:oracle:thin:@octocat.ccwgu9dykdjd.us-west-2.rds.amazonaws.com:1521:ORCL";
	private static final String username = "flashcard_db";
	private static final String password = "p4ssw0rd";
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public FlashCard getFc(int id) {
		FlashCard fc = null;
		try(Connection con = DriverManager.getConnection(url, username, password)){
			String sql = "SELECT * FROM flash_cards WHERE fc_id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			fc = new FlashCard(rs.getInt(1),rs.getString(2), rs.getString(3));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fc;
	}

//	public static void main(String[] args) {
//		System.out.println(new DaoFcImpl().getFc(5));
//	}
}
