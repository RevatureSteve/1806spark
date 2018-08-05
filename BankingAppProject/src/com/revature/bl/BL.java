package com.revature.bl;

import com.revature.pojo.Users;
import com.revature.Screen;
import com.revature.dao.BankDao;
import com.revature.dao.BankDaoImpl;

public class BL {

	public static Users validateUser(String username, String password) {
		BankDao bd = new BankDaoImpl();
		Users user = Users.prelimUser();
		if (bd.getUsersByUsername(username) != null) {
			if (user.getPassword().equals(password)) {
				System.out.println("Welcome " + user.getFname());
				return user;
			}
		}
		return null;
	}
	
	
}
