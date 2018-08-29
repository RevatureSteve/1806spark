package com.revature.domain;

import java.sql.Blob;

public class Reimbursement {
	



	private int rId;
	private int requestTypeId; 
	private int submissionUId; //Aka the person who submitted it 
	private int resolvedUId; //Aka the person who resolved it
	private int requestStatusId;
	private int amount;
	private String description;
	private Blob image;
	private String timeSubmission;
	private int uId;
	private String email;
	
	public int getuId() {
		return uId;
	}



	public void setuId(int uId) {
		this.uId = uId;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public int getPosition_Id() {
		return position_Id;
	}



	public void setPosition_Id(int position_Id) {
		this.position_Id = position_Id;
	}



	private String password;
	private int position_Id;
	
	
	public Reimbursement(int rId, int requestTypeId, int submissionUId, int resolvedUId, int requestStatusId,
			int amount, String description, Blob image, String timeSubmission, int uId, String email, String password,
			int position_Id, String fname, String lname, String rq_type, String requestStatus) {
		super();
		this.rId = rId;
		this.requestTypeId = requestTypeId;
		this.submissionUId = submissionUId;
		this.resolvedUId = resolvedUId;
		this.requestStatusId = requestStatusId;
		this.amount = amount;
		this.description = description;
		this.image = image;
		this.timeSubmission = timeSubmission;
		this.uId = uId;
		this.email = email;
		this.password = password;
		this.position_Id = position_Id;
		this.fname = fname;
		this.lname = lname;
		this.rq_type = rq_type;
		this.requestStatus = requestStatus;
	}



	public Reimbursement(int rId, int requestTypeId, int submissionUId, int resolvedUId, int requestStatusId,
			int amount, String description, Blob image, String timeSubmission, int uId, String email, String password,
			String fname, String lname, int position_Id) {
		super();
		this.rId = rId;
		this.requestTypeId = requestTypeId;
		this.submissionUId = submissionUId;
		this.resolvedUId = resolvedUId;
		this.requestStatusId = requestStatusId;
		this.amount = amount;
		this.description = description;
		this.image = image;
		this.timeSubmission = timeSubmission;
		this.uId = uId;
		this.email = email;
		this.password = password;
		this.fname = fname;
		this.lname = lname;
		this.position_Id = position_Id;
	}



	public String getFname() {
		return fname;
	}



	public void setFname(String fname) {
		this.fname = fname;
	}



	public String getLname() {
		return lname;
	}



	public void setLname(String lname) {
		this.lname = lname;
	}



	public String getRq_type() {
		return rq_type;
	}



	public void setRq_type(String rq_type) {
		this.rq_type = rq_type;
	}



	public String getRequestStatus() {
		return requestStatus;
	}



	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}



	public Reimbursement(int rId, int requestTypeId, int submissionUId, int resolvedUId, int requestStatusId,
			int amount, String description, Blob image, String timeSubmission, String fname, String lname,
			String rq_type, String requestStatus) {
		super();
		this.rId = rId;
		this.requestTypeId = requestTypeId;
		this.submissionUId = submissionUId;
		this.resolvedUId = resolvedUId;
		this.requestStatusId = requestStatusId;
		this.amount = amount;
		this.description = description;
		this.image = image;
		this.timeSubmission = timeSubmission;
		this.fname = fname;
		this.lname = lname;
		this.rq_type = rq_type;
		this.requestStatus = requestStatus;
	}



	private String fname;
	private String lname;
	private String rq_type;
	private String requestStatus;
	
	
	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Reimbursement(int rId, int requestTypeId, int submissionUId, int resolvedUId, int requestStatusId,
			int amount, String description, Blob image, String timeSubmission) {
		super();
		this.rId = rId;
		this.requestTypeId = requestTypeId;
		this.submissionUId = submissionUId;
		this.resolvedUId = resolvedUId;
		this.requestStatusId = requestStatusId;
		this.amount = amount;
		this.description = description;
		this.image = image;
		this.timeSubmission = timeSubmission;
	}
	
	public Reimbursement(int rId, String rq_type,String fname,String lname,int resolvedUId, String requestStatus,int amount, 
			String description, Blob image, String timeSubmission) {
		super();
		this.rId = rId;
		this.resolvedUId = resolvedUId;
		this.amount = amount;
		this.description = description;
		this.image = image;
		this.timeSubmission = timeSubmission;
		this.fname = fname;
		this.lname = lname;
		this.rq_type = rq_type;
		this.requestStatus = requestStatus;
	}


	public int getrId() {
		return rId;
	}



	public void setrId(int rId) {
		this.rId = rId;
	}



	public int getRequestTypeId() {
		return requestTypeId;
	}



	public void setRequestTypeId(int requestTypeId) {
		this.requestTypeId = requestTypeId;
	}



	public int getSubmissionUId() {
		return submissionUId;
	}



	public void setSubmissionUId(int submissionUId) {
		this.submissionUId = submissionUId;
	}



	public int getResolvedUId() {
		return resolvedUId;
	}



	public void setResolvedUId(int resolvedUId) {
		this.resolvedUId = resolvedUId;
	}



	public int getRequestStatusId() {
		return requestStatusId;
	}



	public void setRequestStatusId(int requestStatusId) {
		this.requestStatusId = requestStatusId;
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



	public Blob getImage() {
		return image;
	}



	public void setImage(Blob image) {
		this.image = image;
	}



	public String getTimeSubmission() {
		return timeSubmission;
	}



	public void setTimeSubmission(String timeSubmission) {
		this.timeSubmission = timeSubmission;
	}



	@Override
	public String toString() {
		return "Reimbursement [rId=" + rId + ", requestTypeId=" + requestTypeId + ", submissionUId=" + submissionUId
				+ ", resolvedUId=" + resolvedUId + ", requestStatusId=" + requestStatusId + ", amount=" + amount
				+ ", description=" + description + ", image=" + image + ", timeSubmission=" + timeSubmission + "]";
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
