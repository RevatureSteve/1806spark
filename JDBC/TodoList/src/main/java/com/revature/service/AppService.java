package com.revature.service;

import java.util.List;

import com.revature.domain.Task;
import com.revature.domain.User;
import com.revaturedao.UserDao;
import com.revaturedao.UserDaoImpl;

public class AppService {

	/*
	 * business logic like login validation
	 * 		validate models before persisting
	 * 		manipulate models before persisting
	 * 		validate user before pulling sensitive data
	 * 		etc...
	 */
	
//	instance scope so each non-static method in this class can use the same object
	private UserDao userDao = new UserDaoImpl();
	
	/**
	 * login() returns a valid user object or returns null if the user/pw combo is invalid
	 * @param userInput
	 * @return
	 */
	
	public User login(User userInput) {
		//First pass the userInputs username to the dao to see if there is a
		//		record found in the database with that username
		//		Yes - assign the user record to a User java object
		//		No - then it is null
		User dbUser = userDao.getUserByUsername(userInput.getUsername());
		
		//since the username might not be found i could get null back..check for that!
		if(dbUser != null) {
			//now let's compare the userInputs password to the dbUsers password
			if(dbUser.getPassword().equals(userInput.getPassword())) {
				return dbUser;//not userInput since it doesn't have the userId
			}
		}
		return dbUser;
	}
	
	public List<Task> getAllTasks(){
		//any validation before asking the db? maybe in future but not at moment
		//so let's call the dao to get Tasks from the DB
		
		return userDao.getAllTasks();
	}
	
	public List<Task> getTasksByUserId(int id){
		
		return userDao.getTasksByUserId(id);
	}
}
