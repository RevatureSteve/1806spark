package com.revature.pojo;

import java.io.Serializable;

public class BankAccount implements Serializable {
	
	//	state
	private int acNum;
	private int balance;
	private int userId;
	
	private static BankAccount currentAccount = null;
	
	//	no-args constructor
	public BankAccount() {
		super();
	}

	public BankAccount(int acNum, int balance, int userId) {
		super();
		this.acNum = acNum;
		this.balance = balance;
		this.userId = userId;
	}

	//	getters and setters
	public int getAcNum() {
		return acNum;
	}

	public void setAcNum(int acNum) {
		this.acNum = acNum;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	//	toString
	@Override
	public String toString() {
		return "Account Number = " + acNum + ", User ID = " + userId + "\r\n" + "=====================================" + "\r\n" + "Your available balance is \u20A9" + balance + "\r\n" + "=====================================";
	}
	
	public static BankAccount getCurrentAccount() {
		return currentAccount;
	}

	public static void setCurrentAccount(BankAccount currentAccount) {
		BankAccount.currentAccount = currentAccount;
	}

}
