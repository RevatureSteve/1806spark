package com.revature.Pojo;

import java.sql.Timestamp;

public class Reimbursement {
	
	private int r_Id;
	private int emp_U_Id;
	private int mgr_U_Id;
	private int amt;
	private String description;
	private Timestamp time_Submission;
	private int rq_Type;
	private int rq_Status_Id;
	
	
	
	public Reimbursement(int r_Id, int emp_U_Id, int mgr_U_Id, int amt, String description, Timestamp time_Submission,
			int rq_Type, int rq_Status_Id) {
		super();
		this.r_Id = r_Id;
		this.emp_U_Id = emp_U_Id;
		this.mgr_U_Id = mgr_U_Id;
		this.amt = amt;
		this.description = description;
		this.time_Submission = time_Submission;
		this.rq_Type = rq_Type;
		this.rq_Status_Id = rq_Status_Id;
	}



	public int getR_Id() {
		return r_Id;
	}



	public void setR_Id(int r_Id) {
		this.r_Id = r_Id;
	}



	public int getEmp_U_Id() {
		return emp_U_Id;
	}



	public void setEmp_U_Id(int emp_U_Id) {
		this.emp_U_Id = emp_U_Id;
	}



	public int getMgr_U_Id() {
		return mgr_U_Id;
	}



	public void setMgr_U_Id(int mgr_U_Id) {
		this.mgr_U_Id = mgr_U_Id;
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



	public Timestamp getTime_Submission() {
		return time_Submission;
	}



	public void setTime_Submission(Timestamp time_Submission) {
		this.time_Submission = time_Submission;
	}



	public int getRq_Type() {
		return rq_Type;
	}



	public void setRq_Type(int rq_Type) {
		this.rq_Type = rq_Type;
	}



	public int getRq_Status_Id() {
		return rq_Status_Id;
	}



	public void setRq_Status_Id(int rq_Status_Id) {
		this.rq_Status_Id = rq_Status_Id;
	}



	@Override
	public String toString() {
		return "Reimbursement [r_Id=" + r_Id + ", emp_U_Id=" + emp_U_Id + ", mgr_U_Id=" + mgr_U_Id + ", amt=" + amt
				+ ", description=" + description + ", time_Submission=" + time_Submission + ", rq_Type=" + rq_Type
				+ ", rq_Status_Id=" + rq_Status_Id + "]";
	}
	
	
	
	
	

}
