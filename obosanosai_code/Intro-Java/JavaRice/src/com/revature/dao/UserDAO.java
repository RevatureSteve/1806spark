package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.User;

//CRUD - create, retrieve, update delete
public interface UserDAO {
	
	//Create a new user
	public abstract void addUser(String fname, String lname, String username, String password) throws SQLException;
	
	//retrieve an individual with their username
	public abstract User getUser(String username) throws SQLException;
	
	//retrieve a list of users
	public abstract List<User> getUsers() throws SQLException;
	
	//retrieve user_id from username 
	public abstract int getUsersId(String username) throws SQLException;
	
	//retrieve status from username
	//public abstract int getStatus(String username) throws SQLException;

	//update a user's info
	public abstract void updateUsers(String username) throws SQLException;
	
	//delete a user with their username
	public abstract void deleteUsers(String username) throws SQLException;
	
	
}
