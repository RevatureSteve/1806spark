package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import com.revature.dao.UsersDao;
import com.revature.domain.Reimbursement;
import com.revature.domain.Users;

public class UserBuisnessLogic {
	
	private UsersDao usersDao = new UsersDao();
	
	/**
	 * Checks to see if user exists and if passwords match
	 * @param email
	 * @param password
	 * @return user if user exists, null otherwise
	 */
	public Users login(String email, String password) {
		Users user = usersDao.getUserByEmail(email);
		if (user != null) {
			if(user.getPassword().equals(password)) {
				return user;
			}
		}
		return null;	
	}
	
	
	public Users getUserByEmail(String email) {
		return usersDao.getUserByEmail(email);
	}
	
	
	/**
	 * gets all the users from the Dao
	 * @return
	 */
	public List<Users> getAllUsers(){
		return usersDao.readUsers();
	}

}
