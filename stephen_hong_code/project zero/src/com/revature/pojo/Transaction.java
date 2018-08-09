package com.revature.pojo;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Transaction {
	
	//	state
	private int txId;
	private String txTime;
	private int txAmt;
	private String txType;
	private int acNum;
	
	//	no-args constructor
	public Transaction() {
		super();
	}
	//	eager loading from the db
	public Transaction(int txId, Date txTime, int txAmt, String txType, int acNum) {
		super();
		SimpleDateFormat sdf = new SimpleDateFormat ("yy.MM.dd hh:mm:ss a");
		this.txId = txId;
		this.txTime = sdf.format(txTime);
		this.txAmt = txAmt;
		this.txType = txType;
		this.acNum = acNum;
	}
	//	lazy loading from the db - only get this table's info
	public Transaction(int txAmt, String txType, int acNum) {
		this.txAmt = txAmt;
		this.txType = txType;
		this.acNum = acNum;
	}

	//	getters and setters
	public int getTxId() {
		return txId;
	}

	public void setTxId(int txId) {
		this.txId = txId;
	}
	
	public String getTxTime() {
		return txTime;
	}


	public void setTxTime(Date txTime) {
		SimpleDateFormat sdf = new SimpleDateFormat ("yy.MM.dd hh:mm:ss a");
		this.txTime = sdf.format(txTime);
	}

	public int getTxAmt() {
		return txAmt;
	}

	public void setTxAmt(int txAmt) {
		this.txAmt = txAmt;
	}

	public String getTxType() {
		return txType;
	}

	public void setTxType(String txType) {
		this.txType = txType;
	}

	public int getAcNum() {
		return acNum;
	}

	public void setAcNum(int acNum) {
		this.acNum = acNum;
	}

	//	toString
	@Override
	public String toString() {
		return txTime + " Transaction ID = " + txId + ", Account Number = " + acNum + "\r\n" + "Amount = \u20A9" + txAmt + ", Transaction Type = " + txType + "\r\n" + "==================================================================";
	}

}
