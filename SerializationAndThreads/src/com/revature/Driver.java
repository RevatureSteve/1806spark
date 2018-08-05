package com.revature;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import com.revature.beans.Student;
import com.revature.dao.StudentDao;
import com.revature.presentation.PresentationUtil;

public class Driver {
	
	
	/*
	 *   Serialization: Java Objects converted to byte code
	 *   Deserialization: byte code converted to Java Objects
	 *   
	 *   First note: All Java Objects are blacklisted, meaning you cannot do serialization
	 *   				You must whitelist each individual class so the object created from them
	 *   				are allowed to be serialized
	 *   
	 *   
	 *   			*Serializable is a "Marker Interface"*
	 *   			Marker Interfaces tells the JVM something special
	 *   			Marker Interfaces have no methods!
	 *   			The something special about Serializable is the whitelisting
	 *   			Cannot Serialize something that's not Serializable
	 *   	
	 *   1. The class must implement Serializable (whitelist)
	 *   2. Add a serialVersionUID
	 *   3. Use the ObjectOutputStream or ObjectInputStream
	 *   
	 *   What is the point of the serialVersionUID?
	 *   	to match the version when desrializing
	 *   If the serialVersionUID doesn't match when deserializing what happens?
	 *   	Throws an exception... but which one?  InvalidClassException
	 *   
	 *   
	 *   What is the transient keyword?
	 *   	during serialization, ignore the variables marked transient instead give them 
	 *   		the default value of that datatype
	 *   
	 */
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		
		
		while(true) {
			
			PresentationUtil.welcomeMenu(); // we know wemcomeMenu() is static because PresentationUtil is capital
			
			int userInput = scan.nextInt();
			System.out.println("User enter: " + userInput);
		
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
		}
		
		
	}
		
//		System.out.println("User created: " + stud);
		
		
		
		// Created the object from a class marked as Serializable
//		Student john = new Student(1, "John", 4.0);
		
//		serializeStudent(john, filePathAndName); // Create of CRUD
//		Student stud1 = StudentDao.deserializeStudent(); // Read of CRUD
		
	}
	
	public static void promptUserForNewStudentAndPersist() {
		// First prompt the user and retrieve input
		Student stud = PresentationUtil.creatingNewStudent();
		
		// Persist Student to file
		try {
			StudentDao.serializeStudent(stud);
		} catch (IOException e) {
			PresentationUtil.errorView("File is corrupt");
		}
	}

	public static void getStudentAndDisplay() {
		// retrieve student from StudentDAO (Data access object)
		Student stud = StudentDao.deserializeStudent();
		
			// Probably should have ducked the exceptions in the StudentDao and handled them here with try/catch
		PresentationUtil.presentStudent(stud);
	}
}


