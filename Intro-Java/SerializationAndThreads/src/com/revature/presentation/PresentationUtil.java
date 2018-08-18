package com.revature.presentation;

import java.util.Scanner;

import com.revature.beans.Student;

public class PresentationUtil {

	/*
<<<<<<< HEAD
	 * useful class that will hold views or presentation logic
	 * 
	 */

	
	/*
	 * welcomeMenu is static which means we will access it in another class
	 * 	by ClassName.methodName or if variable ClassName.variableName
	 * 		PresentationUtil.welcomeMenu()
	 * 	Never manipulate the input in presentation logic
	 */
	
=======
	 * 	Useful class that will hold views or presentation logic
	 * 
	 */
	
	
	/*
	 *  welcomeMenu is static which means we will access it in another class 
	 *  	by ClassName.methodName() or if variable ClassName.variableName
	 *  	   PresentationUtil.welcomeMenu()
	 */
>>>>>>> 8ff4b17dd674ea7826c6e1af98f02d7fae8acae8
	public static void welcomeMenu() {
		System.out.println("Welcome please select from the list below: ");
		System.out.println("Enter 1 for creating a new Student");
		System.out.println("Enter 2 for reading the current student");
		System.out.println("Enter 3 to exit");
<<<<<<< HEAD

	}
	
=======
	}
	
	
>>>>>>> 8ff4b17dd674ea7826c6e1af98f02d7fae8acae8
	public static Student creatingNewStudent() {
		Scanner scan = new Scanner(System.in);
		System.out.println("-----New Student-----");
		System.out.println("Enter Student Name: ");
		String studName = scan.nextLine();
		System.out.println("Enter GPA: ");
		double studGpa = scan.nextDouble();
		System.out.println("Enter SSN: ");
		int studSsn = scan.nextInt();
		
<<<<<<< HEAD
		Student stud = new Student(55, studName, studGpa, studSsn);
		//scan.close();
=======
		Student stud = new Student(55,studName, studGpa, studSsn);
>>>>>>> 8ff4b17dd674ea7826c6e1af98f02d7fae8acae8
		return stud;
	}
	
	public static void presentStudent(Student stud) {
		System.out.println("-----Current Student-----");
		System.out.println(stud);
	}
	
<<<<<<< HEAD
=======
	
>>>>>>> 8ff4b17dd674ea7826c6e1af98f02d7fae8acae8
	public static void errorView(String message) {
		System.out.println("Sorry something went wrong...");
		System.out.println(message);
	}
<<<<<<< HEAD
=======
	
>>>>>>> 8ff4b17dd674ea7826c6e1af98f02d7fae8acae8
}
