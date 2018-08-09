package com.revature.dao;

import java.util.List;

import com.revature.pojo.User;

public interface BankingAppDao {
	
//Create
	public int createUser (User person);
	
//READ - SELECT to retrieve records/statement
	public List<User> getAllUser();
	public User getUsersById(int id);
	public User getUserByUsername(String username);
	
//UPDATE
	public int deposit(int amount, User a);
	
	public int withdraw(int amount2, User a);
	
	public int balance(User a);
	

}
