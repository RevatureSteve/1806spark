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
				
				System.out.println(user);
				return user;
			}
		}
		return null;
		
	}
	

public List<Users> viewAllEmployees(){
	return dao.getAllEmployees();
}

public Users viewEmployeeInfo(int id) {
	return dao.getViewEmployeeInfo(id);
}

public void changeEmployeeInfo (int uId, String email, String password, String fname, String lname) {
	dao.updateEmployeeInfo(uId, email, password, fname, lname);
}
	
}
