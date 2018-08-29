package com.revature.pojo;

public class Transaction {
	
	//	state
	private int txId;
	private Double txAmt;
	private String txType;
	private int accNum;
	
	//	no-args 
	public Transaction() {
		super();
	}
    // constructor with parameters
	public Transaction(int txId, Double txAmt, String txType, int accNum) {
		super();
		this.txId = txId;
		this.txAmt = txAmt;
		this.txType = txType;
		this.accNum = accNum;
	}
	
	public Transaction(Double txAmt, String txType, int accNum) {
		this.txAmt = txAmt;
		this.txType = txType;
		this.accNum = accNum;
	}

	//	getters and setters
	public int getTxId() {
		return txId;
	}

	public void setTxId(int txId) {
		this.txId = txId;
	}

	public Double getTxAmt() {
		return txAmt;
	}

	public void setTxAmt(Double txAmt) {
		this.txAmt = txAmt;
	}

	public String getTxType() {
		return txType;
	}

	public void setTxType(String txType) {
		this.txType = txType;
	}

	public int getAccountNum() {
		return accNum;
	}

	public void setAcNum(int accNum) {
		this.accNum = accNum;
	}

	//	toString
	@Override
	public String toString() {
		return "[Transaction Type = " + txType + ", Account Number = " + accNum + "]";
	}

}
