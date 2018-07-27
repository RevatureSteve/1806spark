package com.revature.beans;

import java.io.Serializable;

import com.revature.abstracts.Teachable;


/*
 * student class is not just a POJO
 * student class is a JavaBean - more strict version of a POJO 
 * 		1. state must be full encapsulated
 * 		2. provide getters and setters where needed
 * 		3. must have a NO-ARGS constructor
 * 		4. class must implement Serializable
 * 		5. override toString() 
 */

public class Student implements Serializable, Teachable {

	/**
	 * used to deserialize and match the correct version that was used when serializing 
	 * 		note(optional) : not required but for good practice 
	 */
	private static final long serialVersionUID = -7099763929840869400L;
	private int id;
	private String name;
	private double gpa;
	//private transient int ssn;
	/*
	 * transient keyword is only used in serialization
	 * 		ignore any state that is marked transient during serialization
	 */
	
	public Student() {}
	
	public Student(int id, String name, double gpa) {
		super();
		this.id = id;
		this.name = name;
		this.gpa = gpa;
	}

	@Override
	public void learn() {
		System.out.println("student learns");
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
