package com.revature.domain;

import java.io.Serializable;

public class Reimbursement implements Serializable {
	
	private int r_id; //1
	private int emp_u_id;//2
	private int mgr_u_id; //3
	private int rq_type_id;//8
	private int rq_status_id;//9
	private double amt;//4
	private String description;//5
	private String timesubmission;//7
	private String  img;//6
	
	
	public Reimbursement() {}
	
	public Reimbursement(int r_id, int emp_u_id, int mgr_u_id, int rq_type_id, int rq_status_id, double amt,
			String description, String timesubmission, String img) {
		super();
		this.r_id = r_id;
		this.emp_u_id = emp_u_id;
		this.mgr_u_id = mgr_u_id;
		this.rq_type_id = rq_type_id;
		this.rq_status_id = rq_status_id;
		this.amt = amt;
		this.description = description;
		this.timesubmission = timesubmission;
		this.img = img;
	}

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

	public double getAmt() {
		return amt;
	}

	public void setAmt(double amt) {
		this.amt = amt;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTimesubmission() {
		return timesubmission;
	}

	public void setTimesubmission(String timesubmission) {
		this.timesubmission = timesubmission;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "Reimbursement [r_id=" + r_id + ", emp_u_id=" + emp_u_id + ", mgr_u_id=" + mgr_u_id + ", rq_type_id="
				+ rq_type_id + ", rq_status_id=" + rq_status_id + ", amt=" + amt + ", description=" + description
				+ ", timesubmission=" + timesubmission + ", img=" + img + "]";
	}
	
	
	
	
	
	

}
