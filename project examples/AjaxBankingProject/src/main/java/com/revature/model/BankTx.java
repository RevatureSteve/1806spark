package com.revature.model;

public class BankTx {

	private String txType;
	private double txAmount;
	
	
	public BankTx() {}


	public BankTx(String txType, double txAmount) {
		super();
		this.txType = txType;
		this.txAmount = txAmount;
	}


	public String getTxType() {
		return txType;
	}


	public void setTxType(String txType) {
		this.txType = txType;
	}


	public double getTxAmount() {
		return txAmount;
	}


	public void setTxAmount(double txAmount) {
		this.txAmount = txAmount;
	}


	@Override
	public String toString() {
		return "BankTx [txType=" + txType + ", txAmount=" + txAmount + "]";
	}


	
	
	
}
