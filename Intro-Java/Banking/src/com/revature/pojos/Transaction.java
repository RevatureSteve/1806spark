package com.revature.pojos;

public class Transaction {
	int tx_id;
	String timestamp;
	double tx_amount;
	String tx_type;
	int account_number;
	public Transaction(int tx_id, String timestamp, double tx_amount, String tx_type, int account_number) {
		super();
		this.tx_id = tx_id;
		this.timestamp = timestamp;
		this.tx_amount = tx_amount;
		this.tx_type = tx_type;
		this.account_number = account_number;
	}
	public int getTx_id() {
		return tx_id;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public double getTx_amount() {
		return tx_amount;
	}
	public String getTx_type() {
		return tx_type;
	}
	public int getAccount_number() {
		return account_number;
	}
	@Override
	public String toString() {
		return "Transaction [tx_id=" + tx_id + ", timestamp=" + timestamp + ", tx_amount=" + tx_amount + ", tx_type="
				+ tx_type + ", account_number=" + account_number + "]";
	}
	
}
