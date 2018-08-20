package com.revature.model;

public class BankAccount {

	private int baId;
	private int baBalance;
	private int baUserId;
	public BankAccount() {}
	
	public BankAccount(int baId, int baBalance, int baUsername) {
		super();
		this.baId = baId;
		this.baBalance = baBalance;
		this.baUserId = baUsername;
	}

	public int getBaId() {
		return baId;
	}

	public void setBaId(int baId) {
		this.baId = baId;
	}

	public int getBaBalance() {
		return baBalance;
	}

	public void setBaBalance(int baBalance) {
		this.baBalance = baBalance;
	}

	public int getBaUsername() {
		return baUserId;
	}

	public void setBaUsername(int baUsername) {
		this.baUserId = baUsername;
	}

	@Override
	public String toString() {
		return "BankAccount [Account Number=" + baId + ", baBalance=" + baBalance + ", baUserId=" + baUserId + "]";
	}
	
}
