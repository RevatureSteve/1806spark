package com.revature.pojo;

public class BankTxType {
	
	//states
	private int txTypeId;
	private String txtype;
	
	//constructor using fields
	public BankTxType(int txTypeId, String txtype) {
		super();
		this.txTypeId = txTypeId;
		this.txtype = txtype;
	}
	
	//NO-ARGS constructor
	public BankTxType() {}

	//getters n' setters
	public int getTxTypeId() {
		return txTypeId;
	}

	public void setTxTypeId(int txTypeId) {
		this.txTypeId = txTypeId;
	}

	public String getTxtype() {
		return txtype;
	}

	public void setTxtype(String txtype) {
		this.txtype = txtype;
	}

	//toString()
	@Override
	public String toString() {
		return "BankTxType [txTypeId=" + txTypeId + ", txtype=" + txtype + "]";
	}
}
