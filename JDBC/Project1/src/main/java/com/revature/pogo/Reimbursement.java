package com.revature.pogo;

import java.io.Serializable;

public class Reimbursement implements Serializable{
	
	private int reimbursementId;
	private int empId;
	private int mgrId;
	private double amount;
	private String description;
	private String imageUrl;
	private String timeStamp;
	private int reqTypeId;
	private int reqStatusId;
	
	public Reimbursement() {
		
	}
	
	public Reimbursement(int empId, double amount, String description, String imageUrl, int reqTypeId) {
		super();
		this.empId = empId;
		this.amount = amount;
		this.description = description;
		this.imageUrl = imageUrl;
		this.reqTypeId = reqTypeId;
	}

	public Reimbursement(int reimbursementId, int empId, int mgrId, double amount, String description, String imageUrl,
			String timeStamp, int reqTypeId, int reqStatusId) {
		super();
		this.reimbursementId = reimbursementId;
		this.empId = empId;
		this.mgrId = mgrId;
		this.amount = amount;
		this.description = description;
		this.imageUrl = imageUrl;
		this.timeStamp = timeStamp;
		this.reqTypeId = reqTypeId;
		this.reqStatusId = reqStatusId;
	}

	public int getReimbursementId() {
		return reimbursementId;
	}
	
	public void setReimbursementId(int reimbursementId) {
		this.reimbursementId = reimbursementId;
	}
	
	public int getEmpId() {
		return empId;
	}
	
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	
	public int getMgrId() {
		return mgrId;
	}
	
	public void setMgrId(int mgrId) {
		this.mgrId = mgrId;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getImageUrl() {
		return imageUrl;
	}
	
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	public String getTimeStamp() {
		return timeStamp;
	}
	
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public int getReqTypeId() {
		return reqTypeId;
	}

	public void setReqTypeId(int reqTypeId) {
		this.reqTypeId = reqTypeId;
	}

	public int getReqStatusId() {
		return reqStatusId;
	}

	public void setReqStatusId(int reqStatusId) {
		this.reqStatusId = reqStatusId;
	}

	@Override
	public String toString() {
		return "reimbursement [reimbursementId=" + reimbursementId + ", empId=" + empId + ", mgrId=" + mgrId
				+ ", amount=" + amount + ", description=" + description + ", imageUrl=" + imageUrl + ", timeStamp="
				+ timeStamp + ", reqTypeId=" + reqTypeId + ", reqStatusId=" + reqStatusId + "]";
	}

}
