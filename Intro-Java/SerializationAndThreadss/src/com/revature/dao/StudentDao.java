package com.revature.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.revature.beans.Student;

public class StudentDao {
	
	private static String filePathAndName = "src/com/revature/Person.txt";
	
	//Create a new static method
	
	public static void serializeStudent(Student stud) throws IOException{  //Bad to handle checked exception in DAO File
		
		//Serialize student to a file
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePathAndName));	
			oos.writeObject(stud);
			oos.close();

		
		
	}
	
	public static Student deserializeStudent() {
		
		Student john = null; //Outside block to make it local throughout the entire method
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePathAndName));) {
			
			
			john = (Student)ois.readObject();
			
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return john; //another way of saying TODO 
		
	}
	
	

}
