package com.revature.service;

import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.domain.User;

public class AppService {

	/*
	 * business logic like login validation
	 * 		like validation models before persisting
	 * 		manipulate user before pulling sensitive data
	 * 		ect.
	 */
	
	private UserDao userDao = new UserDaoImpl(); 
	
	/**
	 * login() returns a valid user object or return null if the user/pw combo is invalid;
	 * @param userInput
	 * @return
	 */
	public User login(User userInput) {
		//first pass the userInput's username to the dao to see if there is a 
		//		record found in the database w/ that username
		//		yes - assign the user record to a user java object
		//		no - then it is a null
		User dbUser = userDao.getUserByUsername(userInput.getUsername());
		
		//since the username might not be found I could get null back and check for that!
		if (dbUser != null) {
			//now let's compare the userInput's pw to the dbUser
			if(dbUser.getPassword().equals(userInput.getPassword())) {
				return dbUser;
			}
		} 
		
		return null;
	}
}
