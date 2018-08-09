package com.revature.pojo;

import java.io.Serializable;

public class BankAccount implements Serializable {
	
	private int accountNumber;
	private double balance;
	private int userId;
	
	
	
	public BankAccount() {
		super();
	}



	public BankAccount(int accountNumber, double balance, int userId) {
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



	public double getBalance() {
		return balance;
	}



	public void setBalance(double balance) {
		this.balance = balance;
	}



	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}



	@Override
	public String toString() {
		return "BankAccount [accountNumber=" + accountNumber + ", balance=" + balance + ", userId=" + userId + "]";
	}
	
	

}
