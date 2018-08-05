package com.revature.abstractClasses;

import java.util.List;

import com.revature.concreteClasses.BankAccount;
import com.revature.concreteClasses.User;

public interface UserDao {
	
		//This Dao Interface has all the methods that should be further defined ... in order to access and communicate with RDBMS
		
		// Used for CRUD methods
		
		//CREATE: A method that will use an INSERT SQL statement
		public int createUser(User person);
		
//		public void createFlashCardProc(Flashcard fc);
		
		
		
		
		//READ: A method that will use a SELECT (Only for retrieving and getting something back.... NO MANIPULATION... be modular)
		public List<User> getAllUsers();
		public User getUserById(int id);
		public User getUserByUsername(String username);
		public BankAccount getUserBalance(User person);
		
		
		//UPDATE: A method that will use an update SQL statement
		
		
		
		
		//DELETE: A method that will use a delete SQL statement
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
