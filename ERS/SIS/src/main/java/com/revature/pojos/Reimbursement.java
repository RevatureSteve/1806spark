package com.revature.pojos;

public class Reimbursement {
	private int rId;
	private double amount;
	private String rDescription;
	private String rType;
	private String timeSubmitted;
	private String rStatus;
	private String f_name;
	private String l_name;
	
	
	public Reimbursement(int rId, double amount, String rDescription, String rType, String timeSubmitted, String rStatus,
			String f_name, String l_name) {
		super();
		this.rId = rId;
		this.amount = amount;
		this.rDescription = rDescription;
		this.rType= rType;
		this.timeSubmitted = timeSubmitted;
		this.rStatus = rStatus;
		this.f_name = f_name;
		this.l_name = l_name;
		
	}


	public int getrId() {
		return rId;
	}


	public void setrId(int rId) {
		this.rId = rId;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public String getrDescription() {
		return rDescription;
	}


	public void setrDescription(String rDescription) {
		this.rDescription = rDescription;
	}


	public String getTimeSubmitted() {
		return timeSubmitted;
	}


	public void setTimeSubmitted(String timeSubmitted) {
		this.timeSubmitted = timeSubmitted;
	}


	public String getrStatus() {
		return rStatus;
	}


	public void setrStatus(String rStatus) {
		this.rStatus = rStatus;
	}


	public String getF_name() {
		return f_name;
	}


	public void setF_name(String f_name) {
		this.f_name = f_name;
	}


	public String getL_name() {
		return l_name;
	}


	public void setL_name(String l_name) {
		this.l_name = l_name;
	}


	public String getrType() {
		return rType;
	}


	public void setrType(String rType) {
		this.rType = rType;
	}


	@Override
	public String toString() {
		return "Reimbursement [rId=" + rId + ", amount=" + amount + ", rDescription=" + rDescription + ", rType="
				+ rType + ", timeSubmitted=" + timeSubmitted + ", rStatus=" + rStatus + ", f_name=" + f_name
				+ ", l_name=" + l_name + "]";
	}




	
	
	
	
	

	


	

	
	
	
}
