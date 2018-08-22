package com.revature;

<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 4eb29dca203a33cdc98ed607180e8dc41eace9bf
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
<<<<<<< HEAD
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
=======
import java.util.Scanner;
=======
// double check you imported the right class
import java.util.List;

>>>>>>> 4eb29dca203a33cdc98ed607180e8dc41eace9bf

import com.revature.dao.FlashCardDao;
import com.revature.dao.FlashCardDaoImpl;
import com.revature.pojo.FlashCard;
import com.revature.presentation.Menus;

public class Driver {
	


	/*
<<<<<<< HEAD
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
=======
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
>>>>>>> 4eb29dca203a33cdc98ed607180e8dc41eace9bf
	 * 
	 * 
	 * 		3 Layers in Java Enterprise Architecture
	 * 			1. Presentation: Display data(pojo's current state) to the user and take input
	 * 			2. Business Logic: modify input (again the pojo), redirect user to proper presentations, call persistence methods when needed
<<<<<<< HEAD
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



>>>>>>> fa66388667395c761e59539daaea36af9d01238b
=======
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
>>>>>>> 4eb29dca203a33cdc98ed607180e8dc41eace9bf
