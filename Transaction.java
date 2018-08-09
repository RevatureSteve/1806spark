package com.revature.pojo;

public class Transaction {

	//	state
	private int txId;
	private int acctNum;
	private Double txAmt;
	private String txType;

	
	//	no-args constructor
	public Transaction() {
		super();
	}

	public Transaction(int txId, Double txAmt, String txType, int acctNum) {
		super();
		this.txId = txId;
		this.txAmt = txAmt;
		this.txType = txType;
		this.acctNum = acctNum;
	}
	
	public Transaction(Double txAmt, String txType, int acctNum) {
		this.txAmt = txAmt;
		this.txType = txType;
		this.acctNum = acctNum;
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

	public int getacctNum() {
		return acctNum;
	}

	public void setacctNum(int acctNum) {
		this.acctNum = acctNum;
	}

	//	toString
	@Override
	public String toString() {
		return "Transaction [Transaction ID = " + txId + ", Amount = $" + txAmt + ", Transaction Type = " + txType + ", Account Number = " + acctNum + "]";
	}

}
