package com.revature.dao;

import java.util.List;

import com.revature.pojo.BankAccount;
import com.revature.pojo.BankTransaction;
import com.revature.pojo.Users;

public interface BankDao {
	
	
	//Create
	
	
	//Read
	public Users getUsersByUsername(String username);
	public BankAccount getBankAccountInfo(int id);
	public List<BankTransaction> getBankTransactions(int accNum);
	
	//Update BankAccount and Insert BankTransaction
	public void depositToBankAccount(double amt, int accNum);
	public void withdrawFromBankAccount(double amt, int accNum);
	
}
