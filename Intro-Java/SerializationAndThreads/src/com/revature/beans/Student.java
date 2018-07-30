package com.revature.beans;

import java.io.Serializable;

import com.revature.abstracts.Teachable;

/*
 * 	Student class is not just a POJO
 * 	Student Class is a JavaBean - stricter version of a POJO
 * 
 * 		1. state must be fully encapsulated (private or protected)
 * 		2. provide getters and setters where needed
 * 		3. must have a no-args constructor
 * 		4. class must implements Serializable
 * 		5. override toString()
 * 
 */
public class Student implements Serializable, Teachable {
	
	/**
	 * 	Used to deserialize and match the correct version that was used when serialized
	 * 		(OPTIONAL but best practice)
	 */
	private static final long serialVersionUID = 101;
	
	private int id;
	private String name;
	private double gpa;
	private int ssn;
	/*
	 * 	transient keyword is ONLY used in serialization
	 * 		Ignore any state that is marked transient during serialization
	 */
	
	public Student() {}

	public Student(int id, String name, double gpa, int ssn) {
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
		return "Student [id=" + id + ", name=" + name + ", gpa=" + gpa + ", ssn=" + ssn + "]";
	}
	
	

}
