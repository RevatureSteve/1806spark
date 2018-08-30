package com.revature.dao;

import java.util.List;

import com.revature.domain.Users;

public interface UsersDao {
	
	//CREATE 
	
	
	//READ
	public Users getUserByEmail(String email);
	
	public List<Users> getAllUsers();
	
	//UPDATE
	
	public int updateUser(Users u);
	
	//DELETE

}
