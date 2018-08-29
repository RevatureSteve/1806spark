package com.revature.pojo;

import java.io.Serializable;

public class BankAccount implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//	state
	private int accNum;
	private Double balance;
	private int userId;
	
	private static BankAccount PresentAccount = null;
	
	//	no-args constructor
	public BankAccount() {
		super();
	}

	public BankAccount(int accNum, Double balance, int userId) {
		super();
		this.accNum = accNum;
		this.balance = balance;
		this.userId = userId;
	}

	//	getters and setters
	public int getAccountNum() {
		return accNum;
	}

	public void setAccountNum(int accNum) {
		this.accNum = accNum;
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

	//	tooString
	@Override
	public String toString() {
		return "[Available Balance = $" + balance + "]";
	}
	
	public static BankAccount getPresentAccount() {
		return PresentAccount;
	}

	public static void setCurrentAccount(BankAccount PresentAccount) {
		BankAccount.PresentAccount = PresentAccount;
	}

}