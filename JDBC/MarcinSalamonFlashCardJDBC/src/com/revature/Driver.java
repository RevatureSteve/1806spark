package com.revature;

import com.revature.dao.FlashCardDao;
import com.revature.dao.FlashCardDaoImpl;
import com.revature.pojos.FlashCard;
import com.revature.presentation.Menus;

public class Driver {
	
	
	/*
	 * JDBC: Java Database Connectivity JDBC is an API JDBC API to connect to RDBMS
	 * not just OracleDB
	 * 
	 * we can connect to any RDBMS that has a jar available that implements the JDBC
	 * API
	 * 
	 * JDBC is a set of Interfaces given to each DB to implement so we can quickly
	 * switch from one DB to another if needed without changing much code
	 * 
	 * The important/common interfaces of JDBC 1. Connection
	 * 
	 * 3 layers in java enterprise architecture
	 * 		presentation
	 * 		business logic
	 * 		persistence
	 */
	public static void main(String[] args) {
		System.out.println("print"); 
		FlashCardDao fcdao = new FlashCardDaoImpl();
		
		Menus.welcome();
		FlashCard userInputFlashCard = Menus.createFlashCardMenu();
		System.out.println(userInputFlashCard);
		
		int successful = fcdao.createFlashCard(userInputFlashCard);
		
		System.out.println("success?" + successful);
//		List<FlashCard> flashCardList = getFlashCards();

		
	}
	
}
