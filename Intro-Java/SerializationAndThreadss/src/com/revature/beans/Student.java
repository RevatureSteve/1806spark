package com.revature.beans;

import java.io.Serializable;

/*
	 * Student Class is not just a POJO
	 * Student class is a JavaBean - stricter version of a POJO
	 * 
	 * 
	 * 			1. State must be fully encapsulated (not allowed to be randomly accessed)
	 * 			2. provide getters and setters where needed! (Some states could be read only/get only)
	 * 			3. Must have a no args consutructor
	 * 			4. class must implement Serializable
	 * 			5. Override toString()
	 * 			
	 * 
	 * 
	 * 
	 * 
	 */
	
	
public class Student implements Serializable{
	
	/**
	 *  Used to deserialize and match the correct version that was when serializing
	 *  	(OPTIONAL but best practice)
	 */
	private static final long serialVersionUID = 101;
	
	private int id;
	private String name;
	private double gpa;
	private transient int ssn; //Transient keyword ignores any state that is marked transient during serialization 
	public Student() {}
	
	
	

	public Student(int id, String name, double gpa) {
		super();
		this.id = id;
		this.name = name;
		this.gpa = gpa;
	}

	public Student(int id, String name, double gpa,int ssn) {
		super();
		this.id = id;
		this.name = name;
		this.gpa = gpa;
		this.ssn = ssn;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}




	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", gpa=" + gpa + "]";
	}
	
	
		
	
	

}
