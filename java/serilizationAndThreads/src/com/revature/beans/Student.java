package com.revature.beans;

import java.io.Serializable;

/*
 * students in not just a POJO
 * STUDENT CLASS IS A JAVABEAN - stricter version of s pojo
 * 
 * 			1. state must be fully encapsulated 
 * 			2. provide getters and setter where needed (when you made it read only)
 * 			3. must have a no-args constructor 
 * 			4. class must be implements serializable 
 * 			5. override toString()
 */

public class Student implements Serializable {
	/**
	 *  used to deserialized and match the correct version when used when serializing
	 *  		(optional: not required to provide but it is best practice to...)
	 */
	private static final long serialVersionUID = 102;
	private int id;
	private String name;
	private double gpa;
	private transient int ssn;
	/*
	 * transient is a keyword used in serialization
	 * 		ignore any state that is marked transient during serialization  
	 */
	
	// alt + shift + s then r generating getters and setters 
	//auto generated after Student stud = new Student(55,studName,studGpa,studSsn);}
	public Student(int i, String string, double d, int studSsn) {}

	public Student(int i, String string, double d) {
		// TODO Auto-generated constructor stub
		
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

//	// below is a generated constructor using  toString field
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", gpa=" + gpa + "]";
	}
	
//	// below is a generated constructor using  fields
//
//	public Student(int id, String name, double gpa) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.gpa = gpa;
//	
//	
//	} 
	
	

}
