package com.revature.service;

import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.domain.User;

public class AppService {
	
	/*
	 * business logic like login validation
	 * 	validate models before persisting
	 * 	manipulate models before persisting
	 * 	validating user before pulling sensitive data
	 * 	etc...
	 * 
	 */

	private UserDao userDao = new UserDaoImpl();
	/**
	 * login() returns a valid user object or return null if the user/pw combo is invalid;
	 * @param userInput
	 * @return
	 */
	public User login(User userInput) {
		System.out.println("[LOG]----Starting---Service login() argument: " + userInput);
		//First pass the userInput's username to the dao to see if there is a
		// record found in the database with that username
		//	Yes - assign the user record to a User java object
		//	No - then it is null
		System.out.println("[LOG]----dao returned---Service login() returned: " + dbUser);
		User dbUser = userDao.getUserByUsername(userInput.getUsername());
		
		//since the username might not be found I could get null back...check for that!
		if(dbUser != null) {
			System.out.println("[LOG]----dbUser null check---Service login()pw: success");
			//now let's compare the UserInput's password to the dbUser's password
			if(dbUser.getPassword().equals(userInput.getPassword())) {
				return dbUser; //not userInput since it doesn't have the userId
			}
			
		}
		System.out.println("[LOG]----dbUser null check---Service login()pw: fail");
		return null;
	}
}
