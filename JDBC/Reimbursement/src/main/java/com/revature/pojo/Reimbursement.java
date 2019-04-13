package com.revature.pojo;

import java.sql.Blob;
import java.sql.Timestamp;

public class Reimbursement {
	
	private int requestId;
	private int employeeId;
	private int managerId;
	private int amount;
	private String description;
	private Blob img;
	private Timestamp timeSubmission;
	private int requestTypeId;
	private int requestStatusId;

	public Reimbursement() {}

	public Reimbursement(int requestId, int employeeId, int managerId, int amount, String description, Blob img,
			Timestamp timeSubmission, int requestTypeId, int requestStatusId) {
		super();
		this.requestId = requestId;
		this.employeeId = employeeId;
		this.managerId = managerId;
		this.amount = amount;
		this.description = description;
		this.img = img;
		this.timeSubmission = timeSubmission;
		this.requestTypeId = requestTypeId;
		this.requestStatusId = requestStatusId;
	}
	public Reimbursement(int employeeId, int managerId, int amount, String description, Blob img,
			Timestamp timeSubmission, int requestTypeId, int requestStatusId) {
		super();
		this.employeeId = employeeId;
		this.managerId = managerId;
		this.amount = amount;
		this.description = description;
		this.img = img;
		this.timeSubmission = timeSubmission;
		this.requestTypeId = requestTypeId;
		this.requestStatusId = requestStatusId;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
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

	public Timestamp getTimeSubmission() {
		return timeSubmission;
	}

	public void setTimeSubmission(Timestamp timeSubmission) {
		this.timeSubmission = timeSubmission;
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

	@Override
	public String toString() {
		return "Reimbursement [requestId=" + requestId + ", employeeId=" + employeeId + ", managerId=" + managerId
				+ ", amount=" + amount + ", description=" + description + ", img=" + img + ", timeSubmission="
				+ timeSubmission + ", requestTypeId=" + requestTypeId + ", requestStatusId=" + requestStatusId + "]";
	}
	
}
