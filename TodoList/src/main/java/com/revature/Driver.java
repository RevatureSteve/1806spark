package com.revature;

import com.revature.domain.User;
import com.revature.service.AppService;

public class Driver {
	/*
	 * Maven Project
	 * gives us a pom.xml
	 */
	public static void main(String[] args) {
	System.out.println("testing a maven project");

	
			String usernameInput = "steve";
			String pwInput = "123";
			
			
			User validUser = new AppService().login(new User(0,usernameInput,pwInput));
			System.out.println("Is the userr valid:" + validUser);
			
//			UserDao userDao = new UserDaoImpl();
//			System.out.println(new UserDaoImpl().getUserByUsername(usernameInput));
	}

}
