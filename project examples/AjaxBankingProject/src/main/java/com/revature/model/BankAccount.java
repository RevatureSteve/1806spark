package com.revature.model;

public class BankAccount {

	private int baId;
	private double baBalance;
	private int baUserId;
	public BankAccount() {}
	
	public BankAccount(int baId, double baBalance, int baUsername) {
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

	public double getBaBalance() {
		return baBalance;
	}

	public void setBaBalance(double baBalance) {
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
		return "BankAccount [baId=" + baId + ", baBalance=" + baBalance + ", baUsername=" + baUserId + "]";
	}
	
}
