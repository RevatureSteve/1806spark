package com.revature;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
//double check you imported the correct class
import java.util.List;

import com.revature.FlashCard;

public class Driver {
	
	private final static String USERNAME = "flashcard_db";
	private final static String PASSWORD= "p4ssw0rd";
	private final static String URL = "jdbc:oracle:thin:@orcl.csyg1eonp1ik.us-east-2.rds.amazonaws.com:1521:ORCL";
	
	/*
	 * JDBC: java database connectivity 
	 * 	JDBC API connect to rdbms not just oracledb
	 * 		we connect to any rdbms that has a jar available that implements the jdbc api
	 * 
	 * jdbc is a set of interfaces given to each db to implement so we can quickly switch 
	 * from on db to another if needed without changing much code 
	 * 
	 * the important/common interfaces of jdbc   IQ
	 *     1. Connection 
	 *     2. statement (from Connection) (statements =  clause) : never use, use preparedStatement instead 
	 *     3. preparedStatement (from Connection)
	 *     4. callableStatement (from Connection)
	 *     
	 *     I require a Connection to do one of the others at a time 
	 *     
	 *     
	 *     what is required for a Connection?? IQ
	 *     	1. the *Driver*: the jar that implements jdbc for that specific DB
	 *     		- a jar for oracleDB
	 *     		- a jar for MySQL
	 *     		- a jar for SQL Server (DB)
	 *     		-etc. 
	 *     2. URL to database
	 *     3. username
	 *     4. password
	 *     
	 *     
	 *     JAR : Java archive
	 *     		multiple compiled .class files into one executable file 
	 *     
	 *     no suitable driver found fo jdbc: you did not add your jar 
	 *     
	 *     if you ask yourself why don't see data in java but it is foudn in SQL defeloper?
	 *     	COMMIT
	 *     
	 *     need multiple objects(records) from the database? use a Collection like 
	 *     list<FlashCard> flashcardlist = new Arraylist<>();
	 *     
	 */

	
	public static void main(String[] args) {
		System.out.println("test");
//		List<FlashCard> mainFlashCards = getFlashCards();
		
		FlashCard fc = getFlashCardById(1);
		System.out.println(fc);
		//I want to print the flash cards here in Main not in getFlashCards()... 
		
//		System.out.println(mainFlashCards);
//		System.out.println(mainFlashCards.get(2));
	}
	
	
	

	
	/**
	 * need a single flashcard back from the database?
	 * 		create a get method and search by a unique field (column 
	 * @param id
	 * @return
	 */
	
	
	
	
	
	
}