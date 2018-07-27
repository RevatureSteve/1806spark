package com.revature.presentations;

import java.util.Scanner;

import com.revature.beans.Student;

public class PresentationUtil {
	public static void welcomeMenu() {
		System.out.println("Welcome please select from the list below: ");
		System.out.println("Enter 1 for creating new Student entry");
		System.out.println("Enter 2 for accessing current student");
		System.out.println("Enter 3 to exit");
	}
	
	public static Student creatingNewStudent() {
		Scanner scan = new Scanner(System.in);
		System.out.println("-------New Student-------");
		System.out.println("Enter Student Name: ");
		String studName = scan.nextLine();
		System.out.println("Enter GPA: ");
		double studGPA = scan.nextDouble();
		System.out.println("Enter ID: ");
		int studID = scan.nextInt();
		
		scan.close();
		return new Student(studID, studName, studGPA);
	}
	
	public static void presentStudent(Student stud) {
		System.out.println("-------New Student-------");
		System.out.println(stud);
	}
}
