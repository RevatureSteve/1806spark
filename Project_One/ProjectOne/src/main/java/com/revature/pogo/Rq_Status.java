package com.revature.pogo;

/**
 * Rq_Status Class will be modeled after a table in the database.
 * Each state will represent a field in the database. 
 * (pretty much a variable will be a column in the database)
 * 
 * 
 * @author Alex Moraga
 *
 */

public class Rq_Status {

	// States
	private int rq_Status_Id; // PRIMARY KEY
	private String rq_Status;
	
	// no-args constructor
	public Rq_Status() {
		super();
		// TODO Auto-generated constructor stub
	}

	// constructors w/parameters
	public Rq_Status(int rq_Status_Id, String rq_Status) {
		super();
		this.rq_Status_Id = rq_Status_Id;
		this.rq_Status = rq_Status;
	}

	// setters & getters
	
	public int getRq_Status_Id() {
		return rq_Status_Id;
	}

	public void setRq_Status_Id(int rq_Status_Id) {
		this.rq_Status_Id = rq_Status_Id;
	}

	public String getRq_Status() {
		return rq_Status;
	}

	public void setRq_Status(String rq_Status) {
		this.rq_Status = rq_Status;
	}

	@Override
	public String toString() {
		return "Rq_Status [rq_Status_Id=" + rq_Status_Id + ", rq_Status=" + rq_Status + "]";
	}
	
}
