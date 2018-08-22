package com.revature.beans;

import java.io.Serializable;

import com.revature.abstracts.Teachable;

/*
<<<<<<< HEAD
 * Student Class is not just a POJO
 * Student Class is a JavaBean - stricter version of a POJO
 * 
 * 		1. state must be fully encapsulated
 * 		2. provide getters and setter where needed
 * 		3. must have a no-args constructor 
=======
 * 	Student class is not just a POJO
 * 	Student Class is a JavaBean - stricter version of a POJO
 * 
 * 		1. state must be fully encapsulated (private or protected)
 * 		2. provide getters and setters where needed
 * 		3. must have a no-args constructor
>>>>>>> 4eb29dca203a33cdc98ed607180e8dc41eace9bf
 * 		4. class must implements Serializable
 * 		5. override toString()
 * 
 */
<<<<<<< HEAD
/**
 * @author Steve Work PC
 *
 */
public class Student implements Serializable, Teachable {
	
	/**
	 * 	Used to deserialize and match the correct version that was used when serializing
	 * 		(OPTIONAL but best practice)
	 */
	private static final long serialVersionUID = 102;
=======
public class Student implements Serializable, Teachable {
	
	/**
	 * 	Used to deserialize and match the correct version that was used when serialized
	 * 		(OPTIONAL but best practice)
	 */
	private static final long serialVersionUID = 101;
>>>>>>> 4eb29dca203a33cdc98ed607180e8dc41eace9bf
	
	private int id;
	private String name;
	private double gpa;
<<<<<<< HEAD
	private transient int ssn;
	/*
	 *  transient keyword is only used in serialization
	 *  	Ignore any state that is marked transient during serialiaztion
	 */
	
	
	public Student() {}
	
	public Student(int id, String name, double gpa) {
		super();
		this.id = id;
		this.name = name;
		this.gpa = gpa;
	}

	// alt + shift + s then r for generating getters and setters
=======
	private int ssn;
	/*
	 * 	transient keyword is ONLY used in serialization
	 * 		Ignore any state that is marked transient during serialization
	 */
	
	public Student() {}
>>>>>>> 4eb29dca203a33cdc98ed607180e8dc41eace9bf

	public Student(int id, String name, double gpa, int ssn) {
		super();
		this.id = id;
		this.name = name;
		this.gpa = gpa;
		this.ssn = ssn;
	}

<<<<<<< HEAD
	@Override
	public void learn() {
		System.out.println("Student learns");
	}

=======

	@Override
	public void learn() {
		System.out.println("Student learns");
		
	}


>>>>>>> 4eb29dca203a33cdc98ed607180e8dc41eace9bf
	public int getId() {
		return id;
	}

<<<<<<< HEAD
=======

>>>>>>> 4eb29dca203a33cdc98ed607180e8dc41eace9bf
	public void setId(int id) {
		this.id = id;
	}

<<<<<<< HEAD
=======

>>>>>>> 4eb29dca203a33cdc98ed607180e8dc41eace9bf
	public String getName() {
		return name;
	}

<<<<<<< HEAD
=======

>>>>>>> 4eb29dca203a33cdc98ed607180e8dc41eace9bf
	public void setName(String name) {
		this.name = name;
	}

<<<<<<< HEAD
=======

>>>>>>> 4eb29dca203a33cdc98ed607180e8dc41eace9bf
	public double getGpa() {
		return gpa;
	}

<<<<<<< HEAD
=======

>>>>>>> 4eb29dca203a33cdc98ed607180e8dc41eace9bf
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

<<<<<<< HEAD
	public int getSsn() {
		return ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}
=======
>>>>>>> 4eb29dca203a33cdc98ed607180e8dc41eace9bf

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", gpa=" + gpa + ", ssn=" + ssn + "]";
	}
<<<<<<< HEAD


	
	
=======
	
	

>>>>>>> 4eb29dca203a33cdc98ed607180e8dc41eace9bf
}
