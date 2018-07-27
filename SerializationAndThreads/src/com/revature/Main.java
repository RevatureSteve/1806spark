package com.revature;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.omg.CORBA.ExceptionList;

import com.revature.beans.Student;

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
	 * something special marker interfaces have no methods!! 1. the class must
	 * implement Serializable (whitelist) 2. add a SerialVersionUID
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
		System.out.println("test");

		String filePathAndName = "src/com/revature/person.txt";

		// create the object from a class marked as Serializable
		Student john = new Student(1, "John", 4.0);

		serializeStudent(john, filePathAndName);
		Student stud = deserializeStudent(filePathAndName);
		
		System.out.println(stud);

	}



	public static void serializeStudent(Student stud, String filePathAndName) {



		// serialiaze to student to a file
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


	public static Student deserializeStudent(String filePathAndName) {
	
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
