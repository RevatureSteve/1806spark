package com.revature.pojo;

/**
 * BankTx Class will be modeled after a table in the database. 
 * Each state will be represent a field in the database 
 * (pretty much a variable will be a column in the database)
 * 
 * 
 * @author Alex Moraga
 *
 */

public class BankTx {
	
	// States
	private int txId; // PRIMARY KEY 
	private int txTypeId; // foreign key from BankTxType
	private int accountNumber; // foreign key from Bank_Account
	private int txAmt;
	private String txTimestamp;
	
	// no-args constructor
	public BankTx() {
		super();
	}

	// constructor w/ parameters
	public BankTx(int txId, int txTypeId, int accountNumber, int txAmt, String txTimestamp) {
		super();
		this.txId = txId;
		this.txTypeId = txTypeId;
		this.accountNumber = accountNumber;
		this.txAmt = txAmt;
		this.txTimestamp = txTimestamp;
	}

	// setter & getters
	public int getTxId() {
		return txId;
	}

	public void setTxId(int txId) {
		this.txId = txId;
	}

	public int getTxTypeId() {
		return txTypeId;
	}

	public void setTxTypeId(int txTypeId) {
		this.txTypeId = txTypeId;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getTxAmt() {
		return txAmt;
	}

	public void setTxAmt(int txAmt) {
		this.txAmt = txAmt;
	}

	public String getTxTimestamp() {
		return txTimestamp;
	}

	public void setTxTimestamp(String txTimestamp) {
		this.txTimestamp = txTimestamp;
	}

	// Overriding the two string method
	@Override
	public String toString() {
		return "BankTx [txId=" + txId + ", txTypeId=" + txTypeId + ", accountNumber=" + accountNumber + ", txAmt="
				+ txAmt + ", txTimestamp=" + txTimestamp + "]";
	}
}
