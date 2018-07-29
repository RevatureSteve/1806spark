package com.revature.beans;

import java.io.Serializable;

import com.revature.abstracts.Teachable;

/*
 * Student Class is not just a POJO
 * Student Class is a JavaBean - stricter version of a POJO
 * 
 * 		1. state must be fully encapsulated
 * 		2. provide getters and setters where needed
 * 		3. must have a no-args constructor
 * 		4. class must implement Serializable
 * 		5. override toString()
 */



public class Student implements Serializable, Teachable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 101;
	
	private int id;
	private String name;
	private double gpa;
	
	public Student() {}
	
	// alt + shift + s then r for generating getters and setters (not mac)
	// mac: alt + command + s
	
	public Student(int id, String name, double gpa, int studSsn) {
		super();
		this.id = id;
		this.name = name;
		this.gpa = gpa;
	}

	@Override
	public void learn() {
		// TODO Auto-generated method stub
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
		return "Student [id=" + id + ", name=" + name + ", gpa=" + gpa + "]";
	}
	
	

}
