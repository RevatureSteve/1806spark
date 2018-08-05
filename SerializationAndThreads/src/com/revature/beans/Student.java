package com.revature.beans;

import java.io.Serializable;

import com.revature.abstracts.Teachable;

/*
 *  Student Class is not just a POJO
 *  Student Class is a JavaBean - stricter version of a POJO
 *  
 *  				These are required for a JavaBean
 *  		1. state must be fully encapsulated - private/protected - restricting access
 *  		2. provide getters and setter where needed (sometimes you want only readonly)
 *  		3. must have a no-args constructor
 *  		4. class must implements Serializable
 *  		5. override toString()
 *  
 */
public class Student implements Serializable, Teachable{
	
	/**
	 *  Used to desrialize and match the correct version that was used when serializing
	 *  	(OPTIONAL but best practice)
	 */
	private static final long serialVersionUID = 101; //-7099763929840869400L;
	private int id;
	private String name;
	private double gpa;
	private transient int ssn; // ssn will default to 0 all object default values are null
	/*
	 *  transient keyword is only used in serialization*
	 *  	Ignore any state that is marked transient during serialization
	 *  
	 */
	
	public Student() {}
	

	public Student(int id, String name, double gpa, int ssn) {
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



	public int getSsn() {
		return ssn;
	}


	public void setSsn(int ssn) {
		this.ssn = ssn;
	}


	@Override
	public void learn() {
		// TODO Auto-generated method stub
		System.out.println("Student");
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", gpa=" + gpa + ", ssn=" + ssn + "]";
	}


	

}
