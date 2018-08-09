package com.revature.concreteClasses;

public class Transaction {
	
	private int tx_id;
	private String tx_timestamp;
	private int tx_type_id;
	private int tx_amount;
	private int accountNumber;
	
	
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Transaction(int tx_id, String tx_timestamp, int tx_type_id, int tx_amount, int accountNumber) {
		super();
		this.tx_id = tx_id;
		this.tx_timestamp = tx_timestamp;
		this.tx_type_id = tx_type_id;
		this.tx_amount = tx_amount;
		this.accountNumber = accountNumber;
	}
	
	public Transaction(String tx_timestamp,int tx_amount, int accountNumber, int tx_type_id) {
		super();
		this.tx_timestamp = tx_timestamp;
		this.tx_amount = tx_amount;
		this.accountNumber = accountNumber;
		this.tx_type_id = tx_type_id;
	}


	public int getTx_id() {
		return tx_id;
	}


	public void setTx_id(int tx_id) {
		this.tx_id = tx_id;
	}


	public String getTx_timestamp() {
		return tx_timestamp;
	}


	public void setTx_timestamp(String tx_timestamp) {
		this.tx_timestamp = tx_timestamp;
	}


	public int getTx_type_id() {
		return tx_type_id;
	}


	public void setTx_type_id(int tx_type_id) {
		this.tx_type_id = tx_type_id;
	}



	public int getTx_amount() {
		return tx_amount;
	}


	public void setTx_amount(int tx_amount) {
		this.tx_amount = tx_amount;
	}


	public int getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}


	@Override
	public String toString() {
		return "Transaction [tx_id=" + tx_id + ", tx_timestamp=" + tx_timestamp + ", tx_type_id=" + tx_type_id
				+ ", tx_amount=" + tx_amount + ", accountNumber=" + accountNumber + "]";
	}
	
	

}
