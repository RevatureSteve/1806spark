package com.revature.pojo;

import java.io.Serializable;
import java.sql.Date;

public class Transation implements Serializable{
	
	private int transID;
	private Date timestamp;
	private double amount;
	private int transTypeId;
	private int accountNumber;
	
	
	
	public Transation() {
		super();
	}



	public Transation(int transID, Date timestamp, double amount, int transTypeId, int accountNumber) {
		super();
		this.transID = transID;
		this.timestamp = timestamp;
		this.amount = amount;
		this.transTypeId = transTypeId;
		this.accountNumber = accountNumber;
	}



	public int getTransID() {
		return transID;
	}



	public void setTransID(int transID) {
		this.transID = transID;
	}



	public Date getTimestamp() {
		return timestamp;
	}



	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}



	public double getAmount() {
		return amount;
	}



	public void setAmount(double amount) {
		this.amount = amount;
	}



	public int getTransTypeId() {
		return transTypeId;
	}



	public void setTransTypeId(int transTypeId) {
		this.transTypeId = transTypeId;
	}



	public int getAccountNumber() {
		return accountNumber;
	}



	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}



	@Override
	public String toString() {
		return "Transation [transID=" + transID + ", timestamp=" + timestamp + ", amount=" + amount + ", transTypeId="
				+ transTypeId + ", accountNumber=" + accountNumber + "]";
	}
	
	

}
