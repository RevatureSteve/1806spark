package com.revature.dao;

import java.util.List;

import com.revature.domain.Users;


public interface UsersDao {
	
	//CREATE
	
	
		//READ
		public Users getUserByEmail(String username);
		public List<Users> getAllEmployees();
		
		public Users getViewEmployeeInfo(int id);
		
		//UPDATE
		
		public void updateEmployeeInfo (int uID, String email, String password, String fname, String lname);
		
		//DELETE
			

}
