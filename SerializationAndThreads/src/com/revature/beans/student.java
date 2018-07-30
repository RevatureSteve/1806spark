package com.revature.beans;

import com.revature.abstracts.teacher;

import java.io.Serializable;

/*
 * Student Class is not just a POJO	
 * Student Class is a JavaBean - stricter version of POJO
 * 
 * 			1. state must be fully encapsulated
 * 			2. provide getters and setters where needed
 * 			3. Must have a not-args constructor
 * 			4. class must implements Serializable
 * 			5. override toString()
 */

public class student implements Serializable, teacher{
	
	/**
	 * 	Used to deserialize and match the correct version that was used when serializing
	 * (OPTIONAL) but best practice
	 */
	private static final long serialVersionUID = 101;
	private int id;
	private String name;
	private double gpa;
	private transient int ssn;
	
	/*
	 * transient keyword is only used in serialization
	 * Ignore any state that is marked with transient during serialization
	 */
	
	public student() {}
	
	
	public student(int id, String name, double gpa, int ssn) {
		super();
		this.id = id;
		this.name = name;
		this.gpa = gpa;
		this.ssn = ssn;
	}



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

	@Override
	public String toString() {
		return "student [id=" + id + ", name=" + name + ", gpa=" + gpa + "]";
	}
	
	

}
