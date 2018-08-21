package com.revature.logic;

import com.revature.dao.transtarUserDao;
import com.revature.pojo.TranstarUsers;

public class UserLogic {

	private transtarUserDao tuDao = new transtarUserDao();
	
	/**
	 * Compairs paramaters to the database. 
	 * @param email
	 * @param password
	 * @return user / null
	 */
	
	public TranstarUsers login(String email, String password) {
		TranstarUsers user = tuDao.getUser(email);
		if(user != null) {
			if(user.getPassword().equals(password)) {
				return user;
			}
		}
		return null;
	}
	
}
