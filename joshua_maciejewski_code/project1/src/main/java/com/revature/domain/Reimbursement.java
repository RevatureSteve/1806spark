package com.revature.domain;

import java.sql.Blob;
import java.util.Date;

import com.revature.exceptions.NoNegativeAmtException;



public class Reimbursement {

	private int rId;
	private int empUId;
	private int mgrUId;
	private double amt;
	private String description;
	private Blob img;
	private Date timesubmission;
	private int rqTypeId;
	private String rqType;
	private int rqStatusId;
	private String rqStatus;
	
	
	
	public Reimbursement() {
		super();
	}

	
	


	public Reimbursement(int empUId, double amt, String description, Blob img, int rqTypeId) {
		super();
		this.empUId = empUId;
		setAmt(amt);
		this.description = description;
		this.img = img;
		this.rqTypeId = rqTypeId;
	}

	




	public Reimbursement(int rId, double amt, String description, Blob img, Date timesubmission) {
		super();
		this.rId = rId;
		setAmt(amt);
		this.description = description;
		this.img = img;
		this.timesubmission = timesubmission;
	}



	public Reimbursement(int rId, int empUId, int mgrUId, double amt, String description, Blob img, Date timesubmission,
			int rqTypeId, String rqType, int rqStatusId, String rqStatus) {
		super();
		this.rId = rId;
		this.empUId = empUId;
		this.mgrUId = mgrUId;
		setAmt(amt);
		this.description = description;
		this.img = img;
		this.timesubmission = timesubmission;
		this.rqTypeId = rqTypeId;
		this.rqType = rqType;
		this.rqStatusId = rqStatusId;
		this.rqStatus = rqStatus;
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



	public double getAmt() {
		return amt;
	}



	public void setAmt(double amt) {
		if (amt >= 0) {
			this.amt = amt;
		}else {
			throw new NoNegativeAmtException("Please enter a number greater than 0");
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



	public Date getTimesubmission() {
		return timesubmission;
	}



	public void setTimesubmission(Date timesubmission) {
		this.timesubmission = timesubmission;
	}



	public int getRqTypeId() {
		return rqTypeId;
	}



	public void setRqTypeId(int rqTypeId) {
		this.rqTypeId = rqTypeId;
	}



	public String getRqType() {
		return rqType;
	}



	public void setRqType(String rqType) {
		this.rqType = rqType;
	}



	public int getRqStatusId() {
		return rqStatusId;
	}



	public void setRqStatusId(int rqStatusId) {
		this.rqStatusId = rqStatusId;
	}



	public String getRqStatus() {
		return rqStatus;
	}



	public void setRqStatus(String rqStatus) {
		this.rqStatus = rqStatus;
	}



	@Override
	public String toString() {
		return "Reimbursement [rId=" + rId + ", empUId=" + empUId + ", mgrUId=" + mgrUId + ", amt=" + amt
				+ ", description=" + description + ", img=" + img + ", timesubmission=" + timesubmission + ", rqTypeId="
				+ rqTypeId + ", rqType=" + rqType + ", rqStatusId=" + rqStatusId + ", rqStatus=" + rqStatus + "]";
	}



	
}
