package com.revature.pogo;

/**
 * Rq_Type Class will be modeled after a table in the database.
 * Each state will represent a field in the database. 
 * (pretty much a variable will be a column in the database)
 * 
 * 
 * @author Alex Moraga
 *
 */

public class Rq_Type {

	// States
	private int rq_Type_Id; // PRIMARY KEY
	private String rq_Type;
	
	// no-args constructor
	public Rq_Type() {
		super();
		// TODO Auto-generated constructor stub
	}

	// constructors w/parameters
	public Rq_Type(int rq_Type_Id, String rq_Type) {
		super();
		this.rq_Type_Id = rq_Type_Id;
		this.rq_Type = rq_Type;
	}
	
	// setters & getters
	
	public int getRq_Type_Id() {
		return rq_Type_Id;
	}

	public void setRq_Type_Id(int rq_Type_Id) {
		this.rq_Type_Id = rq_Type_Id;
	}

	public String getRq_Type() {
		return rq_Type;
	}

	public void setRq_Type(String rq_Type) {
		this.rq_Type = rq_Type;
	}

	@Override
	public String toString() {
		return "Rq_Type [rq_Type_Id=" + rq_Type_Id + ", rq_Type=" + rq_Type + "]";
	}
	
}
