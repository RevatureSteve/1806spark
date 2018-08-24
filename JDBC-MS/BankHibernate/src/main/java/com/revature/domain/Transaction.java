package com.revature.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="BANK_TX")
public class Transaction {

	@Id
	@Column(name="TX_ID")
	private int txId;
	
	@Column(name="TX_TIMESTAMP")
	private Timestamp timestamp;
	
	@Column(name="TX_AMT")
	private double amount;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="TX_TYPE_ID")
	private BankTxType btt;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ACCOUNT_NUMBER")
	private BankAccount bankaccount;
	
	public BankTxType getBtt() {
		return btt;
	}

	public void setBtt(BankTxType btt) {
		this.btt = btt;
	}

	public int getTxId() {
		return txId;
	}

	public void setTxId(int txId) {
		this.txId = txId;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	
	public Transaction(int txId, Timestamp timestamp, double amount, int typeId, int accountNumber) {
		super();
		this.txId = txId;
		this.timestamp = timestamp;
		this.amount = amount;
	
	}
	
	public Transaction() {}

	@Override
	public String toString() {
		return "Transaction [txId=" + txId + ", timestamp=" + timestamp + ", amount=" + amount + ", btt=" + btt
				 + "]";
	}

}
