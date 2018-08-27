package com.revature.dao;

import java.util.ArrayList;

import com.revature.models.User;

public interface UserDAO {
	public User createUser(User user);
	
	public ArrayList<User> getAllUsers();
	
	public User getUserByUsername(String username);
	
	public User getUserByEmail(String email);
	
	public User getUserById(int id);
}