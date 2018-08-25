package com.revature.bank.pojo;

import java.io.Serializable;

/**
 * ORM- State/variables aligned with Bank_Tx table
 * @author tyler
 *
 */

public class Bank_txPojo implements Serializable {
	
	private int tx_id;
	private String tx_timestamp;
	private double tx_amt;
	private int tx_type_id;
	private int account_number;

	//NOARGS
	
	public Bank_txPojo() {}

	//Constructors
	public Bank_txPojo(int tx_id, String tx_timestamp, double tx_amt, int tx_type_id, int account_number) {
		super();
		this.tx_id = tx_id;
		this.tx_timestamp = tx_timestamp;
		this.tx_amt = tx_amt;
		this.tx_type_id = tx_type_id;
		this.account_number = account_number;
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

	public double getTx_amt() {
		return tx_amt;
	}

	public void setTx_amt(double tx_amt) {
		this.tx_amt = tx_amt;
	}

	public int getTx_type_id() {
		return tx_type_id;
	}

	public void setTx_type_id(int tx_type_id) {
		this.tx_type_id = tx_type_id;
	}

	public int getAccount_number() {
		return account_number;
	}

	public void setAccount_number(int account_number) {
		this.account_number = account_number;
	}

	@Override
	public String toString() {
		return "Bank_txPojo [tx_id=" + tx_id + ", tx_timestamp=" + tx_timestamp + ", tx_amt=" + tx_amt + ", tx_type_id="
				+ tx_type_id + ", account_number=" + account_number + "]";
	}
	
	

}
