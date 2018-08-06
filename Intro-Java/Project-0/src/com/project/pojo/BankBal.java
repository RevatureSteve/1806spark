package com.project.pojo;

public class BankBal {

	public static BankBal currentAccount;
	private int accNum;
	private int bal;
	private int userId;
	
	public BankBal() {}

	public BankBal(int accNum, int bal, int userId) {
		super();
		this.accNum = accNum;
		this.bal = bal;
		this.userId = userId;
	}

	public static BankBal getCurrentAccount() {
		return currentAccount;
	}

	public static void setCurrentAccount(BankBal currentAccount) {
		BankBal.currentAccount = currentAccount;
	}

	public int getAccNum() {
		return accNum;
	}

	public void setAccNum(int accNum) {
		this.accNum = accNum;
	}

	public int getBal() {
		return bal;
	}

	public void setBal(int bal) {
		this.bal = bal;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "BankBal [accNum=" + accNum + ", bal=" + bal + ", userId=" + userId + "]";
	}
	
	
	
}
