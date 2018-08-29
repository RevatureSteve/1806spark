package com.revature.domain;


import java.sql.Blob;
import java.sql.Date;

import com.revature.exceptions.NoNegativeException;

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
	private String rqType;
	private int rqTypeId;
	private String rqStatus;
	private int rqStatusId;
	
	
	public Reimbursement() {
		super();
	}



	public Reimbursement(int rId, int empUId, String employeeName, int mgrUId, String managerName, Double amt,
			String description, Blob img, Date timeSubmission, String rqType, int rqTypeId, String rqStatus,
			int rqStatusId) {
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
		this.rqType = rqType;
		this.rqTypeId = rqTypeId;
		this.rqStatus = rqStatus;
		this.rqStatusId = rqStatusId;
	}





	public Reimbursement(int rId, int empUId, int mgrUId, Double amt, String description, Blob img,
			Date timeSubmission, String rqType, String rqStatus, int rqStatusId) {
		super();
		this.rId = rId;
		this.empUId = empUId;
		this.mgrUId = mgrUId;
		setAmt(amt);
		this.description = description;
		this.img = img;
		this.timeSubmission = timeSubmission;
		this.rqType = rqType;
		this.rqStatus = rqStatus;
		this.rqStatusId = rqStatusId;
	}

	
	public Reimbursement(int empUId, Double amt, String description, Blob img, int rqTypeId) {
		super();
		this.empUId = empUId;
		setAmt(amt);
		this.description = description;
		this.img = img;
		this.rqTypeId = rqTypeId;
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
		if (amt >= 0) {
			this.amt = amt;
		}else {
			throw new NoNegativeException("Cannot have a negative amount");
		}
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


	public String getRqType() {
		return rqType;
	}


	public void setRqType(String rqType) {
		this.rqType = rqType;
	}


	public String getRqStatus() {
		return rqStatus;
	}


	public void setRqStatus(String rqStatus) {
		this.rqStatus = rqStatus;
	}
	
	

	public int getRqTypeId() {
		return rqTypeId;
	}


	public void setRqTypeId(int rqTypeId) {
		this.rqTypeId = rqTypeId;
	}
	

	public int getRqStatusId() {
		return rqStatusId;
	}


	public void setRqStatusId(int rqStatusId) {
		this.rqStatusId = rqStatusId;
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
				"\n\nTime Submission: " + timeSubmission + "\n\nReimbursement Type: " + rqType 
				+ "\n\nReimbursement Status: " + rqStatus;
	}
	
	
	
	
}
