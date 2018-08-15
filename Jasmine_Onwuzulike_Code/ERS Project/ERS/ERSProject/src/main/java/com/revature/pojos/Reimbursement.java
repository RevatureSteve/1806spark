package com.revature.pojos;

public class Reimbursement {
	
	private int rId;
	private double amt;
	private String rDescription;
	private String img;
	private String timeSubmitted;
	private int empUId;
	private int mangUId;
	private String rType;
	private String rStatus;
	
public Reimbursement() { }

public Reimbursement(int rId, double amt, String rDescription, String timeSubmitted, int empUId, int mangUId,
		String rType, String rStatus) {
	super();
	this.rId = rId;
	this.amt = amt;
	this.rDescription = rDescription;
	this.timeSubmitted = timeSubmitted;
	this.empUId = empUId;
	this.mangUId = mangUId;
	this.rType = rType;
	this.rStatus = rStatus;
}

public int getrId() {
	return rId;
}

public void setrId(int rId) {
	this.rId = rId;
}

public double getAmt() {
	return amt;
}

public void setAmt(double amt) {
	this.amt = amt;
}

public String getrDescription() {
	return rDescription;
}

public void setrDescription(String rDescription) {
	this.rDescription = rDescription;
}

public String getImg() {
	return img;
}

public void setImg(String img) {
	this.img = img;
}

public String getTimeSubmitted() {
	return timeSubmitted;
}

public void setTimeSubmitted(String timeSubmitted) {
	this.timeSubmitted = timeSubmitted;
}

public int getEmpUId() {
	return empUId;
}

public void setEmpUId(int empUId) {
	this.empUId = empUId;
}

public int getMangUId() {
	return mangUId;
}

public void setMangUId(int mangUId) {
	this.mangUId = mangUId;
}

public String getrType() {
	return rType;
}

public void setrType(String rType) {
	this.rType = rType;
}

public String getrStatus() {
	return rStatus;
}

public void setrStatus(String rStatus) {
	this.rStatus = rStatus;
}


	
	
	
	
	
	
	
	
	
	
}
