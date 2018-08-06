package com.revature.beans;

import java.io.Serializable;

import com.revature.abstracts.Teachable;

/*
 * Student Class is not just a POJO
 * Student Class is a JavaBean - stricter version of a POJO
 * 
 * 		1. state must be fully encapsulated
 * 		2. provide getters and setters where needed
 * 		3. must have no-args constructor
 * 		4. class must implements Serializable
 * 		5. override toString()
 * 
 */

public class Student implements Serializable, Teachable {
	
	/**
	 * Used to deserialize and match the correct version that was used when serializing
	 * 		(OPTIONAL but best practice)
	 */
	private static final long serialVersionUID = 101;
	
	private int id;
	private String name;
	private double gpa;
	private transient int ssn;
	/*
	 * transient keyword is only used in serialization
	 * 		Ignore any state that is marked transient during serialization
	 */
	
	public Student () {
		super();
	}
	
	public Student(int id, String name, double gpa) {
		super();
		this.id = id;
		this.name = name;
		this.gpa = gpa;
	}

	public Student(int id, String name, double gpa, int ssn) {
		super();
		this.id = id;
		this.name = name;
		this.gpa = gpa;
		this.ssn = ssn;
	}

	// alt + shift + s then r for generating getters and setters
	
	@Override
	public void learn() {
		System.out.println("Student learns");
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

	public int getSsn() {
		return ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", gpa=" + gpa + "]";
	}

}
