package com.revature.dao;

import java.util.List;

import com.revature.pojo.User;

public interface UserDao {

	//DAO: Data Access Object
	//	this DAO will be specifically for persistence of users
	
	//	CREATE: a method that will use an insert sql statement
	public int createUser(User u);
	public void createUserProc(User u);
	
	//	READ: a method that will use a select sql statement
	public List<User> readUser();
	public User getUserById(int id);
	
	//	UPDATE: a method that will use a update sql statement
	public int updateUser(User u);
	List<User> readUser(String URL, String USERNAME, String PASSWORD);
	
	//	DELETE: a method that will use a delete sql statement
	
}
