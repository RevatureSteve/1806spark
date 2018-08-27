package com.revature.pojos;

public class Reimbursement {
	private int rId;
	private double amount;
	private String rDescription;
	private int rTypeId;
	private String rType;
	private String timeSubmitted;
	private int rStatusId;
	private String rStatus;
	private int empId;
	private String fName;
	private String lName;
	

	
	
	public Reimbursement(double amount, String rDescription, int rTypeId, int empId) {
		super();
		this.amount = amount;
		this.rDescription = rDescription;
		this.rTypeId = rTypeId;
		this.empId = empId;
	}


	public Reimbursement(int rId, double amount, String rDescription, String rType, String timeSubmitted, String rStatus,
			String f_name, String l_name) {
		super();
		this.rId = rId;
		this.amount = amount;
		this.rDescription = rDescription;
		this.rType= rType;
		this.timeSubmitted = timeSubmitted;
		this.rStatus = rStatus;
		this.fName = f_name;
		this.lName = l_name;
		
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


	public int getrTypeId() {
		return rTypeId;
	}


	public void setrTypeId(int rTypeId) {
		this.rTypeId = rTypeId;
	}


	public String getrType() {
		return rType;
	}


	public void setrType(String rType) {
		this.rType = rType;
	}


	public String getTimeSubmitted() {
		return timeSubmitted;
	}


	public void setTimeSubmitted(String timeSubmitted) {
		this.timeSubmitted = timeSubmitted;
	}


	public int getrStatusId() {
		return rStatusId;
	}


	public void setrStatusId(int rStatusId) {
		this.rStatusId = rStatusId;
	}


	public String getrStatus() {
		return rStatus;
	}


	public void setrStatus(String rStatus) {
		this.rStatus = rStatus;
	}


	public int getEmpId() {
		return empId;
	}


	public void setEmpId(int empId) {
		this.empId = empId;
	}


	public String getfName() {
		return fName;
	}


	public void setfName(String fName) {
		this.fName = fName;
	}


	public String getlName() {
		return lName;
	}


	public void setlName(String lName) {
		this.lName = lName;
	}


	@Override
	public String toString() {
		return "Reimbursement [amount=" + amount + ", rDescription=" + rDescription + ", rTypeId=" + rTypeId
				+ ", empId=" + empId + "]";
	}
	


	




	
	
	
	
	

	


	

	
	
	
}
