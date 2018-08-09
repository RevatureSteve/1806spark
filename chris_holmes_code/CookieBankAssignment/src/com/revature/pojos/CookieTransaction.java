package com.revature.pojos;

import java.sql.Date;

public class CookieTransaction { //Creating a new transaction obje
	
	private int cTransId;//transaction id variable
	private Date cTransTimeStamp;//transaction time stamp
	private Double CTransAmt;//transaction amount
	private String cTransType;// transaction type
	private int cTransAccountNum;//account number for transaction
	
	public CookieTransaction() {}//no args const

	public CookieTransaction(int cTransId, Date cTransTimeStamp, Double cTransAmt, String cTransType,
			int cTransAccountNum) { //instantiating a transaction object
		super();
		this.cTransId = cTransId; 
		this.cTransTimeStamp = cTransTimeStamp;
		CTransAmt = cTransAmt;
		this.cTransType = cTransType;
		this.cTransAccountNum = cTransAccountNum;
	}

	public int getcTransId() {
		return cTransId;
	}

	public void setcTransId(int cTransId) {
		this.cTransId = cTransId;
	}

	public Date getcTransTimeStamp() {
		return cTransTimeStamp;
	}

	public void setcTransTimeStamp(Date cTransTimeStamp) {
		this.cTransTimeStamp = cTransTimeStamp;
	}

	public Double getCTransAmt() {
		return CTransAmt;
	}

	public void setCTransAmt(Double cTransAmt) {
		CTransAmt = cTransAmt;
	}

	public String getcTransType() {
		return cTransType;
	}

	public void setcTransType(String cTransType) {
		this.cTransType = cTransType;
	}

	public int getcTransAccountNum() {
		return cTransAccountNum;
	}

	public void setcTransAccountNum(int cTransAccountNum) {
		this.cTransAccountNum = cTransAccountNum;
	}

	@Override
	public String toString() {
		return "CookieTransaction [cTransId=" + cTransId + ", cTransTimeStamp=" + cTransTimeStamp + ", CTransAmt="
				+ CTransAmt + ", cTransType=" + cTransType + ", cTransAccountNum=" + cTransAccountNum + "]";
	}
	
	
	
	
	
	
	

}
