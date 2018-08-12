package com.revature.domain;

import java.awt.Image;
import java.sql.Blob;
import java.sql.Date;

public class Reimbursement {

	private int pId;
	private int empUId;
	private int mgrUId;
	private Double amt;
	private String description;
	private Blob img;
	private Date timeSubmission;
	private String rbType;
	private String rbStatus;
	
	
	public Reimbursement() {
		super();
	}


	public Reimbursement(int pId, int empUId, int mgrUId, Double amt, String description, Blob img,
			Date timeSubmission, String rbType, String rbStatus) {
		super();
		this.pId = pId;
		this.empUId = empUId;
		this.mgrUId = mgrUId;
		this.amt = amt;
		this.description = description;
		this.img = img;
		this.timeSubmission = timeSubmission;
		this.rbType = rbType;
		this.rbStatus = rbStatus;
	}


	public int getpId() {
		return pId;
	}


	public void setpId(int pId) {
		this.pId = pId;
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


	@Override
	public String toString() {
		return "reimbursement [pId=" + pId + ", empUId=" + empUId + ", mgrUId=" + mgrUId + ", amt=" + amt
				+ ", description=" + description + ", img=" + img + ", timeSubmission=" + timeSubmission + ", rbType="
				+ rbType + ", rbStatus=" + rbStatus + "]";
	}
	
	
	
	
}
