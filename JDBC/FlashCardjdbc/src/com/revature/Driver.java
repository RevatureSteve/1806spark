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
import com.revature.pogo.FlashCard;
import com.revature.presentation.Menus;

public class Driver {
	
	/*
	 * JDBC: Java Database Connectivity
	 * 		JDBC is an API
	 * JDBC API to connect to RDBMS not just OracleDB
	 * 
	 * We can connect to any RDBMS that has a jar 
	 * 		available that implements the JDBC API
	 * 
	 * JDBC is a set of Interfaces given to each DB
	 * 		to implement so we can quickly switch from 
	 * 		one DB to another if needed without changing much code
	 * 
	 * 		IQ
	 * The important/common interfaces of JDBC
	 * 		1. *Connection*
	 * 		2. statement (from Connection): NEVER USE, use preparedStatement instead
	 * 		3. perparedStatement (from Connection) better security and readability
	 * 		4. callableStatement (from COnnection) invoking stored procedures
	 * 
	 * 		I require a Connection to do one of the others at a time
	 * 
	 * 		IQ
	 * 	What is required for a Connection?
	 * 		1. The "Driver": the jar that implements JDBC for that specific DB
	 * 			-a jar for OracleDB
	 * 			-a jar for MySQL
	 * 			-a jar for SQL Server (DB)
	 * 			-etc
	 * 		2. URL to the DB
	 * 		3. username
	 * 		4. password
	 * 
	 * JAR: Archive
	 * 		Multiple compile .class files into one executable file
	 * 
	 * No suitable driver found for jdbc: YOU DID NOT ADD YOUR JAR!
	 * 
	 * If you ask yourself why dont't I see data in have but it is found  in SQL Developer?
	 * 		COMMIT:
	 * 2 seperate connections cannot read each others uncommitted data!
	 * 
	 * Need multiple objects (records) from the database? 
	 * 		Use a collection like List<FlashCard> myFlashCards = new ArrayList<>();
	 * 
	 * 3 layers in Java enterprise Architecture
	 * 		1. Presentation: Display data (pojo's current state) to the user and take input
	 * 		2. Business Logic: modify input, redirect user to proper presentations, call persistence methods when needed
	 * 		3. Persistence
	 * 
	 * Note IQ: JDBC autocommits by default
	 * 		Which means each individual sql statement will be treated as a transaction
	 * 		But what if I need to do 2 or more inserts and treat it as a single transaction?
	 * 			IQ *: I need to set autocommit (false) on the connection*
	 */

	public static void main(String[] args) {
		System.out.println("Test");
		FlashCardDao fcDao = new FlashCardDaoImpl();
		
		
		//take input from a user for creating a flashcard and persist it
		
		Menus.welcome();
		FlashCard flash = fcDao.getFlashCardById(2);
		System.out.println(flash);
		FlashCard userInputFlashCard = Menus.createFlashCardMenu();
		System.out.println(userInputFlashCard);
		
		fcDao.createFlashCardProc(userInputFlashCard);
//		System.out.println("successful insert?" + successful);
		
	}

}
