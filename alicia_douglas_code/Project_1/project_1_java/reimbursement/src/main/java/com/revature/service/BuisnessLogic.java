package com.revature.service;

import com.revature.dao.UsersDao;
import com.revature.domain.Users;

public class BuisnessLogic {
	
	
	/**
	 * Checks to see if user exists and if passwords match
	 * @param email
	 * @param password
	 * @return user if user exists, null otherwise
	 */
	public Users login(String email, String password) {
		
		Users user = new UsersDao().getUserByEmail(email);
		
		if (user != null) {
			if(user.getPassword().equals(password)) {
				return user;
			}
		}
		
		return null;
		
	}

}
