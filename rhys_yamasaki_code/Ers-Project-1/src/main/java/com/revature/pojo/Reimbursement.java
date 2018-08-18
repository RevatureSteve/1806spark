package com.revature.pojo;

import java.util.List;

public class Reimbursement {

	private int rb_id;
	private int rb_resolved_id;
	private int rb_submission_id;
	private int amount;
	private String description;
	private String time_submission;
	private int rq_type_id;
	private int rq_status_id;
	private String rb_resolved_name;
	private String rb_submission_name;
	private String rq_type;
	private String rq_status;
	
	private List<Reimbursement> listOfReimbursements;
	
	
	public Reimbursement() {
		
	}
	
	// Lazy loading from db
	public Reimbursement(int rb_id, int rb_resolved_id, int rb_submission_id, int amount, String description,
			String time_submission, int rq_type_id, int rq_status_id) {
		super();
		this.rb_id = rb_id;
		this.rb_resolved_id = rb_resolved_id;
		this.rb_submission_id = rb_submission_id;
		this.amount = amount;
		this.description = description;
		this.time_submission = time_submission;
		this.rq_type_id = rq_type_id;
		this.rq_status_id = rq_status_id;
	}
	
	
	// for join table
	public Reimbursement(int rb_id, int amount, String description, String time_submission, String rb_resolved_name,
			String rb_submission_name, String rq_type, String rq_status) {
		super();
		this.rb_id = rb_id;
		this.amount = amount;
		this.description = description;
		this.time_submission = time_submission;
		this.rb_resolved_name = rb_resolved_name;
		this.rb_submission_name = rb_submission_name;
		this.rq_type = rq_type;
		this.rq_status = rq_status;
	}

	// Eager loading from db
	public Reimbursement(int rb_id, int rb_resolved_id, int rb_submission_id, int amount, String description,
			String time_submission, int rq_type_id, int rq_status_id, String rb_resolved_name,
			String rb_submission_name, String rq_type, String rq_status, List<Reimbursement> listOfReimbursements) {
		super();
		this.rb_id = rb_id;
		this.rb_resolved_id = rb_resolved_id;
		this.rb_submission_id = rb_submission_id;
		this.amount = amount;
		this.description = description;
		this.time_submission = time_submission;
		this.rq_type_id = rq_type_id;
		this.rq_status_id = rq_status_id;
		this.rb_resolved_name = rb_resolved_name;
		this.rb_submission_name = rb_submission_name;
		this.rq_type = rq_type;
		this.rq_status = rq_status;
		this.listOfReimbursements = listOfReimbursements;
	}



	public int getRb_id() {
		return rb_id;
	}
	public void setRb_id(int rb_id) {
		this.rb_id = rb_id;
	}
	public int getRb_resolved_id() {
		return rb_resolved_id;
	}
	public void setRb_resolved_id(int rb_resolved_id) {
		this.rb_resolved_id = rb_resolved_id;
	}
	public int getRb_submission_id() {
		return rb_submission_id;
	}
	public void setRb_submission_id(int rb_submission_id) {
		this.rb_submission_id = rb_submission_id;
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
	public String getTime_submission() {
		return time_submission;
	}
	public void setTime_submission(String time_submission) {
		this.time_submission = time_submission;
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
	public String getRb_resolved_name() {
		return rb_resolved_name;
	}
	public void setRb_resolved_name(String rb_resolved_name) {
		this.rb_resolved_name = rb_resolved_name;
	}
	public String getRb_submission_name() {
		return rb_submission_name;
	}
	public void setRb_submission_name(String rb_submission_name) {
		this.rb_submission_name = rb_submission_name;
	}
	public String getRq_type() {
		return rq_type;
	}
	public void setRq_type(String rq_type) {
		this.rq_type = rq_type;
	}
	public String getRq_status() {
		return rq_status;
	}
	public void setRq_status(String rq_status) {
		this.rq_status = rq_status;
	}


	@Override
	public String toString() {
		return "Reimbursement [rb_id=" + rb_id + ", rb_resolved_id=" + rb_resolved_id + ", rb_submission_id="
				+ rb_submission_id + ", amount=" + amount + ", description=" + description + ", time_submission="
				+ time_submission + ", rq_type_id=" + rq_type_id + ", rq_status_id=" + rq_status_id
				+ ", rb_resolved_name=" + rb_resolved_name + ", rb_submission_name=" + rb_submission_name + ", rq_type="
				+ rq_type + ", rq_status=" + rq_status + "]";
	}
	
}
