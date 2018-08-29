package com.revature.beans;

import java.util.List;

public class Account {
	
	private int usersId;
	private double balance;
	private List<Transactions> transactions;
	
	public Account() {
		super();
	}

	public Account(int usersId, double balance, List<Transactions> transactions) {
		super();
		this.usersId = usersId;
		this.balance = balance;
		this.transactions = transactions;
	}
	
	public Account(int usersId, double balance) {
		super();
		this.usersId = usersId;
		this.balance = balance;
	}

	public int getusersId() {
		return usersId;
	}

	public void setAccountId(int usersId) {
		this.usersId = usersId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public List<Transactions> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transactions> transactions) {
		this.transactions = transactions;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + usersId + ", balance=" + balance
				+ ", transactions=" + transactions + "]";
	}

	
	
	
	
	
	
	

	
	
	
}