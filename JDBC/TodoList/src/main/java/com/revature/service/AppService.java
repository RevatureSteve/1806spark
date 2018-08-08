package com.revature.service;

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
	
	private UserDao userDao = new UserDaoImpl();
	
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
				return dbUser;//not usernput since it 
			}
		}
		return dbUser;
	}
}
