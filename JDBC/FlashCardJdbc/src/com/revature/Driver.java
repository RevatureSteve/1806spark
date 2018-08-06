package com.revature;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
// double check you imported the right class
import java.util.List;


import com.revature.dao.FlashCardDao;
import com.revature.dao.FlashCardDaoImpl;
import com.revature.pojo.FlashCard;
import com.revature.presentation.Menus;

public class Driver {
	


	/*
	 * 	JDBC: Java Database Connectivity
	 * 		JDBC is an API (Application Programming Interface)
	 * 	JDBC API to connect to RDBMS not just OracleDB
	 * 
	 * 	We can connect to any RDBMS that has a jar
	 * 			available that implements the JDBC API
	 * 	JDBD is a set of interfaces given to each DB
	 * 		to implement so we can quickly switch from
	 * 		one DB to another if needed without changing much code.
	 * 
	 * 	The important/common interfaces of JDBC (IQ)
	 * 		1. Connection (Most Important)
	 * 		2. statement (from Connection): NEVER USE
	 * 		3. preparedStatement (from Connection) better security and readability
	 * 		4. callableStatement (from Connection) invoking stored procedure
	 * 
	 * 		I require a Connection to do one of the others at a time.
	 * 
	 * 		(IQ)What is required for a Connection?
	 * 			1. The *Driver*: the jar that implements JDBC for that specific DB
	 * 				-a jar for OracleDB
	 * 				-a jar for MySQL
	 * 				-a jar for SQL Server (DB)
	 * 				-etc
	 * 		JAR: Java Archive
	 * 			Multiple compiled .class files into one executable file
	 * 			2. URL to the DB
	 * 			3. username
	 * 			4. password
	 * 
	 * 		No suitable driver found for jdbc: YOU DID NOT ADD YOUR JAR!
	 * 
	 * 		Always commit on SQL developer before running
	 * 		2 separate connections cannot read each others uncommitted data
	 * 
	 * 		Need multiple objects (records) from the database?
	 * 		Use a Collection like List<FlashCard> flashcardlist = new ArrayList<>();
	 * 
	 * 
	 * 		3 Layers in Java Enterprise Architecture
	 * 			1. Presentation: Display data(pojo's current state) to the user and take input
	 * 			2. Business Logic: modify input (again the pojo), redirect user to proper presentations, call persistence methods when needed
	 * 			3. Persistence
	 * 
	 * 		(IQ) JDBC commits automatically by default
	 * 			which means each individual sql statement will be treated as a transaction
	 * 			But what is I need to do 2 or more inserts and treat it as a single transaction?
	 * 				* I need to setAutocommit(false) on the connection *
	 */
	public static void main(String[] args) {
		System.err.println("test");
		FlashCardDao fcDao = new FlashCardDaoImpl();
		
		//	take input from a user for creating a flashcard and persist it!
		
		Menus.welcome();
		FlashCard userInputFlashCard = Menus.createFlahsCardMenu();
		System.out.println(userInputFlashCard);
		fcDao.createFlashCardProc(userInputFlashCard);
	}


	

}