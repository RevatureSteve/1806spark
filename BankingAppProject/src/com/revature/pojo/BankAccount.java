package com.revature.pojo;

public class BankAccount {

	
	private int account_number;
	private Double balance;
	private int users_id;

	
	public BankAccount() {
		
	}

	public BankAccount(int account_number, Double balance, int users_id) {
		super();
		this.account_number = account_number;
		this.balance = balance;
		this.users_id = users_id;
	}

	public int getAccount_number() {
		return account_number;
	}

	public void setAccount_number(int account_number) {
		this.account_number = account_number;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public int getUsers_id() {
		return users_id;
	}

	public void setUsers_id(int users_id) {
		this.users_id = users_id;
	}

	@Override
	public String toString() {
		return "BankAccount [account_number=" + account_number + ", balance=" + balance + ", users_id=" + users_id
				+ "]";
	}
	
	
	
}
