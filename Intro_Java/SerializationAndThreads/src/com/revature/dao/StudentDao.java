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
	 * Moving these CRUD methods to the package DAO
	 * 
	 * 		DAO is a type of design pattern
	 * 		Data access object
	 */
														//throws aka ducking
	public static void serializeStudent(Student stud) throws IOException {

		// Serialize student to a file
		FileOutputStream fos = new FileOutputStream(filePathAndName); // try with resources
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(stud);
		fos.close();
		oos.close();

	}

	public static Student deserializeStudent() {

		Student john = null;

		try (FileInputStream fis = new FileInputStream(filePathAndName);
				ObjectInputStream ois = new ObjectInputStream(fis)) {
			john = (Student) ois.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return john; // return null; is another way of saying TODO
	}
}
