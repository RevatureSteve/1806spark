package com.revature.domain;

import java.sql.Blob;

public class Reimbursement {
	private int rId;
	private User employee;
	private User manager;
	private double amount;
	private String description;
	private Object img;
	private String timesubmission;
	private String rq_type;
	private String rq_status;
	private int rq_typeId;
	private int rq_statusId;

	

	public Reimbursement(int rId, User employee, User manager, double amount, String description, Object img,
			String timesubmission, String rq_type, String rq_status, int rq_typeId, int rq_statusId) {
		super();
		this.rId = rId;
		this.employee = employee;
		this.manager = manager;
		this.amount = amount;
		this.description = description;
		this.img = img;
		this.timesubmission = timesubmission;
		this.rq_type = rq_type;
		this.rq_status = rq_status;
		this.rq_typeId = rq_typeId;
		this.rq_statusId = rq_statusId;
	}

	public User getEmployee() {
		return employee;
	}

	public User getManager() {
		return manager;
	}

	public double getAmount() {
		return amount;
	}

	public int getRq_typeId() {
		return rq_typeId;
	}

	public int getRq_statusId() {
		return rq_statusId;
	}

	public String getDescription() {
		return description;
	}

	public int getrId() {
		return rId;
	}

	public Object getImg() {
		return img;
	}

	public String getTimesubmission() {
		return timesubmission;
	}

	public String getRq_type() {
		return rq_type;
	}

	public String getRq_status() {
		return rq_status;
	}
}
