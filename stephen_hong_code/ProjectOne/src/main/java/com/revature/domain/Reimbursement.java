package com.revature.domain;

public class Reimbursement {
	
	private int reimburseId;
	private int employeeId;
	private int managerId;
	private int rqTypeId;
	private int rqStatusId;
	private int amount;
	private String description;
	private String submitTime;
	
	public Reimbursement() {}

	public Reimbursement(int reimburseId, int employeeId, int managerId, int rqTypeId, int rqStatusId, int amount,
			String description, String submitTime) {
		super();
		this.reimburseId = reimburseId;
		this.employeeId = employeeId;
		this.managerId = managerId;
		this.rqTypeId = rqTypeId;
		this.rqStatusId = rqStatusId;
		this.amount = amount;
		this.description = description;
		this.submitTime = submitTime;
	}

	public int getReimburseId() {
		return reimburseId;
	}

	public void setReimburseId(int reimburseId) {
		this.reimburseId = reimburseId;
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

	public String getSubmitTime() {
		return submitTime;
	}

	public void setSubmitTime(String submitTime) {
		this.submitTime = submitTime;
	}

	@Override
	public String toString() {
		return "Reimbursement [reimburseId=" + reimburseId + ", employeeId=" + employeeId + ", managerId=" + managerId
				+ ", rqTypeId=" + rqTypeId + ", rqStatusId=" + rqStatusId + ", amount=" + amount + ", description="
				+ description + ", submitTime=" + submitTime + "]";
	}
	
	

}
