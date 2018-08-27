package com.revature;

import com.revature.dao.Dao;
import com.revature.dao.DaoImpl;
import com.revature.domain.Task;
import com.revature.domain.User;

public class Driver {

	
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
		Dao dao = new DaoImpl();
		
		//Get a FC
		Task task = new Task(24,1,"name", 1);
		User user = new User(23,"chin2413", "asldkfj");
		
		//Create a FC
		dao.createTask(task);
		dao.createUser(user);
		System.out.println(user);
		System.out.println(task);
	}

}
