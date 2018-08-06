package com.revature;



import com.revature.doa.FlashCardImpl;
import com.revature.pojos.FlashCard;
import com.revature.presentation.Menu;

public class Driver {
	/*
	 * JDBC- Java Database Connectivity 
	 * JDBC is an API
	 * JDBC API to connect to RDBMS not just OracleDB
	 * 
	 * 1. Connection-Most important
	 * 2. Statement (From Connection) NEVER USE statement; use prepared statement instead.
	 * 3. Prepared Statement (From Connection)  
	 * 4. Callable  Statement (From Connection)--Invoking stored procedures. 
	 * 
	 * 		*Require a connection to do any of the others at at time.
	 * 
	 * 	What is required for a connection?
	 * 	1. "The Driver" that implements 
	 * 		the JAR  for that specific DB.
	 * 			the JAR for OracleDB*
	 * 			the JAR for MySQL DB
	 * 			the Jar for SQL Server
	 * 				A JAR is a Java Archive : compiled .class file into metadat
	 * 2. URL to the DB
	 * 3. user name
	 * 4. password
	 * We can connect to any RDBMS that has a JAR  available that implements the JDBC API.
	* JDBC is just a set of interfaces
	* 
	* Three Layers
	* Presentation-Display data(POJOs) to the user and take input.
	* Business Logic-Modify input; redirect user to proper 
	* Persistence
	* 
	* 
	* Prepared Statement vs. Statement
	* 		Statement -Poor readability.
	* 				Can have SQL injections. 
	* 		Prepared Statements- prevents them better. Pre-compiles the SQL ttring without the user input , looks for SQL keywords, will
	* only ever execute those key words regardless what the user enters. 
	* NOTE: JDBC auto commits by default.
	*  To turn off, need to set auto commit to false on the  connection
	*  				conn.setAutoCommit = false;
	*  				At the end conn.commit();
	 */

	public static void main(String[] args) {
		System.out.println("text");
		FlashCardImpl fcd = new FlashCardImpl();
		
		FlashCard fc = fcd.getFlashCardById(1);
		System.out.println(fc);
		FlashCard fc1 = fcd.getFlashCardById(2);
		System.out.println(fc1);
		FlashCard fc2 = fcd.getFlashCardById(3);
		System.out.println(fc2);
		
		FlashCard userInputFlashCard = Menu.createFlashCardMenu();
		System.out.println(userInputFlashCard);
		
		Menu.createFlashCardMenu();
		
		
}
	

	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


}