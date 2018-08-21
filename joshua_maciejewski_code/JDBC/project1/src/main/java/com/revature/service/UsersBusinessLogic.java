package com.revature.service;

import java.util.List;

import com.revature.dao.UsersDao;
import com.revature.dao.UsersDaoImpl;
import com.revature.domain.Users;



public class UsersBusinessLogic {

	private UsersDao dao = new UsersDaoImpl();
	
	public Users login(String email, String password) {
		
		Users user = dao.getUserByEmail(email);
		
		if(user != null) {
			if(user.getPassword().equals(password)) {
				
				return user;
			}
		}
		return null;
		
	}
	

public List<Users> viewAllEmployees(){
	return dao.getAllEmployees();
}


public void changeEmployeeInfo (int uID, String email, String password, String fname, String lname) {
	
}
	
}
