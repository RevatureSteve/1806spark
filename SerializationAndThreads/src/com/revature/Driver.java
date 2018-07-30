package com.revature;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import com.revature.beans.student;
import com.revature.dao.StudentDao;
import com.revature.presentation.PresentationUtil;

public class Driver {

	
	/*
	 * Serialization: Java Objects to byte code
	 * Deserialization: byte code to Java Objects
	 * 
	 * 
	 * First node: All Java Objects are blacklisted, meaning you cannot do serialization
	 * 								you must whitelist each individual class so the object created from them
	 * 								are allowed to be serialized
	 * 
	 * 
	 *              *Serializable  is a marker Interface*
	 *				maker interfaces tells the JVM 	something special
	 *				maker interface have no methods
	 *				the something special about serializable is the white listing
	 * 		1. The class must implements Serializable(whitelist)
	 * 		2. Add a serialVersionUID
	 * 		3. Use the ObjectOutputStream of ObjectInputStrean
	 * 	
	 * 
	 * 	     
	 */ 			

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		//Create the object from a class marked as a Serializable 
		student john = new student(1, "John", 3.0, 723227645);
		
		while(true) {
			PresentationUtil.welcomeMenu(); //we know welcomeMenu() is a static because PresenttationUtil is capital
			int userInput = scan.nextInt();
			switch (userInput) {
			case 1:
				promptUserforNewStudentAndPersist();
				break;
			case 2:
				getStudentAndDisplay();
				break;
			case 3:
				System.out.println("exiting program....");
				System.exit(1);
				break;

			}
		}
		

    	//student stud1 = StudentDao.deserializeStudent();
	}
	
	public static void promptUserforNewStudentAndPersist() {
		//first prompt user and retrieve input
		student newStud = PresentationUtil.creatingNewStudent();
		System.out.println("User created: " + newStud);
		//Persist student to file
		try {
			StudentDao.serializeStudent(newStud);
		} catch (IOException e) {
			PresentationUtil.errorView("File is corrupt");
		}
	}
	public static void getStudentAndDisplay() {
		// retrieve student from StudentDao (Data access object)
		student stud = StudentDao.deserializeStudent();
		//Probably should of ducked the exceptions in the StudentDao and handled the here with try/catch
		
		PresentationUtil.presentStudent(stud);
	}

	
	/*
	 * moving the CRUD methods to the package DAO
	 * 
	 * 	DOA is a type of design pattern
	 * 	Data access object
	 */
	
	
	
}
