package com.revature;

import com.revature.dao.FlashCardDao;
import com.revature.dao.FlashCardDaoImpl;
import com.revature.pojo.FlashCard;
import com.revature.presentation.Menus;

public class Driver {
	
	

	/*
	 * 	JDBC: Java Database Connectivity
	 * 		JDBC is an API
	 * 	JDBC API to connect to RDBMS  not just OracleDB
	 * 		We can connect to any RDBMS	that has a jar
	 * 			available that implements the JDBC API
	 * 
	 * 	JDBC is a set of Interfaces given to each DB
	 * 		to implement so we can quickly switch from
	 * 		one DB to another if needed without changing much
	 * 		code.
	 * 
	 * 		IQ
	 * The important/common interfaces of JDBC
	 * 		1. *Connection* - connects your database
	 * 		2.  statement (from connection): NEVER USE, use preparedStatement instead
	 * 		3.  preparedStatement (from connection) better security and readability
	 * 		4.  callableStatement (from connection) invoking stored procedures
	 * 
	 * 		I require a Connection to do one of the others
	 * 			at a time.
	 * 
	 * 			IQ
	 * 		What is required for a Connection?
	 * 			1. The *Driver*: the jar that implements
	 * 			JDBC for that specific DB
	 * 				- a jar for OracleDB
	 * 				- a jar for MySQL
	 * 				- a jar for SQL Server (DB)
	 * 				- etc
	 * 			2. URL to the db
	 * 			3. username
	 * 			4. password 
	 * 
	 * 		JAR: Java Archive
	 * 			Multiple compiled .class files into one executable
	 * 
	 * 
	 * 		No suitable driver found for jdbc: YOU DID NOT ADD YOUR JAR!
	 * 		All the files are connected to a class path
	 * 
	 * 		If you ask yourself why don't I see data in Java but it is found in SQL Developer
	 * 
	 * 		Need multiple objects (records) from the database? 
	 * 		Use a Collection like List<FlashCard> flashcardlist = new ArrayList<>();
	 * 
	 * 
	 * 		3 layers in Java Enterprise Architecture
	 * 			1. Presentation: Display data(pojo's current state), to the user and take input
	 * 			2. Business Logic: modify input, redirect user to proper presentations, call persistence methods when needed
	 * 			3. Persistence: 
	 * 
	 * 		Note IQ: JDBC autocommits by default
	 * 			Which means each individual sql statement will be treated as a ?
	 * 			But what if I need to do 2 or more inserts and treat it as a single transaction?
	 * 				*I need to setAutocommit(false) on the connection*
	 */
	public static void main(String[] args) {
		System.out.println("test");
		
		while(true) {
		FlashCardDao fcDao = new FlashCardDaoImpl();
		
		// take an input from a user for creating a flashcard and persist it
		Menus.welcome();
		
		int findFlashCard = Menus.getFlashCardMenu();
		//System.out.println(findFlashCard);
		
		System.out.println(fcDao.getFlashCardById(findFlashCard));
//		FlashCard userInputFlashCard = Menus.createFlashCardMenu();
//		System.out.println(userInputFlashCard);
//		
////		int successful = fcDao.createFlashCard(userInputFlashCard);
//		
//		fcDao.createFlashCardProc(userInputFlashCard);
//		
//		System.out.println("Successful insert? ");
		}
		
		
	}
	
	
	
}
