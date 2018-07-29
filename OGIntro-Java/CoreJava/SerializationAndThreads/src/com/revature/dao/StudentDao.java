package com.revature.dao;

import com.revature.beans.Student;

public class StudentDao {

	private static final String filePathAndName = "src/com/revature/person.txt";


	/*
	 * moving these CRUD methods to the package DAO
	 * 
	 * 		DAO is a type of design pattern
	 * 		Data access object
	 */
	
	
										// throws aka ducks
	public static void serializeStudent(Student stud) {
		
		
		
		//Serialize student to a file 
		try (FileOutputStream os = new FileOutputStream(filePathAndName);
				ObjectOutputStream oos = new ObjectOutputStream(os);
				oos.writeObject(stud);
				os.close();
				oos.close();
				
			
		}
		public static Student deserializeStudent() {
			
		}
}
