package com.revature.service;

import com.revature.Dao.UserDao;
import com.revature.Dao.UserDaoImpl;
import com.revature.domain.User;

public class AppService {
/*
 * business logic like login validation
 * 		validate models before persisting
 * 		manipulate models before persisting
 * 		validate user before pulling sensitive data
 * 		etc...
 */
	
	private UserDao userDao = new UserDaoImpl();
	
	// login() returns a valid user object or returns null if the user/pw combo is invalid;
	public User login(User userInput) {
		// return a valid user object or return null
		
		//first pass the userInput's username to the dao to see if there is a
				// a record found in the database with that username
				// yes - assign the user record to a user java object
				// no - then it is null 
		User dbUser = userDao.getUserByUsername(userInput.getUsername());
		
		// since the username might not be ound i could get null back.. check that that!
		if(dbUser != null) {
			// now let's compare the userInput's password to the dbUser's password
			if(dbUser.getPassword().equals(userInput.getPassword())) {
				return dbUser;
			}
		}
		return null;
	}
}
