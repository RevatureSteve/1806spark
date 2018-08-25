package com.revature.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BANK_TX_TYPE")
public class BankTxTypePojo {
	
	@Id
	@Column(name="TX_TYPE_ID")
	private int txTypeId;
	
	@Column(name="TC_TYPE")
	private String txType;
	
	public BankTxTypePojo() {}

	public BankTxTypePojo(int txTypeId, String txType) {
		super();
		this.txTypeId = txTypeId;
		this.txType = txType;
	}

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

	@Override
	public String toString() {
		return "BankTxTypePojo [txTypeId=" + txTypeId + ", txType=" + txType + "]";
	}
	
	

}
