package com.revature.dao;

import java.util.ArrayList;

import com.revature.exceptions.OverdraftPreventionException;
import com.revature.pojos.BankAccount;
import com.revature.pojos.Transaction;

public interface BankAccountDao {
	public ArrayList<BankAccount> getBankAccounts();

	public BankAccount getBankAccountByUserId(int user_id);
	public BankAccount getBankAccountByBankId(int account_number);
	public ArrayList<Transaction> getTransactionsByUser(int account_number);
	public void deposit(double money, int bankAccountId);
	public void withdraw(double moneyAmount, int bankAccountId) throws OverdraftPreventionException;
}
