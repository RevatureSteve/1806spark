package com.revature;

import com.revature.dao.FlashCardDao;
import com.revature.dao.FlashCardDaoImpl;
import com.revature.pojo.FlashCard;
import com.revature.presentation.Screens;

public class Driver {

	public static void main(String[] args) {
		/*
		 * JDBC: Java Database Connectivity
		 * 		JDBC is an API
		 * JDBC API used to connect ot RDBMS not just OracleDB
		 * 		RDBMS (relational database management system
		 * 		We can connect to any RDBMS that has a jar available that implements the JDBC API
		 * 
		 * JDBC is a set of interfaces given to each DB to implement so we can switch from one DB to another if needed without
		 * 		changing much code
		 * 
		 * The important/common interface
		 * 
		 * 
		 * 3 Layers in Java Enterprise Architecture
		 * 		1. Presentation
		 * 		2. Business Logic
		 * 		3. Persistence
		 */
		System.out.println("test");
		FlashCardDao fcImp = new FlashCardDaoImpl();
		
		Screens.welcome();
		FlashCard userInputFlashCard = Screens.createFlashCardMenu();
		
		System.out.println(userInputFlashCard);
		
//		int success = fcImp.createFlashCard(userInputFlashCard);
		int success = fcImp.createFlashCardProc(userInputFlashCard);
		
		System.out.println("Successful insert? " + success);
		
//		List<FlashCard> fc_list = getFlashCards();
//		System.out.println(fc_list);
		
//		FlashCard fc = fcImp.getFlashCardById(2);
//		System.out.println(fc);
//		
	}

}
