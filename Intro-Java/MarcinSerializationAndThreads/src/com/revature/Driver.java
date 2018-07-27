package com.revature;

import java.io.IOException;
import java.util.Scanner;

import com.revature.beans.Student;
import com.revature.dao.StudentDao;
import com.revature.presentations.PresentationUtil;

public class Driver {

	

	/*
	 * serialization: Java Objects to byte code deserialization: byte code to Java
	 * Objects
	 * 
	 * First note: all Java Objects are blacklisted, meaning you cannot serialize
	 * You must whitelist all individual class so the object created from them are
	 * allowed to be serialized
	 *
	 * Serializable is a "Marker Interface" Marker Interfaces tells the JVM
	 * something special Marker Interfaces have no methods The something special
	 * about Serializable is the whitelisting Class must implement Serializable
	 * (whitelist) Add a serialVersionUID
	 * 
	 * What is the point of the serial version UID to match the version when
	 * deserializing If the serialVersionUID doesm't match when deserializing what
	 * happens? Throws an exception... InvalidClassException
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		PresentationUtil.welcomeMenu();

		int input = scan.nextInt();
		System.out.println("User input: " + input);

		if (input == 1) {
			promptUserAndPersist();
		} else if (input == 2) {
			getStudentAndDisplay();
		} else if (input == 3) {
			scan.close();
			return;
		}

		scan.close();
	}
	
	public static void promptUserAndPersist() {
		Student stud = PresentationUtil.creatingNewStudent();
		
		try {
			StudentDao.serializeStudent(stud);
		} catch (IOException e) {
			System.out.println("File is corrupt");
		}
		
	}
	
	public static void getStudentAndDisplay() {
		Student stud = null;
		try {
			stud = StudentDao.deserializeStudent();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PresentationUtil.presentStudent(stud);
	}
}
