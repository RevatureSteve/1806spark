package com.revature;

import java.util.Scanner;

import com.revature.dao.FlashCardDao;
import com.revature.dao.FlashCardDaoImpl;
import com.revature.pojo.FlashCard;
import com.revature.presentation.Menus;

public class Driver {
	


	/*
	 * 	JDBC: Java Database Connectivity 
	 * 		JDBC is an API
	 * 	JDBC API to connect to RDBMS not just OracleDB
	 * 	
	 *  We can connect to any RDBMS that has a jar
	 * 			available that implements the JDBC API
	 * 
	 * 	JDBC is a set of Interfaces given to each DB
	 * 		to implement so we can quickly switch from
	 * 		one DB to another if needed without changing much
	 * 		code.
	 * 
	 * 		IQ
	 * 	The important/common interfaces of JDBC
	 * 		1. *Connection*
	 * 		2. 	statement (from Connection): NEVER USE, use preparedStatement instead
	 * 		3.  preparedStatement (from Connection) better security and readability
	 * 		4.  callableStatement (from Connection) invoking stored procedures
	 * 
	 * 		I require a Connection to do one of the others
	 * 			at a time.
	 * 
	 * 			IQ
	 * 		What is required for a Connection??
	 * 			1. The *Driver*: the jar that implements
	 * 			JDBC for that specific DB
	 * 				-a jar for OracleDB
	 * 				-a jar for MySQL (DB)
	 * 				-a jar for SQL Server (DB)
	 * 				-etc
	 * 			2. URL to the db
	 * 			3. username
	 * 			4. password
	 * 
	 * 		JAR: Java Archive
	 * 			Multiple compiled .class files into one executable file
	 * 
	 * 		No suitable driver found for jdbc: YOU DID NOT ADD YOUR JAR!
	 * 
	 * 		If you ask yourself why don't I see data in Java but it is found in SQL Developer?
	 * 			COMMIT;
	 * 		2 separate connections cannot read each others uncommited data!
	 * 		
	 * 		Need multiple objects (records) from the database? 
	 * 		Use a Collection like List<FLashCard> flashcardList = new ArrayList<>();
	 * 
	 * 
	 * 		3 Layers in Java Enterprise Architecture
	 * 			1. Presentation: Display data(pojo's current state) to the user and take input
	 * 			2. Business Logic: modify input (again the pojo), redirect user to proper presentations, call persistence methods when needed
	 * 			3. Persistence 
	 * 
	 * 		Note IQ: JDBC autocommits by default
	 * 			Which means each individual sql statement will be treated as a transaction
	 * 			But what if I need to do 2 or more inserts and treat it as a single transaction?
	 * 				*I need to setAutocommit(false) on the connection*
	 * 
 	 */
	public static void main(String[] args) {
		System.out.println("test");
		FlashCardDao fcDao = new FlashCardDaoImpl(); 
	
		Menus.welcome();
		FlashCard userInputFlashCard = Menus.createFlashCardMenu();
		System.out.println(userInputFlashCard);
		
		 fcDao.createFlashCardProc(userInputFlashCard);
		
	}
	
	
}



