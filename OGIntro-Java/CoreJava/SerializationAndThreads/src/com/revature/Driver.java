package com.revature;

import java.io.IOException;
import java.util.Scanner;

import com.revature.beans.Student;
import com.revature.dao.StudentDao;
import com.revature.presentation.PresentationUtil;

public class Driver {
	
	
	/*
	 * 				INTERVIEW MATERIAL!!!!!!!!!!!!!!!!!!
	 * Serialization: Java Objects to byte code
	 * Deserialization: byte code to Java Objects
	 * 
	 * First note: All Java Objects are blacklisted, meaning you cannot do serialization
	 * 					You must whitelist each individual class so the object created from
	 * 					them are allowed to be serialized
	 * 
	 * *Serializable is a "Marker Interface"*
	 * 			Marker Interfaces tell the JVM something special
	 * 			Marker Interfaces have no methods!
	 * 			The something special about Serializable is the whitelisting
	 * 
	 * 		1. The Class must implement Serializable (whitelist)
	 * 		2. Add a serialVersionUID (OPTIONAL but best practice
	 * 		3. Use the ObjectOutStream or ObjectInputStream
	 * 		
	 * 
	 * 		
	 * 		What is the point of the serialVersionUID?
	 * 			to match the version when deserializing
	 * 		If the serialVersionUID doesn't match when deserializing what happens?
	 * 			Throws an exception... but which one? InvalidClassException
	 * 			NOT CHECKED, UNCHECKED EXCEPTION
	 * 			
	 */
					
	
	
	public static void main(String[] args) {
		
		
		Scanner scan = new Scanner(System.in);
		
		PresentationUtil.welcomeMenu(); // we know welcomeMenu() is static because PresentationUtil is capital
		int userInput = scan.nextInt();
		System.out.println("User entered:" + userInput);
		
		switch(userInput) {
		case 1:
			promptUserForNewStudentAndPersist();
			
			break;
		
		case 2:
			
			break;
			
		case 3:
			System.out.println("exiting");
			System.exit(1);
			
		}
		
		Student stud1 = PresentationUtil.creatingNewStudent();
		
		System.out.println("User created" + stud1);

		
		
		//serializeStudent(john, filePathAndName); //Create of CRUD: Create Read Update Delete
		Student stud = StudentDao.deserializeStudent();	// Read of CRUD
		
	
	
	}
	
	public static void promptUserForNewStudentAndPersist() { 
		//first prompt user and retrieve input
		Student stud = PresentationUtil.creatingNewStudent();
		
		//Persist student to file
		try {
		StudentDao.serializeStudent(stud);
		}catch (IOException e) {
			PresentationUtil.errorView("File is corrupt");
		}
	}
	
	
	
}
