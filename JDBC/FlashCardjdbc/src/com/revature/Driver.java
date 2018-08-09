package com.revature;

import com.revature.dao.FlashCardDao;
import com.revature.dao.FlashCardDaoImpl;
import com.revature.pojo.FlashCard;
import com.revature.presentation.Menus;

public class Driver {
	
	
//	
//	private final static String USERNAME = "flashcard_db";
//	private final static String PASSWORD= "p4ssw0rd";
//	private final static String URL = "jdbc:oracle:thin:@orcl.csyg1eonp1ik.us-east-2.rds.amazonaws.com:1521:ORCL";
	
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
	 *     3. preparedStatement (from Connection) better connectivity and security 
	 *     4. callableStatement (from Connection) invoking stored procedures 
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
	 *     no suitable driver found for jdbc: you did not add your jar 
	 *     
	 *     if you ask yourself why don't see data in java but it is found in SQL defeloper?
	 *     	COMMIT
	 *     
	 *     need multiple objects(records) from the database? use a Collection like 
	 *     list<FlashCard> flashcardlist = new Arraylist<>();
	 *     
	 *     
	 *     3 layers in java enterprise architecture
	 *     1.presentation: display data (pojo's current state) to the user and take input 
	 *     2. business logic: modify input (pojo), redirect user to proper presentations, call persistence methods when needed
	 *     3. persistence : 
	 *     
	 *     note IQ: JDBC autocommits by default 
	 *     	which means each individual sqp statement will be treated as a transaction 
	 *     but what if i need 2 or more inserts and treat it as a single transaction?
	 *     		i need to set autocommit(false) on the connection*
	 *     
	 */

	
	public static void main(String[] args) {
		System.out.println("test");
		FlashCardDao fcDao = new FlashCardDaoImpl();
		FlashCard fc = fcDao.getFlashCardById(1);
		System.out.println(fc);
		
		//take an input from user for creating a flashcard and persisting 
		
		
		Menus.welcome();
		FlashCard userInputFlashCard = Menus.createFlashCardMenu();
		
		
		System.out.println(userInputFlashCard);
		
		int successful = fcDao.createFlashCard(userInputFlashCard);
		
		System.out.println("successful insert? " + successful);
				
		
		
	}
//	
//	public static List<FlashCard> getFlashCards() {
//		
//		//flashcard_db p4ssw0rd
//		// orcl.csyg1eonp1ik.us-east-2.rds.amazonaws.com, 1521, ORCL
//		
//
//		
//				//get a connection to the oracleDB
//				//use the driver manager 
//		
//		List<FlashCard> myFlashCards = new ArrayList<>();
//			
//		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);){
//				String sql = "SELECT * FROM flash_cards";
//				
//				Statement statement = conn.createStatement();
//				ResultSet rs = statement.executeQuery(sql);
//				
//				System.out.println(rs);
//				// loop through the resultset of flashcard records
//				while(rs.next()) {
//					/*
//					 * getInt(column index)
//					 * or
//					 * getInt(column label)
//					 */
////					System.out.println("ID: " + rs.getInt(1) + " Question:" + rs.getString("fc_question")
////					+ " Answer: " + rs.getString("fc_answer"));
//					
//					FlashCard fc = new FlashCard(rs.getInt(1), rs.getString("fc_question"),rs.getString("fc_answer"));
//					myFlashCards.add(fc);
//				}
//				
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		return myFlashCards;
//	}
//	

	
	/**
	 * need a single flashcard back from the database?
	 * 		create a get method and search by a unique field (column 
	 * @param id
	 * @return
	 */
	
//	public static FlashCard getFlashCardById(int id) {
//		FlashCard fc = null;
//	
//			
//			try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);){
//				String sql = "SELECT * FROM flash_cards  WHERE fc_id = " + id;
//				Statement statement = conn.createStatement();
//				ResultSet rs = statement.executeQuery(sql);
//				
//				if(rs.next()) {
//					fc = new FlashCard(rs.getInt(1), rs.getString("fc_question"),rs.getString("fc_answer"));
//				}
//					
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//				return fc;
//			
//	
//		
//	}
	
	
	
	
}
