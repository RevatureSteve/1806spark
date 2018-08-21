package com.revature.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.revature.beans.Student;

public class StudentDao {
	private static String filePathAndName = "src/com/revature/person.txt";
	/*
	 * moving these CRUD methods to the package DAO
	 * 
	 * DAO is a type of design
	 * DAO is in it's own package
	 * Data Access Object
	 */
	public static void serializeStudent(Student stud) {

		try (FileOutputStream os = new FileOutputStream(filePathAndName);
				ObjectOutputStream oos = new ObjectOutputStream(os)) {
			oos.writeObject(stud);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Exception e2) {

		}
	}

	public static Student deserializeStudent() {
		Student stud = null;
		try (FileInputStream is = new FileInputStream(filePathAndName);
				ObjectInputStream ois = new ObjectInputStream(is);) {
			stud = (Student) ois.readObject();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stud;
	}
}
