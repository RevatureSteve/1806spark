package com.revature;

import com.revature.dao.FlashCardDao;
import com.revature.dao.FlashCardDaoImpl;
import com.revature.pojo.FlashCard; 
import com.revature.presentation.Menus;
/*
 * imported these because of the classes below 
 * No classes required to be made
 * Make sure you import the correct class
 */


public class Driver {
	
	/*
	 * JDBC: Java Database Connectivity
	 * 		JDBC is an API
	 * 
	 * JBBC API to connect to RDBMS and not just OracleDB
	 * 
	 * We can connect to any RDBMS that has a jar 
	 * 		available that implements the JDBC API
	 * 
	 * JDBC is a set of Interfaces given to each DB 
	 * 		to implement so we can quickly switch from 
	 * 		one DB to another if needed w/o much code.
	 * 
	 * The important interfaces of JDBC
	 * 		1. connection (most important) 
	 * 		2. statement (from the connection) NEVER USE!
	 * 		3. prepredStatement (from Connection) WILL ALWAYS USE THIS INSTEAD!
	 * 		4. callableStatement (from Connection)
	 * 
	 * 		I require a connection to so one of the others 
	 * 		at a time.
	 * 
	 * 		JAR: Java Archive
	 * 			Multiple Compiled .class files into one executable		
	 * 
	 * 		What is required for a connection?
	 * 			1. The Driver: the jar that implements JDBC
	 * 			or that specific DB
	 * 				-a jar for OravleDB
	 * 				-a jar for MySQL (DB)
	 * 				-a jar for SQL Server (DB)
	 * 				-ect
	 * 			2. URL to the DB
	 * 			3. Username
	 * 			4. Password
	 * 
	 * 		Need multiple objects(records) from the database? 
	 * 		Use a Collection like List<FlashCard> flashcardList = new ArrayList<>(); 
	 * 
	 * 		3 Layers in Java Enterprise Architecture
	 * 			1. Presentation: display data (pojo's current state) to the user and take input
	 * 			2. Business Logic: modify input (again the pojo), redirect user to proper presentations, call persistance methods when needed
	 * 			3. Persistance
	 */
	public static void main(String[] args) {
		System.out.println("test");
		FlashCardDao fcDao = new FlashCardDaoImpl();
		
		Menus.welcome();
		FlashCard userInputFlashCard = Menus.createFlashCardMenu();
		System.out.println(userInputFlashCard);
		
		fcDao.createFlashcardProc(userInputFlashCard);
	}
}
	
	
	
	
	
	

