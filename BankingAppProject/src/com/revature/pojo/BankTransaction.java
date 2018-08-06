package com.revature.pojo;

import java.io.Serializable;

public class BankTransaction implements Serializable{
	
	private int tx_id;
	private String time_stamp;
	private double tx_amount;
	private int tx_type_id;
	private int bank_account_number;
	private String tx_type;
	
	
	public BankTransaction(String time_stamp, double tx_amount,  String tx_type, int bank_account_number) {
		super();
		this.time_stamp = time_stamp;
		this.tx_amount = tx_amount;
		this.tx_type = tx_type;
		this.bank_account_number = bank_account_number;
	}
	
	

	public int getTx_id() {
		return tx_id;
	}
	
	public String getTime_stamp() {
		return time_stamp;
	}
	
	public double getTx_amount() {
		return tx_amount;
	}
	
	public int getTx_type_id() {
		return tx_type_id;
	}
	
	public int getBank_account_number() {
		return bank_account_number;
	}

	public String getTx_type() {
		return tx_type;
	}



	@Override
	public String toString() {
		return "Transaction Time: " + time_stamp + " | Transaction Amount: $" + tx_amount +  " | Transaction Type: " + tx_type + " | Account Number: "
				+ bank_account_number  + "\n";
	}


	
}
