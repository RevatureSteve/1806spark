package com.revature;


import com.revature.dao.FlashCardDao;
import com.revature.pojo.FlashCard;


public class Driver {
	
	public static void main(String[] args) {
		
	
	
	FlashCardDao fcDao = new FlashCardDaoImpl();
	Menus.Welcome();
	FlashCard userInputFlashCard = Menus.createFlashCardMenu();
	System.out.println(userInputFlashCard);
	
	int successful = fcDao.createFlashCard(userInputFlashCard);
	
	System.out.println("Successful insert? " + successful);
	
	}	
}
//	fcDao.get
//	
//	FlashCard fc = fcDao.getFlashCardById(21);
//	System.out.println(fc);








	
	/*
	 * JDBC: Java DataBase Connectivity
	 * 		JDBS IS an API- Application Programming INterface
	 * JDBC API to connect to Relational Database Management Systems (RDBMS)
	 * 		Can connect to any RDBMS that has a jar available that implements JDBC API
	 * 
	 * JDBC- a set of interfaces given to each database, so we can change DB's quickly without changin much code
	 * Common interfaces of JDBC
	 * 	1. Connection
	 *  2. Statement (from connection)  NEVER USE! use prepared statement instead
	 *  3. Prepared Statement (from Connection)
	 *  4. Callable Statement (from Connection)
	 *  
	 *  I require a connection to do others, you send a statement over a connection
	 *  
	 *  Required for a connection:
	 *  	1. The Driver- the jar that implements JDBC for that specific DB (JAR- Java Archive, compiled .class files into one executable file)
	 *  	2. URL to the db
	 *  	3. username
	 *  	4. password
	 *  flashcard_db
	 *  p4ssw0rd
	 *  tylertraining.cnmoc1mujdcw.us-east-2.rds.amazonaws.com
	 *  1521
	 *  ORCL
	 *  
	 *  Exception sql exception- sorround with try catch
	 *  
	 *  no suitable driver found error for jdbc: YOU DID NOT ADD YOUR JAR!
	 *  
	 *  if you make changes on the DB and want to see it in JAVA, YOU HAVE TO COMMIT! if it's in DB but not in Java, it's because you didn't COMMIT!
	 *  
	 *  if you need multiple objects from the database it must be stored in a collection like List<FlashCard> flashcardList = newArrayList<>();
	 *  
	 *  3 layers in Java Enterprise Architechure
	 *  	1. Presentation: Display data  (pojo's current state) to the user and take input
	 *  	2. Business Logic: modify input, redirect user to proper presenatations, call persistence methods when needed
	 *  	3. Persistence: 
	 *  
	 *  JDBC Auto commits by default
	 *  	each individual sql statement will be treated as a transaction
	 *  	if you need to do two or more inserts and treat it as a single transaction, you need to setAutocommit on the 
	 *  	
	 */


		
		
				

