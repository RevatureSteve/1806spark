package com.drake.domain;

import java.sql.Blob;
import java.sql.Date;

public class Reimbursement {

	private int rId;
	private int empUId;
	private String employeeName;
	private int mgrUId;
	private String managerName;
	private Double amt;
	private String description;
	private Blob img;
	private Date timeSubmission;
	private String rbType;
	private int rbTypeId;
	private String rbStatus;
	private int rbStatusId;
	
	
	public Reimbursement() {
		super();
	}


	public Reimbursement(int rId, int empUId, String employeeName, int mgrUId, String managerName, Double amt,
			String description, Blob img, Date timeSubmission, String rbType, int rbTypeId, String rbStatus,
			int rbStatusId) {
		super();
		this.rId = rId;
		this.empUId = empUId;
		this.employeeName = employeeName;
		this.mgrUId = mgrUId;
		this.managerName = managerName;
		this.amt = amt;
		this.description = description;
		this.img = img;
		this.timeSubmission = timeSubmission;
		this.rbType = rbType;
		this.rbTypeId = rbTypeId;
		this.rbStatus = rbStatus;
		this.rbStatusId = rbStatusId;
	}


	public Reimbursement(int rId, int empUId, int mgrUId, Double amt, String description, Blob img,
			Date timeSubmission, String rbType, String rbStatus, int rbStatusId) {
		super();
		this.rId = rId;
		this.empUId = empUId;
		this.mgrUId = mgrUId;
		setAmt(amt);
		this.description = description;
		this.img = img;
		this.timeSubmission = timeSubmission;
		this.rbType = rbType;
		this.rbStatus = rbStatus;
		this.rbStatusId = rbStatusId;
	}

	
	public Reimbursement(int empUId, Double amt, String description, Blob img, int rbTypeId) {
		super();
		this.empUId = empUId;
		this.amt = amt;
		this.description = description;
		this.img = img;
		this.rbTypeId = rbTypeId;
	}


	public int getrId() {
		return rId;
	}


	public void setrId(int rId) {
		this.rId = rId;
	}


	public int getEmpUId() {
		return empUId;
	}


	public void setEmpUId(int empUId) {
		this.empUId = empUId;
	}


	public int getMgrUId() {
		return mgrUId;
	}


	public void setMgrUId(int mgrUId) {
		this.mgrUId = mgrUId;
	}


	public Double getAmt() {
		return amt;
	}


	public void setAmt(Double amt) {
		this.amt = amt;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Blob getImg() {
		return img;
	}


	public void setImg(Blob img) {
		this.img = img;
	}


	public Date getTimeSubmission() {
		return timeSubmission;
	}


	public void setTimeSubmission(Date timeSubmission) {
		this.timeSubmission = timeSubmission;
	}


	public String getRbType() {
		return rbType;
	}


	public void setRbType(String rbType) {
		this.rbType = rbType;
	}


	public String getRbStatus() {
		return rbStatus;
	}


	public void setRbStatus(String rbStatus) {
		this.rbStatus = rbStatus;
	}
	

	public int getRbTypeId() {
		return rbTypeId;
	}


	public void setRbTypeId(int rbTypeId) {
		this.rbTypeId = rbTypeId;
	}
	

	public int getRbStatusId() {
		return rbStatusId;
	}


	public void setRbStatusId(int rbStatusId) {
		this.rbStatusId = rbStatusId;
	}


	public String getEmployeeName() {
		return employeeName;
	}


	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}


	public String getManagerName() {
		return managerName;
	}


	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}


	@Override
	public String toString() {
		return "Id: " + rId + "\n\nEmployee Name: " + employeeName + "\n\nManager Name: " + managerName + "\n\nAmount: " + amt + "\n\nDescription: " + description + 
				"\n\nTime Submission: " + timeSubmission + "\n\nReimbursement Type: " + rbType 
				+ "\n\nReimbursement Status: " + rbStatus;
	}
	
}