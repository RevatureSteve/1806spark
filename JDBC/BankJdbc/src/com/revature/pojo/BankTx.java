package com.revature.pojo;

public class BankTx {
	
	//states
	private int txId;
	private double txAmt;
	private String txTimestamp;
	private int txTypeId;
	private int accountNumber;
	
	//constructors using field
	public BankTx(int txId, double txAmt, String txTimestamp, int txTypeId, int accountNumber) {
		super();
		this.txId = txId;
		this.txAmt = txAmt;
		this.txTimestamp = txTimestamp;
		this.txTypeId = txTypeId;
		this.accountNumber = accountNumber;
	}
	
	//NO-ARGS constructor
	public BankTx() {}

	//getters n' setters
	public int getTxId() {
		return txId;
	}

	public void setTxId(int txId) {
		this.txId = txId;
	}

	public double getTxAmt() {
		return txAmt;
	}

	public void setTxAmt(double txAmt) {
		this.txAmt = txAmt;
	}

	public String getTxTimestamp() {
		return txTimestamp;
	}

	public void setTxTimestamp(String txTimestamp) {
		this.txTimestamp = txTimestamp;
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

	//toString()
	@Override
	public String toString() {
		return "BankTx [txId=" + txId + ", txAmt=" + txAmt + ", txTimestamp=" + txTimestamp + ", txTypeId=" + txTypeId
				+ ", accountNumber=" + accountNumber + "]";
	}
}
