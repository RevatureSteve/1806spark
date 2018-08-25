package com.revature.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="BANK_TX")
public class BankTxPojo  {
	
	@Id
	@Column(name="TX_ID")
	@SequenceGenerator(name="TX_ID_SEQ", sequenceName="TX_ID_SEQ")
	@GeneratedValue(generator="TX_ID_SEQ", strategy=GenerationType.SEQUENCE)
	private int tx_id;
	
	@Column(name="TX_TIMESTAMP")
	private String tx_timestamp;
	
	@Column(name="TX_AMT")
	private double tx_amt;
	
	@Column(name="TX_TYPE_ID")
	private int tx_type_id;
	
	@Column(name="ACCOUNT_NUMBER")
	private int account_number;

	//NOARGS
	
	public BankTxPojo() {}

	//Constructors
	public BankTxPojo(int tx_id, String tx_timestamp, double tx_amt, int tx_type_id, int account_number) {
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
		return "BankTx [tx_id=" + tx_id + ", tx_timestamp=" + tx_timestamp + ", tx_amt=" + tx_amt + ", tx_type_id="
				+ tx_type_id + ", account_number=" + account_number + "]";
	}
	
	

}
