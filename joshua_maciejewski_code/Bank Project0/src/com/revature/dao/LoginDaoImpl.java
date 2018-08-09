package com.revature.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.pojo.BankAccount;
import com.revature.pojo.Users;

public class LoginDaoImpl implements BankDao {
	
	private final static String USERNAME = "bank_db";
	private final static String PASSWORD = "p4ssw0rd";
	private final static String URL = "jdbc:oracle:thin:@orcl.csyg1eonp1ik.us-east-2.rds.amazonaws.com:1521:ORCL";
	
	//orcl.csyg1eonp1ik.us-east-2.rds.amazonaws.com
	
	public Users getUsername(String username) {
		
		Users user = null;
		try(Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
			String sql = "SELECT * FROM users WHERE username = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				user = new Users(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				Users temp = Users.potentialUser();
				temp.setUserId(rs.getInt(1));
				temp.setUsername(rs.getString(2));
				temp.setPassword(rs.getString(3));
				temp.setFirstName(rs.getString(4));
				temp.setLastName(rs.getString(5));
			}
		} catch(SQLException e) {
				e.printStackTrace();
			}
			return user;
		
	}

	@Override
	public BankAccount getAccountInfo(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void enterDeposit(double amt, int accNum) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enterWithdrawal(double amt, int accNum) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createUser(String username, String password, String fname, String lname) {
		// TODO Auto-generated method stub
		
	}

	

	
	}
	
//			@Override
//			public FlashCard getFlashCardById(int id) {
//				FlashCard fc = null;
//				
//				
//				try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);){
//					String sql = "SELECT * FROM flash_cards  WHERE fc_id = " + id;
//					Statement statement = conn.createStatement();
//					ResultSet rs = statement.executeQuery(sql);
//					
//					if(rs.next()) {
//						fc = new FlashCard(rs.getInt(1), rs.getString("fc_question"),rs.getString("fc_answer"));
//					}
//						
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//					return fc;			
//			
			

//	@Override
//	public Users getUsername(String username) {
//		// TODO Auto-generated method stub
//		return null;
//	}



			



//public Users getUsersByUsername(String username) {
//	Users us = null;
//	try(Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
//		String sql = "SELECT * FROM users WHERE username = ?";
//		
//		PreparedStatement ps = conn.prepareStatement(sql);
//		ps.setString(1, username);
//		ResultSet rs = ps.executeQuery();
//		
//		if(rs.next()) {
//			// Boilerplate code
//			us = new Users(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
//			Users temp = Users.prelimUser();
//			temp.setId(rs.getInt(1));
//			temp.setUsername(rs.getString(2));
//			temp.setPassword(rs.getString(3));
//			temp.setFname(rs.getString(4));
//			temp.setLname(rs.getString(5));
//		}
//	} catch (SQLException e) {
//		e.printStackTrace();
//	}
//	return us;

//
//private final static String USERNAME = "flashcard_db";
//private final static String PASSWORD= "p4ssw0rd";
//private final static String URL = "jdbc:oracle:thin:@orcl.csyg1eonp1ik.us-east-2.rds.amazonaws.com:1521:ORCL";
//
//
//
///*
// * why use a preparedStatement over a statement?
// * 		- poor readabiligy 
// * 
// * 		- statement can have sql injections while preparedstatement prevents them 
// * 			-- why is that? preparedStatement precompiles the SQL string without the user input, looks for SQL keywords will
// * 				 only ever execute those keywords regardless of what the user enters 
// * 
// */
////create
//public int createFlashCard(FlashCard fc) {
//	int rowsAffected = 0;
//	try (Connection conn=DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
//		/*
//		 * teed to stop autocommit to run multiple sql statements as a single tx?
//		 */
//		conn.setAutoCommit(false);
//		
//		String sql = "INSERT INTO flash_cards(fc_question, fc_answer) Values(?,?)";
//		Statement statement = conn.createStatement();
//		PreparedStatement ps = conn.prepareStatement(sql); // take in the SQL statement without variable first!
//		// after setting your SQL statement we now need to register the parameters of the SQL statement
//		// however many ? you have, you need a ps.set method for each one 
//		ps.setString(1, fc.getFcQuestion());// what is the datatype of the 1st?.. that is String for the Question and it is the 1st ?
//		ps.setString(2, fc.getFcAnswer()); // again 2 is the ? number, the 2nd argument is the value 
//		rowsAffected = ps.executeUpdate();
//		conn.commit(); // if you setAutoCommit(false you must use the commit() on the connection 
//	} catch (SQLException e) {
//		e.printStackTrace();
//	}
//	return rowsAffected;
//}
//
//
//public void createFlashCardProc(FlashCard fc) {
//	try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
//		String sql = "{call insert_fc_procedure(?, ?, ?)}"; //surround in curly braces 
//		String msg = "";
//		CallableStatement cs = conn.prepareCall(sql);
//		
//		cs.setString(1,  fc.getFcQuestion());
//		cs.setString(2,  fc.getFcAnswer());
//		cs.setString(3,  msg);
//		
//		int rowsAffected = cs.executeUpdate();
//		System.out.println("rows affected: " + rowsAffected);
//		
//	} catch (SQLException e) {
//		e.printStackTrace();
//	}
//	
//}
//
//
//
//
////read
//@Override
//public List<FlashCard> getFlashCards() {
//	//flashcard_db p4ssw0rd
//			// orcl.csyg1eonp1ik.us-east-2.rds.amazonaws.com, 1521, ORCL
//			
//
//			
//					//get a connection to the oracleDB
//					//use the driver manager 
//			
//			List<FlashCard> myFlashCards = new ArrayList<>();
//				
//			try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);){
//					String sql = "SELECT * FROM flash_cards";
//					
//					Statement statement = conn.createStatement();
//					ResultSet rs = statement.executeQuery(sql);
//					
//					System.out.println(rs);
//					// loop through the resultset of flashcard records
//					while(rs.next()) {
//						/*
//						 * getInt(column index)
//						 * or
//						 * getInt(column label)
//						 */
////						System.out.println("ID: " + rs.getInt(1) + " Question:" + rs.getString("fc_question")
////						+ " Answer: " + rs.getString("fc_answer"));
//						
//						FlashCard fc = new FlashCard(rs.getInt(1), rs.getString("fc_question"),rs.getString("fc_answer"));
//						myFlashCards.add(fc);
//					}
//					
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			return myFlashCards;
//}
//
//@Override
//public FlashCard getFlashCardById(int id) {
//	FlashCard fc = null;
//	
//	
//	try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);){
//		String sql = "SELECT * FROM flash_cards  WHERE fc_id = " + id;
//		Statement statement = conn.createStatement();
//		ResultSet rs = statement.executeQuery(sql);
//		
//		if(rs.next()) {
//			fc = new FlashCard(rs.getInt(1), rs.getString("fc_question"),rs.getString("fc_answer"));
//		}
//			
//	} catch (SQLException e) {
//		e.printStackTrace();
//	}
//		return fc;
//	
//
//
//}