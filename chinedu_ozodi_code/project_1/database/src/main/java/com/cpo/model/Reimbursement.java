package com.cpo.model;

import java.sql.Blob;
import java.sql.Timestamp;

public class Reimbursement {
	private int rId;
	private int empUId;
	private int mgrUId;
	private int amt;
	private String description;
	private Blob img;
	private Timestamp timeSubmission;
	private int rqTypeId;
	private String rqType;
	private int rqStatusId;
	private String rqStatus;
	private String mfname;
	private String mlname;
	private String efname;
	private String elname;

	public Reimbursement() {
	}

	public Reimbursement(int empUId, int mgrUId, int amt, String description, Blob img, Timestamp timeSubmission,
			int rqTypeId, String rqType, int rqStatusId, String rqStatus) {
		super();
		this.empUId = empUId;
		this.mgrUId = mgrUId;
		this.amt = amt;
		this.description = description;
		this.img = img;
		this.timeSubmission = timeSubmission;
		this.rqTypeId = rqTypeId;
		this.rqType = rqType;
		this.rqStatusId = rqStatusId;
		this.rqStatus = rqStatus;
	}

	public Reimbursement(int rId, int empUId, int mgrUId, int amt, String description, Blob img,
			Timestamp timeSubmission, int rqTypeId, String rqType, int rqStatusId, String rqStatus, String mfname,
			String mlname, String efname, String elname) {
		super();
		this.rId = rId;
		this.empUId = empUId;
		this.mgrUId = mgrUId;
		this.amt = amt;
		this.description = description;
		this.img = img;
		this.timeSubmission = timeSubmission;
		this.rqTypeId = rqTypeId;
		this.rqType = rqType;
		this.rqStatusId = rqStatusId;
		this.rqStatus = rqStatus;
		this.mfname = mfname;
		this.mlname = mlname;
		this.efname = efname;
		this.elname = elname;
	}

	public String getMfname() {
		return mfname;
	}

	public void setMfname(String mfname) {
		this.mfname = mfname;
	}

	public String getMlname() {
		return mlname;
	}

	public void setMlname(String mlname) {
		this.mlname = mlname;
	}

	public String getEfname() {
		return efname;
	}

	public void setEfname(String efname) {
		this.efname = efname;
	}

	public String getElname() {
		return elname;
	}

	public void setElname(String elname) {
		this.elname = elname;
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

	public int getAmt() {
		return amt;
	}

	public void setAmt(int amt) {
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

	public Timestamp getTimeSubmission() {
		return timeSubmission;
	}

	public void setTimeSubmission(Timestamp timeSubmission) {
		this.timeSubmission = timeSubmission;
	}

	public int getRqTypeId() {
		return rqTypeId;
	}

	public void setRqTypeId(int rqTypeId) {
		this.rqTypeId = rqTypeId;
	}

	public String getRqStatus() {
		return rqStatus;
	}

	public void setRqStatus(String rqStatus) {
		this.rqStatus = rqStatus;
	}

	public int getRqStatusId() {
		return rqStatusId;
	}

	public void setRqStatusId(int rqStatusId) {
		this.rqStatusId = rqStatusId;
	}

	public String getRqType() {
		return rqType;
	}

	public void setRqType(String rqType) {
		this.rqType = rqType;
	}

	@Override
	public String toString() {
		return "Reimbursement [rId=" + rId + ", empUId=" + empUId + ", mgrUId=" + mgrUId + ", amt=" + amt
				+ ", description=" + description + ", img=" + img + ", timeSubmission=" + timeSubmission + ", rqTypeId="
				+ rqTypeId + ", rqType=" + rqType + ", rqStatusId=" + rqStatusId + ", rqStatus=" + rqStatus + "]";
	}
	
	
	

}
