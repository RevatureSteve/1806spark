package com.revature.dao;

import com.revature.domain.Position;
import com.revature.domain.User;

public interface UserDao {
	
	
	//Remember that DAO: Data Access Object (Only CRUD Methods)
	
	//Create
	 public int registerEmployee(User employee);	
	
	//Read
	 public User getUserByEmail(String email);
	 public String getUserPositionName(int userid);
	//Update
	
	//Delete
	
	
	
	
	
	

}
