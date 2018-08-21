package com.revature.pojos;

public class Reimbursement {
	private int rId;
	private double amount;
	private String rDescription;
	private String timeSubmitted;
	private int empId;
	private int mangId;
	private int rTypeId;
	private int rStatusId;
	private String rStatus;
	private String f_name;
	private String l_name;
	
	
	public Reimbursement() {
	
	}
	
	

	public Reimbursement(int rId, double amount, String rDescription, String timeSubmitted, String rStatus,
			String f_name, String l_name) {
		super();
		this.rId = rId;
		this.amount = amount;
		this.rDescription = rDescription;
		this.timeSubmitted = timeSubmitted;
		this.rStatus = rStatus;
		this.f_name = f_name;
		this.l_name = l_name;
	}



	public Reimbursement(int rId, double amount, String rDescription, String timeSubmitted) {
		super();
		this.rId = rId;
		this.amount = amount;
		this.rDescription = rDescription;
		this.timeSubmitted = timeSubmitted;
	}

	public Reimbursement(int rId, int empId) {
		super();
		this.rId = rId;
		this.empId = empId;
	}
	
	public Reimbursement(int rId, String rDescription, int empId) {
		super();
		this.rId = rId;
		this.rDescription = rDescription;
		this.empId = empId;
	}
	

	public Reimbursement(int rId, double amount, String rDescription, String timeSubmitted, int empId, int mangId,
			int rTypeId, int rStatusId) {
		super();
		this.rId = rId;
		this.amount = amount;
		this.rDescription = rDescription;
		this.timeSubmitted = timeSubmitted;
		this.empId = empId;
		this.mangId = mangId;
		this.rTypeId = rTypeId;
		this.rStatusId = rStatusId;
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

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public int getMangId() {
		return mangId;
	}

	public void setMangId(int mangId) {
		this.mangId = mangId;
	}

	public int getrTypeId() {
		return rTypeId;
	}

	public void setrTypeId(int rTypeId) {
		this.rTypeId = rTypeId;
	}

	public int getrStatusId() {
		return rStatusId;
	}

	public void setrStatusId(int rStatusId) {
		this.rStatusId = rStatusId;
	}

	@Override
	public String toString() {
		return "Reimbursement [rId=" + rId + ", amount=" + amount + ", rDescription=" + rDescription
				+ ", timeSubmitted=" + timeSubmitted + ", empId=" + empId + ", mangId=" + mangId + ", rTypeId="
				+ rTypeId + ", rStatusId=" + rStatusId + "]";
	}


	

	
	
	
}
