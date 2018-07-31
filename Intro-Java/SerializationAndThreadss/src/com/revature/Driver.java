package com.revature;

import java.io.IOException;
import java.util.Scanner;
import com.revature.beans.Student;
import com.revature.dao.StudentDao;
import com.revature.presentation.PresentationUtil;

public class Driver {

	
		/*
		 *  Serialization: Java objects to byte code
		 *  Deserialization: byte code to Java objects
		 * 
		 * First note: All Java objects are blacklisted, meaning you cannot do serialization on them.
		 * 					You must whitelist each individual class so the objects created from 
		 * 					them are allowed to be serialized.
		 * 
		 *  				* Serializable is a marker interface
		 * 					-Marker Interface tells the JVM something special (Whitelist it)
		 * 					Marker interfaces have no methods
		 * 					
		 *					- The something special about serializable is that it tells the JVM to whitelist it.
		 * 
		 * 
		 * 		1. The class must implement Serializable (whitelist);
		 * 
		 * 		2.Add a serialVersionUID (Optional, but Good practice)
		 * 
		 * 
		 * 		What is the point of the serialVersionUID?
		 * 			to match the version when deserializing
		 * 			If the serialVersionUID doesn't match when deserializing what happens?
		 * 		Throws an exception... but which one? InvalidClassException
		 *
		 */
	
	
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
	
		
		PresentationUtil.welcomeMenu();
		int userInput = scan.nextInt();
		System.out.println("User entered:" + userInput);
		
		
		switch (userInput) {
		
		
		case 1:
			promptUserForNewStudentAndPersist();
			break;
			
		case 2:
			getStudentAndDisplay();
			break;
			
		case 3:
				System.out.println("exiting...");
				System.exit(1);
		default:
			break;
		}
		
		
		
		
		
		
		
		
		Student stud = PresentationUtil.creatingNewStudent();
		
		System.out.println(stud);
		
		
		
		// Created the object from a classed marked as Serializable
		Student john = new Student(1, "john", 4.0);
	
		
		
		/*
		 * Moving these CRUD methods to the package DAO
		 * 
		 * DAO is a type of design pattern
		 * Data access object
		 */
		
		try {
			StudentDao.serializeStudent(john);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //Create of CRUD
//		Student stud1 = StudentDao.deserializeStudent(); // The Read of CRUD
		
//		System.out.println(stud);

	}
	
	
	
	public static void promptUserForNewStudentAndPersist() {
		// First prompt user and retrieve input
		Student stud = PresentationUtil.creatingNewStudent();
		
		//Persist Student
		try {
			StudentDao.serializeStudent(stud);
		} catch (IOException e) {
			PresentationUtil.errorView("File is corrupt");
		}
	}
	
	public static void getStudentAndDisplay() {
		Student stud = StudentDao.deserializeStudent();
		//probably should have used ducked the exception for the StudentDao
		PresentationUtil.presentStudent(stud);
	}
	
	

}
