package com.revature.pojo;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class BankTransaction {

	private int transactionId;
	private String transactionTimeStamp;
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
		
		SimpleDateFormat ft = new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
		
		this.transactionId = transactionId;
		this.transactionTimeStamp = ft.format(transactionTimeStamp);
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


	public String getTransactionTimeStamp() {
		return transactionTimeStamp;
	}


	public void setTransactionTimeStamp(Date transactionTimeStamp) {
		SimpleDateFormat ft = new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
		this.transactionTimeStamp = ft.format(transactionTimeStamp);
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
		return "Transaction Id=" + transactionId + ", TimeStamp=" + transactionTimeStamp
				+ ", Amount=" + transactionAmt + ", Type=" + transactionType + ", Account Number="
				+ accountNumber ;
	}
	
	
	
	
}
