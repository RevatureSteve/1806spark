package com.revature.pojo;

import java.sql.Blob;

public class TranstarReims {
	
	private int r_id;
	private int emp_u_id;
	private int mgr_u_id;
	private int amt;
	private String description;
	private Blob img;
	private String timeStamp;
	private String rb_type;
	private String rq_status;
	
	
	public TranstarReims() {
		super();
	}


	public TranstarReims(int r_id, int emp_u_id, int mgr_u_id, int amt, String description, Blob img, String timeStamp,
			String rb_type, String rq_status) {
		super();
		this.r_id = r_id;
		this.emp_u_id = emp_u_id;
		this.mgr_u_id = mgr_u_id;
		this.amt = amt;
		this.description = description;
		this.img = img;
		this.timeStamp = timeStamp;
		this.rb_type = rb_type;
		this.rq_status = rq_status;
	}
	

	@Override
	public String toString() {
		return "TranstarReims [r_id=" + r_id + ", emp_u_id=" + emp_u_id + ", mgr_u_id=" + mgr_u_id + ", amt=" + amt
				+ ", description=" + description + ", img=" + img + ", timeStamp=" + timeStamp + ", rb_type=" + rb_type
				+ ", rq_status=" + rq_status + "]";
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


	public String getTimeStamp() {
		return timeStamp;
	}


	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}


	public String getRb_type() {
		return rb_type;
	}


	public void setRb_type(String rb_type) {
		this.rb_type = rb_type;
	}


	public String getRq_status() {
		return rq_status;
	}


	public void setRq_status(String rq_status) {
		this.rq_status = rq_status;
	}
	
	
	

}
