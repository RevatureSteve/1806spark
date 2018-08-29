package com.revature.beans;
import java.sql.Date;

public class Transactions {

	private int transactionId;
	private int accountId;
	private Date timestamp;
	private String amount;
	private String TransactionTypeId;

	
	public Transactions() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Transactions(int transactionId, int accountId, Date timestamp, String amount, String transactionTypeId) {
		super();
		this.transactionId = transactionId;
		this.accountId = accountId;
		this.timestamp = timestamp;
		this.amount = amount;
		TransactionTypeId = transactionTypeId;
	}


	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getTransactionTypeId() {
		return TransactionTypeId;
	}

	public void setTransactionTypeId(String transactionTypeId) {
		TransactionTypeId = transactionTypeId;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	

	public int getAccountId() {
		return accountId;
	}


	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	@Override
	public String toString() {
		return "Transactions [transactionId=" + transactionId + ", accountId=" + accountId + ", timestamp=" + timestamp
				+ ", amount=" + amount + ", TransactionTypeId=" + TransactionTypeId + "]";
	}

	
}
