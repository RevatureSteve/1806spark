
package com.revature.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "BANK_TX")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Cacheable
public class BankTx implements Serializable {

	@Id

	@Column(name = "TX_ID")
	private int TxId;
	@Column(name = "TX_TYPE_ID")
	private int TxTypeId;
	@Column(name = "TX_TIMESTAMP")
	private Timestamp timestamp;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "ACCOUNT_NUMBER")
	private BankAccount AcctNum;
	@Column(name = "TX_AMT")
	private int TxAmt;

	public int getTxId() {
		return TxId;
	}

	public void setTxId(int txId) {
		TxId = txId;
	}

	public int getTxTypeId() {
		return TxTypeId;
	}

	public void setTxTypeId(int txTypeId) {
		TxTypeId = txTypeId;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public BankAccount getAcctNum() {
		return AcctNum;
	}

	public void setAcctNum(BankAccount acctNum) {
		AcctNum = acctNum;
	}

	public int getTxAmt() {
		return TxAmt;
	}

	public void setTxAmt(int txAmt) {
		TxAmt = txAmt;
	}

	@Override
	public String toString() {
		return "BankTx [TxId=" + TxId + ", TxTypeId=" + TxTypeId + ", timestamp=" + timestamp + ", AcctNum=" + AcctNum
				+ ", TxAmt=" + TxAmt + "]";
	}

}
