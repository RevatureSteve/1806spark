package com.revature.beans;

import java.io.Serializable;

import com.revature.abstracts.Teachable;

/*
<<<<<<< HEAD
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
	
=======
 * Student Class is not just a POJO
 * Student Class is a JavaBean - stricter version of a POJO
 * 
 * 		1. state must be fully encapsulated
 * 		2. provide getters and setter where needed
 * 		3. must have a no-args constructor 
 * 		4. class must implements Serializable
 * 		5. override toString()
 * 
 */
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
	
	private int id;
	private String name;
	private double gpa;
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
>>>>>>> 8ff4b17dd674ea7826c6e1af98f02d7fae8acae8

	public Student(int id, String name, double gpa, int ssn) {
		super();
		this.id = id;
		this.name = name;
		this.gpa = gpa;
		this.ssn = ssn;
	}

<<<<<<< HEAD

=======
	@Override
	public void learn() {
		System.out.println("Student learns");
	}
>>>>>>> 8ff4b17dd674ea7826c6e1af98f02d7fae8acae8

	public int getId() {
		return id;
	}

<<<<<<< HEAD


=======
>>>>>>> 8ff4b17dd674ea7826c6e1af98f02d7fae8acae8
	public void setId(int id) {
		this.id = id;
	}

<<<<<<< HEAD


=======
>>>>>>> 8ff4b17dd674ea7826c6e1af98f02d7fae8acae8
	public String getName() {
		return name;
	}

<<<<<<< HEAD


=======
>>>>>>> 8ff4b17dd674ea7826c6e1af98f02d7fae8acae8
	public void setName(String name) {
		this.name = name;
	}

<<<<<<< HEAD


=======
>>>>>>> 8ff4b17dd674ea7826c6e1af98f02d7fae8acae8
	public double getGpa() {
		return gpa;
	}

<<<<<<< HEAD


=======
>>>>>>> 8ff4b17dd674ea7826c6e1af98f02d7fae8acae8
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

<<<<<<< HEAD


=======
>>>>>>> 8ff4b17dd674ea7826c6e1af98f02d7fae8acae8
	public int getSsn() {
		return ssn;
	}

<<<<<<< HEAD

=======
>>>>>>> 8ff4b17dd674ea7826c6e1af98f02d7fae8acae8
	public void setSsn(int ssn) {
		this.ssn = ssn;
	}

<<<<<<< HEAD

	@Override
	public void learn() {
		// TODO Auto-generated method stub
		System.out.println("Student");
	}


=======
>>>>>>> 8ff4b17dd674ea7826c6e1af98f02d7fae8acae8
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", gpa=" + gpa + ", ssn=" + ssn + "]";
	}


	
<<<<<<< HEAD

=======
	
>>>>>>> 8ff4b17dd674ea7826c6e1af98f02d7fae8acae8
}
