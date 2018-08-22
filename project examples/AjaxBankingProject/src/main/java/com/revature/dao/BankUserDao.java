package com.revature.dao;

import com.revature.model.BankAccount;
import com.revature.model.BankUser;

public interface BankUserDao {

	//Create
	
	//Read
	public BankUser getUserByUsername(BankUser user);
	public BankAccount getBankAccountByUserId(BankUser user);
	//Update
	
	//Delete
	
}
