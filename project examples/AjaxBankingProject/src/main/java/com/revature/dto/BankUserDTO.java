package com.revature.dto;

import com.revature.model.BankUser;

public class BankUserDTO extends BankUser{
	
	private int baId;
	private double baBalance;
	
	public BankUserDTO() {}

	
	
	public BankUserDTO(int baId, double baBalance) {
		super();
		this.baId = baId;
		this.baBalance = baBalance;
	}

	public BankUserDTO(int id, String username, String firstName, String lastName, int baId, double baBalance) {
		super(id, username, firstName, lastName, null);
		this.baId = baId;
		this.baBalance = baBalance;
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

	@Override
	public String toString() {
		return "BankUserDTO [baId=" + baId + ", baBalance=" + baBalance + ", getId()=" + getId() + ", getUsername()="
				+ getUsername() + ", getFirstName()=" + getFirstName() + ", getLastName()=" + getLastName()
				+ ", getPassword()=" + getPassword() + "]";
	}
	
	
	
}
