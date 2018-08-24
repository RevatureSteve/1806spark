package com.revature.POJO;

public class Reimbursement {
	private int rid;
	private String mId;
	private double amt;
	private String desc;
	private String time;
	private String type;
	private String status;
	
	public Reimbursement() {
		super();
	}

	public Reimbursement(int rid, String mId, double amt, String desc, String time, String type, String status) {
		super();
		this.rid = rid;
		this.mId = mId;
		this.amt = amt;
		this.desc = desc;
		this.time = time;
		this.type = type;
		this.status = status;
	}

	public Reimbursement(String mId, double amt, String desc, String time) {
		this.mId = mId;
		this.amt = amt;
		this.desc = desc;
		this.time = time;
	}
	
	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public double getAmt() {
		return amt;
	}

	public void setAmt(double amt) {
		this.amt = amt;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ID: " + rid + "\nManager: " + mId + "\nAmount: $" + amt + "\nDescription: " + desc
				+ "\nTime: " + time + "\nType: " + type + "\nStatus: " + status;
	}
}