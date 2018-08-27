package com.revature.domain;

import java.sql.Blob;
import java.sql.Timestamp;

public class Reimbursements {

	
	private int emp_u_id;
	private int mgr_u_id;
	private int amt;
	private String description;
	private Blob img;
	private Timestamp timesubmission;
	private int rq_type_id;
	private int rq_status_id;
	
	
	
	
	
	public Reimbursements(int emp_u_id, int mgr_u_id, int amt, String description, Blob img, Timestamp timesubmission,
			int rq_type_id, int rq_status_id, int r_id) {
		super();
		this.emp_u_id = emp_u_id;
		this.mgr_u_id = mgr_u_id;
		this.amt = amt;
		this.description = description;
		this.img = img;
		this.timesubmission = timesubmission;
		this.rq_type_id = rq_type_id;
		this.rq_status_id = rq_status_id;
		this.r_id = r_id;
	}
	public Reimbursements() {
		super();
	}
	
	private int r_id;
	public int getR_id() {
		return r_id;
	}
	public void setR_id(int r_id) {
		this.r_id = r_id;
	}
	public int getEmp_u_id() {
		return emp_u_id;
	}
	public void setEmp_u_id(int emp_u_id) {
		this.emp_u_id = emp_u_id;
	}
	public int getMgr_u_id() {
		return mgr_u_id;
	}
	public void setMgr_u_id(int mgr_u_id) {
		this.mgr_u_id = mgr_u_id;
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
	public Timestamp getTimesubmission() {
		return timesubmission;
	}
	public void setTimesubmission(Timestamp timesubmission) {
		this.timesubmission = timesubmission;
	}
	public int getRq_type_id() {
		return rq_type_id;
	}
	public void setRq_type_id(int rq_type_id) {
		this.rq_type_id = rq_type_id;
	}
	public int getRq_status_id() {
		return rq_status_id;
	}
	public void setRq_status_id(int rq_status_id) {
		this.rq_status_id = rq_status_id;
	}
	@Override
	public String toString() {
		return "Reimbursements [emp_u_id=" + emp_u_id + ", mgr_u_id=" + mgr_u_id + ", amt=" + amt + ", description="
				+ description + ", img=" + img + ", timesubmission=" + timesubmission + ", rq_type_id=" + rq_type_id
				+ ", rq_status_id=" + rq_status_id + ", r_id=" + r_id + "]";
	}

	
	
}
