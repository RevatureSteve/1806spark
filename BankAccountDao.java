package com.revature.dao;

import java.util.List;

import com.revature.pojo.BankAccount;

public interface BankAccountDao {
	
	//Create a new account
	//public abstract void addAccount(String username, double initAmount) throws SQLException;
	
	//	CREATE: insert
	public int createAccount(BankAccount bacc);
	
	public void createAccountProc(BankAccount bacc);
	
	//get the user_id from the Usertable to add to the account table
	//public abstract int getUsersId(String username);
	
	//	READ: select 
	public List<BankAccount> readAccount();
	
	public BankAccount getAccountById(int id);
	
	//getting account_id from user_id 
	
	//	public abstract int getAccountId(int userId) throws SQLException;
	
	//	UPDATE:update
	public int updateAccount(BankAccount bacc);
	 
	//update a account balance from username and accountid
	
	//public abstract void updateBal(String username, double amount, int usersId) throws SQLException;
	
	//	DELETE: delete
	public abstract void deleteAccount(String username , int usersId);

}