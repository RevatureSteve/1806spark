package com.revature.driver;

import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.domain.User;

public class Driver {
	
	public static void main(String[] args) {
		System.out.println("Testing");
	
		UserDao userdao = new UserDaoImpl();
		
		User testuser = null;
		
		testuser = userdao.getUserbyEmail("mikejones@mikejones.com");
		System.out.println("Double testing");
		System.out.println(testuser);
		userdao.getUserbyEmail(email);
	
	}

}
