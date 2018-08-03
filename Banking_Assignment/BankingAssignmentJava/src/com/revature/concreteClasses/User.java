package com.revature.concreteClasses;

import com.revature.abstractClasses.People;

public class User extends People {

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(int userId, String fname, String lname, String username, String password) {
		super();
		this.userID = userId;
		this.fname = fname;
		this.lname = lname;
		this.username = username;
		this.password = password;
		
	}
	
	

	
	
}
