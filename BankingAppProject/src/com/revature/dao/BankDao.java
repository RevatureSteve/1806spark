package com.revature.dao;

import com.revature.pojo.BankAccount;
import com.revature.pojo.Users;

public interface BankDao {
	
	
	//Create
	
	
	//Read
	public Users getUsersByUsername(String username);
	public BankAccount getBankAccountInfo(int id);
	
	//Update
	
	
	//Delete

}
