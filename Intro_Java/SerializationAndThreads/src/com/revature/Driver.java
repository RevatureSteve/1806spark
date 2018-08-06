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
	 * Serialization: Java Objects to byte code 
	 * Deserialization: Byte code to Java Objects
	 * 
	 * First node: All Java Objects are blacklisted, meaning you cannot do
	 * serialization You must whitelist each individual class so the object created
	 * from them are allowed to be serialized
	 * 
	 * *Serializable is a "Marker Interface" Marker Interfaces tells the JVM
	 * something special Marker Interfaces have no methods The something special
	 * about Serializable is the whitelisting
	 * 
	 * 1. The class must implements Serializable (whitelist) 
	 * 2. Add a serialVersionUID (OPTIONAL but best practice)
	 * 3. Use the ObjectOutStream or ObjectInputStream
	 * 
	 * What is the point of the serialVersionUID?
	 * 		To match the version when deserializing.
	 * If the serialVersionUID doesn't match when deserializing what happens?
	 * 		Throws an exception...but which one? InvalidClassException.
	 * What is the transient keyword?
	 * 		During serialization, ignore the variables marked transient instead 
	 * 		give them the default value of that datatype.
	 */

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		while(true) {		
		PresentationUtil.welcomeMenu(); //we know welcomeMenu() is static because PresentationUtil is capital
		
		int userInput = scan.nextInt();
		System.out.println("User entered: " + userInput);		

		switch(userInput) {
		case 1:
			promptUserForNewStudentAndPersist(); 
			break;
		case 2:
			getStudentAndDisplay();
			break;
		case 3:
			System.out.println("Exiting...");
		System.exit(1);
			}
		}

//		serializeStudent(john); // Create of CRUD
//		Student stud1 = StudentDao.deserializeStudent(); // Read of CRUD
		
//		System.out.println(stud);

	}
	
	public static void promptUserForNewStudentAndPersist() {
		//First prompt user and retrieve input
		Student stud = PresentationUtil.creatingNewStudent();
		
		//Persist Student to file
		try {
			StudentDao.serializeStudent(stud);
		} catch (IOException e) {
			PresentationUtil.errorView("File is corrupt");
		}
	}
	
	public static void getStudentAndDisplay() {
		//retrieve student from StudentDao (Data access object)
		Student stud = StudentDao.deserializeStudent();
		//Probably should of ducked the exceptions in the StudentDao and handled them here with try/catch
		PresentationUtil.presentStudent(stud);
	}

}
