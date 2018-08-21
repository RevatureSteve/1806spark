package com.revature.beans;

import java.io.Serializable;

/*
 * Student Class is not just a POJO
 * Student Class is a JavaBean - stricter version of a POJO
 * 
 * 		1. State must be fully encapsulated
 * 		2. provide getters and setters where needed
 * 		3. Must have a no-args constructor
 * 		4. Class must implement Serializable
 * 		5. Override toString()
 */
public class Student implements Serializable{
	/**
	 * Used to deserialize and match the correct version that was used when serializing
	 * 	(optional but best practice)
	 */
	private static final long serialVersionUID = 101;
	
	private int id;
	private String name;
	private double gpa;
	private transient int ssn;
	
	/**
	 * 
	 */
	public Student() {
		super();
	}
	
	/**
	 * @param id
	 * @param name
	 * @param gpa
	 */
	public Student(int id, String name, double gpa) {
		super();
		this.id = id;
		this.name = name;
		this.gpa = gpa;
	}

	/**
	 * @param id
	 * @param name
	 * @param gpa
	 * @param ssn
	 */
	public Student(int id, String name, double gpa, int ssn) {
		super();
		this.id = id;
		this.name = name;
		this.gpa = gpa;
		this.ssn = ssn;
	}

	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", gpa=" + gpa + ", ssn=" + ssn + "]";
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
}
