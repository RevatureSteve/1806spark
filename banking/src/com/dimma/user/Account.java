package com.dimma.user;

public class Account {

	private int account_number;
	private int balance;
	private int users_id;
	
	
	public static Account acc;
	
	public static Account getAccount(int account_number,int balance,int users_id) {
		if (acc == null) {
			acc = new Account(account_number,balance,users_id);
		}return acc;
	}
	public static void depositAcc(int balance) {
		acc.balance += balance;
	}
	public static boolean withdrawAcc(int withdraw) {
		if(acc.balance >= withdraw) {
		acc.balance -= withdraw;
		return true;
		}else {
	return false;
		}
	}


	public Account() {
		super();
	}

	public Account(int account_number, int balance, int users_id) {
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

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
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
		return "Account [account_number=" + account_number + ", balance=" + balance + ", users_id=" + users_id + "]";
	}

}
