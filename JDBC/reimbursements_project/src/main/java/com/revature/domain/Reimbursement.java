package com.revature.domain;

public class Reimbursement {
	private int rId;
	private int empUId;
	private int mgrUId;
	private int amount;
	private String description;
	private Object img;
	private String timesubmission;
	private String rq_type;
	private String rq_status;
	private int rq_typeId;
	private int rq_statusId;
	
	public Reimbursement(int rId, int empUId, int mgrUId, int amount, String description, Object img,
			String timesubmission, String rq_type, String rq_status, int rq_typeId, int rq_statusId) {
		super();
		this.rId = rId;
		this.empUId = empUId;
		this.mgrUId = mgrUId;
		this.amount = amount;
		this.description = description;
		this.img = img;
		this.timesubmission = timesubmission;
		this.rq_type = rq_type;
		this.rq_status = rq_status;
		this.rq_typeId = rq_typeId;
		this.rq_statusId = rq_statusId;
				
	}

	public int getAmount() {
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

	public int getEmpUId() {
		return empUId;
	}

	public int getMgrUId() {
		return mgrUId;
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
