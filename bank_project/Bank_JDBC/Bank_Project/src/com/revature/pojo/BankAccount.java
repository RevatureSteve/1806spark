package com.revature.pojo;

public class BankAccount {

	private int accountNumber;
	private Double balance;
	private int userId;
	
	private static BankAccount currentAccount = null;

	public BankAccount() {}

	
	public BankAccount(Double balance, int userId) {
		this.balance = balance;
		this.userId = userId;
	}
	
	
	public BankAccount(int accountNumber, Double balance, int userId) {
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.userId = userId;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public static BankAccount getCurrentAccount() {
		return currentAccount;
	}

	public static void setCurrentAccount(BankAccount currentAccount) {
		BankAccount.currentAccount = currentAccount;
	}

	@Override
	public String toString() {
		return "Account Number=" + accountNumber + ", Balance=" + balance ;
	}
	
	
	
	
}
