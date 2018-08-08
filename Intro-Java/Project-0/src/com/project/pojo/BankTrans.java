package com.project.pojo;

import java.text.SimpleDateFormat;

public class BankTrans {
	
	private int transId;
	private String transTimeStamp;
	private int TransAmount;
	private String transType;
	private int accountNum;
	
	public BankTrans() {}

	public BankTrans(int transId, String transTimeStamp, int transAmount, int accountNum) {
		super();
		this.transId = transId;
		this.transTimeStamp = transTimeStamp;
		TransAmount = transAmount;
		this.accountNum = accountNum;
	}

	public int getTransId() {
		return transId;
	}

	public void setTransId(int transId) {
		this.transId = transId;
	}

	public String getTransTimeStamp() {
		return transTimeStamp;
	}

	public void setTransTimeStamp(String transTimeStamp) {
		SimpleDateFormat date = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
		this.transTimeStamp = date.format(transTimeStamp);
	}

	public int getTransAmount() {
		return TransAmount;
	}

	public void setTransAmount(int transAmount) {
		TransAmount = transAmount;
	}

	public String getTransType() {
		return transType;
	}

	public void setTransType(String transType) {
		this.transType = transType;
	}

	public int getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(int accountNum) {
		this.accountNum = accountNum;
	}

	@Override
	public String toString() {
		return "Transaction ID: " + transId + ", TimeStamp = " + transTimeStamp + ", TransAmount = " + TransAmount
				+ ", Account Number = " + accountNum + " \n ";
	}
	
	

}
