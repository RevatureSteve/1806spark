package com.revature.dao;

import com.revature.domain.BankUser;

public interface BankDao {

	// CREATE
	
	// READ
	/*
	 * here I get the bank user by Id
	 */
	public BankUser getBankUser(int userId);
}
