package com.revature.domain;

import java.sql.Blob;
import java.sql.Date;

public class Reimbursement {
	
	//states
	private int reimbId;
	private int empUserId;
	private int mgrUserId;
	private double amount;
	private String description;
	private Blob img;
	private String TimeSubmit;
	private int requestTypeId;
	private String requestType;
	private int requestStatusId;
	private String requestStatus;
	
	//NO-ARGS Constructor
	public Reimbursement() {
		super();
	}

	//Constructor
	public Reimbursement(int reimbId, int empUserId, int mgrUserId, double amount, String description, Blob img,
			String timeSubmit, int requestTypeId, String requestType, int requestStatusId, String requestStatus) {
		super();
		this.reimbId = reimbId;
		this.empUserId = empUserId;
		this.mgrUserId = mgrUserId;
		this.amount = amount;
		this.description = description;
		this.img = img;
		this.TimeSubmit = timeSubmit;
		this.requestTypeId = requestTypeId;
		this.requestType = requestType;
		this.requestStatusId = requestStatusId;
		this.requestStatus = requestStatus;
	}

	//Getters n' Setters
	public int getReimbId() {
		return reimbId;
	}

	public void setReimbId(int reimbId) {
		this.reimbId = reimbId;
	}

	public int getEmpUserId() {
		return empUserId;
	}

	public void setEmpUserId(int empUserId) {
		this.empUserId = empUserId;
	}

	public int getMgrUserId() {
		return mgrUserId;
	}

	public void setMgrUserId(int mgrUserId) {
		this.mgrUserId = mgrUserId;
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

	public Blob getImg() {
		return img;
	}

	public void setImg(Blob img) {
		this.img = img;
	}

	public String getTimeSubmit() {
		return TimeSubmit;
	}

	public void setTimeSubmit(String timeSubmit) {
		TimeSubmit = timeSubmit;
	}

	public int getRequestTypeId() {
		return requestTypeId;
	}

	public void setRequestTypeId(int requestTypeId) {
		this.requestTypeId = requestTypeId;
	}

	public int getRequestStatusId() {
		return requestStatusId;
	}

	public void setRequestStatusId(int requestStatusId) {
		this.requestStatusId = requestStatusId;
	}


	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public String getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}

	@Override
	public String toString() {
		return "Reimbursement [reimbId=" + reimbId + ", empUserId=" + empUserId + ", mgrUserId=" + mgrUserId
				+ ", amount=" + amount + ", description=" + description + ", img=" + img + ", TimeSubmit=" + TimeSubmit
				+ ", requestTypeId=" + requestTypeId + ", requestType=" + requestType + ", requestStatusId="
				+ requestStatusId + ", requestStatus=" + requestStatus + "]";
	}
}
