package com.revature;

import com.revature.dao.UserDaoImpl;
import com.revature.domain.User;

public class Driver {

	public static void main(String[] args) {
		System.out.println("testing project");
		
		/*
		 * Service class for 
		 * 		compare username w/ db
		 * 		compare pwd w/ db
		 * UserDao:
		 * 		get username/pw
		 * POJO:
		 * 		user: id, username, pw
		 * 		task: tUd, uId, tName, tslevelId, tsLevel
		 * 		
		 */
		
		String username = "Steve";
		String pwIndput = "Revature";
		
		UserDaoImpl udi = new UserDaoImpl(); 
		User user = udi.getUserByUsername(username);
		
		System.out.println(user);
		
	}

}
	