package com.revature.dao;

import com.revature.exceptions.userNotFound;
import com.revature.pojo.Bank_Account;
import com.revature.pojo.Users;

public interface BankDao {

	// CREATE
	public int createUser(Users ui);
	
	// READ
	public Users getUserByUsername(String username) throws userNotFound;
	
	public Bank_Account getBalance(Users ui); //try using users_id instead of ui
	
	// UPDATE
	public int depositing(Users ui, int balance);
	
	public int withdrawing(Users ui, int balance);
	// DELETE
}
