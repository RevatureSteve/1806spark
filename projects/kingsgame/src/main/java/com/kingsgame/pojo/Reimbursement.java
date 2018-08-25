package com.kingsgame.pojo;

public class Reimbursement {

private int r_id;
private int emp_u_id;
private int mgr_u_id;
private double amt;
private String description;
private Object img;
private String timesubmission;
private int rq_type_id;
private int rq_status_id;

public Reimbursement() {
	super();
}

public Reimbursement
 (int r_id,
 int emp_u_id,
 int mgr_u_id,
 double amt,
 String description,
 Object img,
 String timesubmission,
 int rq_type_id,
 int rq_status_id
		) {
this.r_id = r_id;
this.emp_u_id = emp_u_id;
this.mgr_u_id = mgr_u_id;
this.amt = amt;
this.description = description;
this.img = img;
this.timesubmission = timesubmission;
this.rq_type_id = rq_type_id;
this.rq_status_id = rq_status_id;
	
}

public Reimbursement
(int r_id, int emp_u_id, int mgr_u_id, 
double amt, String description,
String timesubmission, int rq_type_id, int rq_status_id) {
	super();
	this.r_id = r_id;
	this.emp_u_id = emp_u_id;
	this.mgr_u_id = mgr_u_id;
	this.amt = amt;
	this.description = description;
	this.img = img;
	this.timesubmission = timesubmission;
	this.rq_type_id = rq_type_id;
	this.rq_status_id = rq_status_id;
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
public Object getImg() {
	return img;
}
public void setImg(Object img) {
	this.img = img;
}
public String getTimesubmission() {
	return timesubmission;
}
public void setTimesubmission(String timesubmission) {
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
	return "Reimbursement [r_id=" + r_id + ", emp_u_id=" + emp_u_id + ", mgr_u_id=" + mgr_u_id + ", amt=" + amt
			+ ", description=" + description + ", img=" + img + ", timesubmission=" + timesubmission + ", rq_type_id="
			+ rq_type_id + ", rq_status_id=" + rq_status_id + "]";
}


}
