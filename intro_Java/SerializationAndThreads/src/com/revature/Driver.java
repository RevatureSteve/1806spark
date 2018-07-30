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
	 * Serialization: Java objects to byte code
	 * Deseriallization: byte code to Java Objects
	 * 
	 * First note: All Java Objects are blacklisted, you cannot do serialization
	 * 		you must whitelist each individiual class so the object created from
	 * 		them are allowed to be serialized
	 * 
	 * 1. The class must implements Serializable (whitelist)
	 * 
	 * 		*Serializable is a "Marker Interface"
	 * 		Marker Interfaces tells the JVM something special
	 * 		Marker Interfaces have no methods!
	 * 	The something special about serializable is the whitelisting
	 * 
	 * 2. Add a serialVersionUID
	 * 
	 * What is the point of the serialVersionUID?
	 * 
	 * 	to match the version when deserializing
	 * 
	 * If the serial version UID doesn't match when deserializing, what happens?
	 * 		Throws an InvalidClassException
	 * 
	 * 3. Use the ObjectOutStream or ObjectInputStream  - classes available for converting java object to byte code
	 * 
	 * what is the transient keyword?
	 * during serialization, ignore the variables marked transient instead give them the default value of that datatype
	 * 
	 * 
	 */
	
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		
		
		
		while(true) {
			PresentationUtil.welcomeMenu(); //we know welcomeMenu() is static because PresentationUtil is capital
			int userInput =scan.nextInt();
			System.out.println("User entered: " + userInput);
		switch (userInput) {
		case 1:
			promptUserForNewStudentAndPersist();
			break;
		case 2:
			getStudentAndDisplay();
			break;

		case 3:
			System.out.println("exiting...");
			System.exit(1); //ends running the program
		
		}
		
	
		
		Student stud = PresentationUtil.creatingNewStudent();
		
		System.out.println("User Created " + stud);
		

		
		//Created the object from a class marked as serializable
		
		
//		serializeStudent(john, filePathAndName); //create of CRUD- create, read, update, delete
//		Student stud = deserializeStudent(filePathAndName);     //read of CRUD
		
		/*
		 * MOving crud methods to the package DAO
		 * 
		 * DAO is a type of design pattern
		 * Data Access Object
		 */
		
	}
	
	public static void promptUserForNewStudentAndPersist() {
		//first prompt user and retrieve input
		Student stud = PresentationUtil.creatingNewStudent();
		
		//persist Student to file
		try {
			StudentDao.serializeStudent(stud);
		} catch (IOException e) {
		PresentationUtil.errorView("File is corrupt")}
		}
	
		public static void getStudentAndDisplay() {
			//retrieve student from Dao (Data Access Object)
			Student stud = StudentDao.deserializeStudent();
			//probably should have ducked the exceptioins in the Student DAO and handled them with try catch
			
			PresentationUtil.presentStudent(stud);
		}
	}
	
	
	


