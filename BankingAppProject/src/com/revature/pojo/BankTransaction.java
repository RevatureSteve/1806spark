package com.revature.pojo;

import java.io.Serializable;

public class BankTransaction implements Serializable{
	
	private int tx_id;
	private String time_stamp;
	private int tx_amount;
	private int tx_type_id;
	private int bank_account_number;
	
	
	public BankTransaction(int tx_id, String time_stamp, int tx_amount, int tx_type_id, int bank_account_number) {
		super();
		this.tx_id = tx_id;
		this.time_stamp = time_stamp;
		this.tx_amount = tx_amount;
		this.tx_type_id = tx_type_id;
		this.bank_account_number = bank_account_number;
	}

	public int getTx_id() {
		return tx_id;
	}
	
	public String getTime_stamp() {
		return time_stamp;
	}
	
	public int getTx_amount() {
		return tx_amount;
	}
	
	public int getTx_type_id() {
		return tx_type_id;
	}
	
	public int getBank_account_number() {
		return bank_account_number;
	}
	
	
	
	
}
