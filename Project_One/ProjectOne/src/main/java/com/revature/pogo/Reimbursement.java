package com.revature.pogo;

/**
 * Reimbursement Class will be modeled after a table in the database.
 * Each state will represent a field in the database. 
 * (pretty much a variable will be a column in the database)
 * 
 * 
 * @author Alex Moraga
 *
 */

public class Reimbursement {
	
	// States
	private int r_Id; // PRIMARY KEY
	private int amt;
	private int emp_U_Id; // FOREIGN KEY
	private int mgr_U_Id; // FOREIGN KEY
	private int rq_Type_Id; // FOREIGN KEY
	private int rq_Status_Id; // FOREIGN KEY
	private String description; 
	private String timeSubmission; // it might be an int??

	// I wonder what to with img (a blob) in java?)
	
	// no-args constructor
	public Reimbursement() {
		super();
	}

	// constructors w/parameters (might have to take out timestamp for toString and for constructos)
	
	public Reimbursement(int r_Id, int amt, int emp_U_Id, int mgr_U_Id, int rq_Type_Id, int rq_Status_Id,
			String description, String timeSubmission) {
		super();
		this.r_Id = r_Id;
		this.amt = amt;
		this.emp_U_Id = emp_U_Id;
		this.mgr_U_Id = mgr_U_Id;
		this.rq_Type_Id = rq_Type_Id;
		this.rq_Status_Id = rq_Status_Id;
		this.description = description;
		this.timeSubmission = timeSubmission;
	}

	// setters & getters
	
	public int getR_Id() {
		return r_Id;
	}

	public void setR_Id(int r_Id) {
		this.r_Id = r_Id;
	}

	public int getAmt() {
		return amt;
	}

	public void setAmt(int amt) {
		this.amt = amt;
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

	public int getRq_Type_Id() {
		return rq_Type_Id;
	}

	public void setRq_Type_Id(int rq_Type_Id) {
		this.rq_Type_Id = rq_Type_Id;
	}

	public int getRq_Status_Id() {
		return rq_Status_Id;
	}

	public void setRq_Status_Id(int rq_Status_Id) {
		this.rq_Status_Id = rq_Status_Id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTimeSubmission() {
		return timeSubmission;
	}

	public void setTimeSubmission(String timeSubmission) {
		this.timeSubmission = timeSubmission;
	}

	@Override
	public String toString() {
		return "reimbursement [r_Id=" + r_Id + ", amt=" + amt + ", emp_U_Id=" + emp_U_Id + ", mgr_U_Id=" + mgr_U_Id
				+ ", rq_Type_Id=" + rq_Type_Id + ", rq_Status_Id=" + rq_Status_Id + ", description=" + description
				+ ", timeSubmission=" + timeSubmission + "]";
	}
	
}
