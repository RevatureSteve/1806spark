/**
 * 
 */
package com.revature.service;

import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.domain.User;

/**
 * @author sethc
 *
 */
public class AppService {
	
	/*
	 * business logic like login validation
	 * 	   validate models before persisting
	 *     validate user before pulling sensitive data
	 *     etc.. 
	 */

	private UserDao userDao = new UserDaoImpl();
	
	/**
	 * login() return a valid user object or return null if th user/pw combo is invalid;
	 * @param userInput
	 * @return
	 */
	
	public User login(User UserInput) {
		System.out.println("[log] starting service arg: " + UserInput);
		// return a valid user object or return null
			// first pass the userInput 's username to the dao to 
		    //see if there is a record found in the database with that user name
		    // yes - assign the user record to the user java object
		    // no - then it null
		User dbUser = userDao.getUserByUsernamw(UserInput.getUsername());
		System.out.println("[log] starting service arg: " +  dbUser);
	//User dbUser1 =	userDao.getUserByUsernamw(UserInput.getUsername());
	
	if(dbUser != null) {
		// now let us compare the user input's password to the dbUser's password
		 if (dbUser.getPassword().equals(UserInput.getPassword()));
		 		return dbUser; // not userInput since it doesnt have the userId
	}
	
	
		return null;
		
	}
	
}
