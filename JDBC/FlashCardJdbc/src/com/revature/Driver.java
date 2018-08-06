package com.revature;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.dao.FlashCardDao;
import com.revature.dao.FlashCardDaoImpl;
import com.revature.pojo.BankUsers;
import com.revature.presentation.Menus;


public class Driver {
	private final static String USERNAME = "flashcard_db";
	private final static String PASSWORD = "p4ssw0rd";
	private final static String URL = "jdbc:oracle:thin:@gooddata.chd4toccqgaj.us-east-2.rds.amazonaws.com:1521:ORCL";

	/*
	 * JDBC: Java DatatBase Connectivity
	 * 			JDBC is an API
	 * JDBC API to connect to RDBMS not just OracleDB
	 *
	 * 	We can connect to any RDBMS that has a jar
	 * 			available that implements the JDBC API
	 * 
	 * 	JDBC is just a set of interfaces given to each DB
	 * 	to implement so we can quickly switch from one DB to another
	 * if needed without changing much code.
	 * 
	 * The important/common interface of JDBC
	 * 		1. Connection
	 * 		2. Statement (from Connection) !!NEVER USE!! use preparedStatment instead
	 * 		3. preparedStatment (from connection)
	 * 		4.  callableStatement (for connection)
	 * 
	 * 		I require a connection to do one of the others at a time.
	 * 
	 * 		What is required for a connection?
	 * 			1. Driver : the jar that implements
	 * 			JDBC for that specific DB
	 * 				-a jar for OracleDB
	 * 				-a jar for MySQL  (DB)
	 * 				-a jar for SQL Server (DB)
	 * 				-etc
	 * 			2. URL to the db
	 * 			3. USERNAME
	 * 			4. PASSWORD
	 * 			
	 * 		JAR: Java Archive 
	 * 			Multiple Complied .class files into one .exe file
	 * 
	 * 		No suitable driver found for jdbc: YOU DID NOT ADD YOUR JAR!!!!!!
	 * 
	 */
	public static void main(String[] args) {
		System.out.println("Testing...");
		FlashCardDao fcDao = new FlashCardDaoImpl();

		Menus.welcome();
		BankUsers userInputFlashCard = Menus.createFlashCardMenu();
		System.out.println(userInputFlashCard);
		fcDao.creatFlashCardProc(userInputFlashCard);
		
		System.out.println(userInputFlashCard);
		
		
		
	}
	
}
