package com.revature.pogo;

/**
 * Position Class will be modeled after a table in the database.
 * Each state will represent a field in the database. 
 * (pretty much a variable will be a column in the database)
 * 
 * 
 * @author Alex Moraga
 *
 */

public class Position {

	// States
	private int pos_Id; // PRIMARY KEY
	private String pos_Type;
	
	// no-args constructor
	public Position() {
		super();
		// TODO Auto-generated constructor stub
	}

	// constructors w/parameters
	public Position(int pos_Id, String pos_Type) {
		super();
		this.pos_Id = pos_Id;
		this.pos_Type = pos_Type;
	}

	// setters & getters
	
	public int getPos_Id() {
		return pos_Id;
	}

	public void setPos_Id(int pos_Id) {
		this.pos_Id = pos_Id;
	}

	public String getPos_Type() {
		return pos_Type;
	}

	public void setPos_Type(String pos_Type) {
		this.pos_Type = pos_Type;
	}

	@Override
	public String toString() {
		return "Position [pos_Id=" + pos_Id + ", pos_Type=" + pos_Type + "]";
	} 
	
}
