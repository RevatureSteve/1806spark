package com.revature;

import com.revature.dao.FlashCardDao;
import com.revature.dao.FlashCardDaoImpl;
import com.revature.domain.FlashCard;

public class MainClass {

	
	/*
	 * Hibernate
	 * 	Where do we configure the most important object?
	 * 		hibernate.cfg.xml -configuration for the SessionFactory
	 * 	 
	 * 	3 states of Hibernate:
	 * 		transient: not yet connected to DB
	 * 		persistent: has interacted with the session
	 * 		detached: session closed, object no longer connected to db
	 * 
	 * 	Important Interfaces:
	 * 		1. Configuration
	 * 		2. SessionFactory
	 * 		3. Session
	 * 		4. Transaction
	 * 		5. Criteria
	 * 		6. Query
	 * 
	 */
	public static void main(String[] args) {
		FlashCardDao dao = new FlashCardDaoImpl();
		
		//Get a FC
		FlashCard fc = dao.getFlashCardById(2);
		
		//Create a FC
//		FlashCard fc = new FlashCard("Whats Java favorite color?1","bean");
//		dao.createFlashCard(fc);
		System.out.println(fc);
	}

}
