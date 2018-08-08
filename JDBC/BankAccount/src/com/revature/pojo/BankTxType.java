package com.revature.pojo;

/**
 * BankTxType Class will be modeled after a table in the database. 
 * Each state will be represent a field in the database 
 * (pretty much a variable will be a column in the database)
 * 
 * 
 * @author Alex Moraga
 *
 */

public class BankTxType {
	
	private int TxTypeId; // Primary Key
	private String TxType;
	
	// no-args constructors
	public BankTxType() {
		super();
		// TODO Auto-generated constructor stub
	}

	// constructors w/ parameters
	public BankTxType(int txTypeId, String txType) {
		super();
		TxTypeId = txTypeId;
		TxType = txType;
	}

	// setters & getters
	public int getTxTypeId() {
		return TxTypeId;
	}

	public void setTxTypeId(int txTypeId) {
		TxTypeId = txTypeId;
	}

	public String getTxType() {
		return TxType;
	}

	public void setTxType(String txType) {
		TxType = txType;
	}

	@Override
	public String toString() {
		return "BankTxType [TxTypeId=" + TxTypeId + ", TxType=" + TxType + "]";
	}
}
