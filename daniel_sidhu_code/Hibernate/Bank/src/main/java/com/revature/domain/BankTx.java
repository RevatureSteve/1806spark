package com.revature.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="BANK_TX")
public class BankTx {

	@Id //PK
	@Column(name="TX_ID")
	private int tx_Id;
	
	@Column(name="TX_AMT")
	private int tx_Amt;
	
	@Column(name="TX_TIMESTAMP")
	private int tx_Timestamp;
	
	/*
	 * first annotation: many bank transactions to one transaction type 
	 * second annotation: join the bank transaction and transaction type by their TX_TYPE_ID
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TX_TYPE_ID")
	private BankTxType txTypeId;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ACCOUNT_NUMBER")
	private  BankAccount accountNumber;

	public BankTx() {
		super();
	}

	public BankTx(int tx_Id, int tx_Amt, int tx_Timestamp, BankTxType txTypeId, BankAccount accountNumber) {
		super();
		this.tx_Id = tx_Id;
		this.tx_Amt = tx_Amt;
		this.tx_Timestamp = tx_Timestamp;
		this.txTypeId = txTypeId;
		this.accountNumber = accountNumber;
	}

	public int getTx_Id() {
		return tx_Id;
	}

	public void setTx_Id(int tx_Id) {
		this.tx_Id = tx_Id;
	}

	public int getTx_Amt() {
		return tx_Amt;
	}

	public void setTx_Amt(int tx_Amt) {
		this.tx_Amt = tx_Amt;
	}

	public int getTx_Timestamp() {
		return tx_Timestamp;
	}

	public void setTx_Timestamp(int tx_Timestamp) {
		this.tx_Timestamp = tx_Timestamp;
	}

	public BankTxType getTxTypeId() {
		return txTypeId;
	}

	public void setTxTypeId(BankTxType txTypeId) {
		this.txTypeId = txTypeId;
	}

	public BankAccount getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(BankAccount accountNumber) {
		this.accountNumber = accountNumber;
	}

	@Override
	public String toString() {
		return "BankTx [tx_Id=" + tx_Id + ", tx_Amt=" + tx_Amt + ", tx_Timestamp=" + tx_Timestamp + ", txTypeId="
				+ txTypeId + ", accountNumber=" + accountNumber + "]";
	}
	
}
