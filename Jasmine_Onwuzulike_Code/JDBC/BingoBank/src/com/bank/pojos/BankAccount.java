package com.bank.pojos;

public class BankAccount {
 final int acct_number;
 final int user_id;
 final int balance;



public BankAccount(int acct_number, int user_id, int balance) {
	this.acct_number = acct_number;
	this.user_id = user_id;
	this.balance = balance;
}

public int getAcct_number() {
	return acct_number;
}

public int getUser_id() {
	return user_id;
}

public int getBalance() {
	return balance;
}



}
