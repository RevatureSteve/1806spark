package com.revature;

import java.io.IOException;
import java.util.Scanner;

import com.revature.beans.Student;
import com.revature.dao.StudentDao;
import com.revature.presentation.PresentationUtil;

public class Main {

	/*
	 * Serialization: Java Objects to byte code Deserialization: byte code to Java
	 * Objects
	 * 
	 * first note: All java objects are blacklisted, meaning you cannot do
	 * serialization you must whitelist each individual class so the object created
	 * from them are allowed to be serialized
	 * 
	 * *serializable is a "Marker Interface" marker interfaces tells the JVM
	 * something special marker interfaces have no methods!! 
	 * 1. the class must implement Serializable (whitelist) 
	 * 2. add a SerialVersionUID
	 * 
	 * 	what is the point of the serialVersionUID? 
	 * 		to match the version when deserializing
	 * 
	 * if the serialVersionUID doesn't match when deserializing, what happens?
	 * 		throws and exception is an ok answer. . but which one? 
	 * 			InvalidClassException
	 * 
	 */
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			PresentationUtil.WelcomeMenu();//we know welcomeMenu() is static b/c PresentationUtil is capital
			int userInput = scan.nextInt();
			System.out.println("User entered " + userInput);
			
			switch (userInput) {
			case 1:
				promptUserForNewStudentAndPersist();
				break;
	
			case 2:
				getStudentAndDisplay();
				break;
			
			case 3:
				System.out.println("exiting");
				System.exit(1);
			}
			
			
		}
		//Student stud = PresentationUtil.creatingNewStudent();
		//System.out.println("User created: " + stud);
		

		// create the object from a class marked as Serializable
		//Student john = new Student(1, "John", 4.0);

		//serializeStudent(john, filePathAndName); //create of CRUD
		//Student stud1 = StudentDao.deserializeStudent(); //read of CRUD
		
		//System.out.println(stud);

	}
	
	public static void promptUserForNewStudentAndPersist( ) {
		//first prompt user and retrieve input
		Student stud = PresentationUtil.creatingNewStudent();
		
		//persist student to file
		try {
			StudentDao.serializeStudent(stud);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			PresentationUtil.errorView("error");
			
		}
		
		
	}
	
	public static void getStudentAndDisplay() {
		//retrieve student from StudentDao 
		Student stud = StudentDao.deserializeStudent();
			//probably should of ducked the exceptions in the StudentDao and handled them here w/ try/catch
		PresentationUtil.presentStudent(stud);
		
	}
}

