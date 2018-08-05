package com.revature.pojo;

import java.sql.Date;

public class BankTransaction {

	private int transactionId;
	private Date transactionTimeStamp;
	private Double transactionAmt;
	private String transactionType;
	private int accountNumber;
	
	
	public BankTransaction() {}

	public BankTransaction(Double transactionAmt, String transactionType, int accountNumber) {
		this.transactionAmt = transactionAmt;
		this.transactionType = transactionType;
		this.accountNumber = accountNumber;
	}

	public BankTransaction(int transactionId, Date transactionTimeStamp, Double transactionAmt, String transactionType,
			int accountNumber) {
		super();
		this.transactionId = transactionId;
		this.transactionTimeStamp = transactionTimeStamp;
		this.transactionAmt = transactionAmt;
		this.transactionType = transactionType;
		this.accountNumber = accountNumber;
	}


	public int getTransactionId() {
		return transactionId;
	}


	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}


	public Date getTransactionTimeStamp() {
		return transactionTimeStamp;
	}


	public void setTransactionTimeStamp(Date transactionTimeStamp) {
		this.transactionTimeStamp = transactionTimeStamp;
	}


	public Double getTransactionAmt() {
		return transactionAmt;
	}


	public void setTransactionAmt(Double transactionAmt) {
		this.transactionAmt = transactionAmt;
	}


	public String getTransactionType() {
		return transactionType;
	}


	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}


	public int getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}


	@Override
	public String toString() {
		return "BankTransaction [transactionId=" + transactionId + ", transactionTimeStamp=" + transactionTimeStamp
				+ ", transactionAmt=" + transactionAmt + ", transactionType=" + transactionType + ", accountNumber="
				+ accountNumber + "]";
	}
	
	
	
	
}
