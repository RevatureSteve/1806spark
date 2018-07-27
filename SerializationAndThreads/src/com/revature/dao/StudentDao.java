package com.revature.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.revature.beans.Student;

public class StudentDao {
	
	private static final String filePathAndName = "src/com/revature/person.txt";
	/*
	 * moving these CRUD method to the package DAO
	 * 	DAO (Data Access Object) is a type of design pattern
	 */
													//this is known as shadowing
	public static void serializeStudent(Student stud) throws IOException {

		// serialiaze to student to a file				was added due to the shadowing
		FileOutputStream os = new FileOutputStream(filePathAndName);
		ObjectOutputStream oos = new ObjectOutputStream(os);
		oos.writeObject(stud);
		os.close();
/*		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Exception e2) {

		}*/
	}


	public static Student deserializeStudent() {
	
		Student john = null;
		try (FileInputStream is = new FileInputStream(filePathAndName);
				ObjectInputStream ois = new ObjectInputStream(is)) {
			
		john = (Student) ois.readObject();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		return john; 
		
	}
}



