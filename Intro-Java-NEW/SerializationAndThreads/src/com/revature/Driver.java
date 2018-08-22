package com.revature;

import java.io.IOException;
import java.util.Scanner;

import com.revature.beans.Student;
import com.revature.dao.StudentDao;
import com.revature.presentation.PresentationUtil;

public class Driver {
<<<<<<< HEAD



		
	/*
	 * 	Serialization: Java Objects to byte code
	 * 	Deserialization: byte code to Java Objects
	 * 
	 * 	First note: All Java Objects are blacklisted, meaning you cannot do serialization
	 * 					You must whitelist each individual class so the object created from
	 * 					them are allowed to be serialized
	 * 
	 * 			*Serializable is a "Marker Interface"*
	 * 			Marker Interfaces tells the JVM something special
	 * 			Marker Interfaces have no methods!
	 * 			The something special about Serializable is the whitelisting
	 * 		1. The class must implements Serializable (whitelist)
	 * 		2. Add a serialVersionUID to the class (OPTIONAL but best practice)
	 * 		3. Use the ObjectOutStream or ObjectInputStream
=======
	

	
	/* 	IQ
	 * 	Serialization: Java Objects to byte code
	 * 	Deserialization: Byte code to Java Objects
	 * 
	 * 	1st note: All Java Objects are blacklisted, meaning you cannot do serialization
	 * 					you must whitelist each individual class so the object created from
	 * 					them are allowed to be serialized
	 * 
	 * 			*Serialzable is a "Marker Interface"
	 * 			Marker Interface tells the JVM something special
	 * 			Marker Interfaces have no methods
	 * 			The something special about Serialization is the whitelisting
	 * 		1. The class must implements Serializable (whitelist)
	 * 		2. Add a serialVersionUID to the class (OPTIONAL but best practice)
	 * 		3. Use the ObjectOutputStream or ObjectInputStream
>>>>>>> 4eb29dca203a33cdc98ed607180e8dc41eace9bf
	 * 
	 * 
	 * 		What is the point of the serialVersionUID?
	 * 			to match the version when deserializing
<<<<<<< HEAD
	 * 		If the serialVersionUID doesn't match when deserializing what happens?
	 * 			Throws an exception...but which one? InvalidClassException
	 * 
	 * 		What is the transient keyword?
	 * 			During serialization, ignore the variables marked transient instead give them
	 * 				the default value of that datatype	
	 * 			
	 */
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		while(true) {
			PresentationUtil.welcomeMenu(); //we know welcomeMenu() is static because PresentationUtil is capital
=======
	 * 		If the serialVersionUID doesn't match when deserializing, what happens?
	 * 			Throws an InvalidClassException (Unchecked Exception: not forced to catch an exception)
	 * 
	 * 		What is the transient keyword?
	 * 			During serialization, ignore the variables marked transient instead give them
	 * 				the default value of that datatype
	 */
	public static void main(String[] args) {
		
		Scanner scan = new Scanner (System.in);
		
		
		while(true) {
			PresentationUtil.welcomeMenu(); //	we know welcomeMenu() is static because PresentationUtil is capital
>>>>>>> 4eb29dca203a33cdc98ed607180e8dc41eace9bf
			int userInput = scan.nextInt();
			System.out.println("User entered: " + userInput);
			switch (userInput) {
			case 1:
				promptUserForNewStudentAndPersist();
				break;
			case 2:
				getStudentAndDisplay();
				break;
			case 3:
<<<<<<< HEAD
				System.out.println("exiting..");
				System.exit(1);
			}
			
		}
//		serializeStudent(john, ); // Create of CRUD
//		Student stud1 = StudentDao.deserializeStudent();	 // Read of CRUD
		
		
	}
	

	public static void promptUserForNewStudentAndPersist() {
		// First prompt user and retrieve input
		Student stud = PresentationUtil.creatingNewStudent();
		
		// Persist Student to file
=======
				System.out.println("Exiting...");
				System.exit(1);
			}
		}

		
//		System.out.println("User created: " + stud);
		
		
		
		//	Created the object from a class marked as Serializable
//		Student john = new Student(1, "John", 4.0);
		
//		serializeStudent(john, filePathAndName); //	Create of CRUD(Create, Read, Update, Delete)
//		Student stud1 = StudentDao.deserializeStudent();	//	Read of CRUD
		
//		System.out.println(stud);
	}
	
	public static void promptUserForNewStudentAndPersist() {
		//	1st prompt user and retrieve input
		Student stud = PresentationUtil.creatingNewStudent();
		
		//	persist student to file
>>>>>>> 4eb29dca203a33cdc98ed607180e8dc41eace9bf
		try {
			StudentDao.serializeStudent(stud);
		} catch (IOException e) {
			PresentationUtil.errorView("File is corrupt");
		}
<<<<<<< HEAD
		
	}
	
	
	public static void getStudentAndDisplay() {
		// retrieve student from StudentDAO (Data access object)
		Student stud = StudentDao.deserializeStudent();
			//Probably should of ducked the exceptions in the StudentDao and handled them here with try/catch
		
		PresentationUtil.presentStudent(stud);
	}
	
}







=======
	}
	
	public static void getStudentAndDisplay() {
		//	retrieve student from StudentDAO (Data access object)
		Student stud = StudentDao.deserializeStudent();
			//	Probably should of ducked the exceptions in the StudentDAO and handled them here with try/catch
		
		PresentationUtil.presentStudent(stud);
	}

}
>>>>>>> 4eb29dca203a33cdc98ed607180e8dc41eace9bf
