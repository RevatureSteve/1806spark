package com.revature.beans;

import java.io.Serializable;

import com.revature.abstracts.Teachable;

/*
 * Student class is not just a POJO
 * Student Class is a JavaBean- a stricter version of a POJO
 * 
 * 	1. State must be fully encapsulated
 *  2. Provide Getters and setter where needed
 *  3. must have a no-args constructor
 *  4. class must implements Serializable
 *  5. override toString()
 *  
 *  
 */

public class Student implements Serializable, Teachable {
	
	/**
	 *  Used to deserialize and match the correct version that was used when serializing
	 *  (OPTIONAL/best practice)
	 */
	private static final long serialVersionUID = 101;
	
	private int id;
	private String name;
	private double gpa;
	private transient int ssn;
	
	/*
	 * transient keyword is only used in serialization
	 * ignore any state that is marked transient during serialization
	 * -it will default to the least value null for string, 0 fir int
	 * 
	 * ** all objects default value is null**
	 */
	
	public Student(String studName, double studGpa, int studSsn) {}
	
	public Student(int age, String studName, double studGpa, int studSsn) {}
	
	
	public Student(int id, String name, double gpa) {
		super();
		this.id = id;
		this.name = name;
		this.gpa = gpa;
	}



	@Override
	public void learn() {
	System.out.println("Student Learns");
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
	
	
