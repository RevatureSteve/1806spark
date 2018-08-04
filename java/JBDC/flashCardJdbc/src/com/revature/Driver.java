package com.revature;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
// double check that you import the correct Class
import java.util.List;

import com.revature.pojo.FlashCard;

public class Driver {

	/*
	 * JCBC: JAVA DATABASE CONNECTIVITY JDBC IS A API
	 * 
	 * JDBC is used to connect to RDBMS not just oracle we can connect to any rdms
	 * that have a jar AVAILABLE thAT IMPLEMENTS THE JDBC API
	 * 
	 * JDBC is a set of interfaces given to each DB to implement so we can quickly
	 * switch from one database to another if needed without changing much code
	 * 
	 * IVQ
	 *
	 * the important /common interfaces of JDBC 1. connection interface 2. statement
	 * (from connection) 3. preparedStatement (form connection) 4. callableStatement
	 * (from connection)
	 * 
	 * I require a connection to be do one of the others at a time.
	 * 
	 * IVQ what is required for a connection? 1. the driver: the JAR that implements
	 * JDBC for that specific DB - a jar for oracleDB - a jar for mysql - a jar for
	 * sql server etc
	 * 
	 * 2. url to the database 3. username and 4. password
	 * 
	 * JAR: java archive multiple compile .class files into one executable file
	 * 
	 * db url : octocat.czuadbiw1r4y.us-east-2.rds.amazonaws.com, ORCL --> this is
	 * database url port: 1521 flashcard_db p4ssw0rd user name: flashcard_db
	 * password:p4ssw0rd
	 * 
	 * ///note/// no suitable driver found mean that the jar file is missing: 1. the
	 * driver: the JAR that implements
	 * 
	 * if you asked your self why dont you see data in java but it is found in SQL
	 * developer? COMMIT; 2 seperate connections cannot read each other uncommitted
	 * data!!!!
	 * 
	 * need multiple objects(records) from the database? used a collection like
	 * list<FlashCard> flashCardList = new ArrayList<>();
	 * 
	 * 3 layers in java EE architecture
	 * 1. presentation: display data(pojo's current state) to the user and take input
	 * 2. business logic : modify input, redirect user, to proper presentations,call persistence methods when needed
	 * 3. persistence  :
	 * 
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("testing");
		List<FlashCard> mainFlashCards = getFlashCards();

		// I want to print the
	}

//	public static List<FlashCard> getFlashCard(){
//		
//	}

	public static List<FlashCard> getFlashCards() { // create new function/method

		String username = "flashcard_db";
		String password = "p4ssw0rd";
		// nospace in url
		String url = "jdbc:oracle:thin:@octocat.czuadbiw1r4y.us-east-2.rds.amazonaws.com:1521:ORCL";

		List<FlashCard> myFlashCards = new ArrayList<>();
		// interface implementation

		// get a connection to oracle db
		// used the driveManager

		try {
			String sql = "select * from flash_cards";
			Connection conn = DriverManager.getConnection(url, username, password);
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			System.out.println(rs);
			// look through the resultset of the flashcard records

			while (rs.next()) {
				/*
				 * getInt(column index)
				 * 
				 * or
				 * 
				 * getInt(column label)
				 */
//					System.out.println("ID: " + rs.getInt(1) +"Question: " + rs.getString("fc_question") 
//					+ "Answer:" + rs.getString("fc_anaswer"));

				FlashCard fc = new FlashCard(rs.getInt("fc_id"), rs.getString(2), rs.getString("fc_id"));
				myFlashCards.add(fc);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return myFlashCards;

	}

}
