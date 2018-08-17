package com.revature.service;

import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.domain.Users;

public class BusinessLogic {

	private UserDao usersDao = new UserDaoImpl();
	
	public Users login (Users usersInput) {
		System.out.println("[LOG]---Starting---Service login() with the argument: " + usersInput);

		Users dbUsers = usersDao.getUserByEmail(usersInput.getEmail());
		System.out.println("[LOG]---Calling the Dao---Service login()");
		
		//checking to see if the DB info is empty
		if (dbUsers != null) {
			System.out.println("[LOG]---dbUsers null check---Service login() status: successful");
			//here we compare the java pw to the sql pw in the database
			if (dbUsers.getPassword().equals(usersInput.getPassword())) {
				System.out.println("[LOG]---Comparing pw---Service login() pw: successful");
				return dbUsers;//return the DB info
			}
		}
		System.out.println("[LOG]---ending---Service login() pw: fail");
		return null;
	}
}
