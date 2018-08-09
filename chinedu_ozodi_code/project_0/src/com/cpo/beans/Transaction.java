package com.cpo.beans;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import com.cpo.exceptions.TransactionTypeNotFoundException;

public class Transaction implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int txId;
	private int txTypeId;
	private Timestamp time;
	private int accountNumber;
	private long txAmt;
	
	public Transaction() {
	}

	public Transaction(int txTypeId, Timestamp time, int accountNumber, long txAmt) {
		super();
		this.txTypeId = txTypeId;
		this.time = time;
		this.accountNumber = accountNumber;
		this.txAmt = txAmt;
	}

	public Transaction(int txId, int txTypeId, Timestamp time, int accountNumber, long txAmt) {
		super();
		this.txId = txId;
		this.txTypeId = txTypeId;
		this.time = time;
		this.accountNumber = accountNumber;
		this.txAmt = txAmt;
	}

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

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public long getTxAmt() {
		return txAmt;
	}

	public void setTxAmt(long txAmt) {
		this.txAmt = txAmt;
	}
	
	private String getType() {
		if (txTypeId == 1) {
			return "Deposit";
		}
		else if (txTypeId == 2) {
			return "Withdraw";
		}
		else {
			throw new TransactionTypeNotFoundException();
		}
	}
	
	private String getFormatedDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("E MM/dd/yyyy 'at' hh:mm a");
		return sdf.format(time);
	}

	@Override
	public String toString() {
		return "Transaction [txId=" + txId + ", txTypeId=" + txTypeId + ", time=" + time + ", accountNumber="
				+ accountNumber + ", txAmt=" + txAmt + "]";
	}
	
	public String prettyPrint() {
		return getFormatedDate() + " Account: " + accountNumber  + " Amount: " + getAmt() ;
	}
	
	private long getAmt() {
		if (txTypeId == 1) {
			return txAmt;
		}
		else if (txTypeId == 2) {
			return -txAmt;
		}
		else {
			throw new TransactionTypeNotFoundException();
		}
	}
	

}
