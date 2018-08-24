package com.revature.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BANK_TX_TYPE")
public class BankTxType {

	@Id
	@Column(name = "TX_TYPE_ID")
	private int txTypeId;

	@Column(name = "TX_TYPE")
	private String txType;
	
	public int getTxTypeId() {
		return txTypeId;
	}

	public void setTxTypeId(int txTypeId) {
		this.txTypeId = txTypeId;
	}

	public String getTxType() {
		return txType;
	}

	public void setTxType(String txType) {
		this.txType = txType;
	}

	public BankTxType(int txTypeId, String txType) {
		super();
		this.txTypeId = txTypeId;
		this.txType = txType;
	}
	
	public BankTxType() {}

	@Override
	public String toString() {
		return "BankTxType [txTypeId=" + txTypeId + ", txType=" + txType + "]";
	}

}
