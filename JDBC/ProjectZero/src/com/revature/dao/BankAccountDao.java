package com.revature.dao;

import com.revature.pojo.BankAccount;

public interface BankAccountDao {
	
	//DAO: Data Access Object
	//	this DAO will be specifically for persistence of bank accounts
	
	//	CREATE: a method that will use an insert sql statement
//	public int createAccount(BankAccount ba);
//	public void createAccountProc(BankAccount ba);
	
	//	READ: a method that will use a select sql statement
//	public List<BankAccount> readAccount();
	public BankAccount getAccountById(int id);
	
	//	UPDATE: a method that will use a update sql statement
	public int updateAccount(BankAccount ba);
	
	//	DELETE: a method that will use a delete sql statement
	

}
