package com.revature.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.revature.beans.Student;

public class StudentDao {
	
	private static final String filePathAndName = "src/com/revature/person.txt"; // static so it belongs to the class and i do not need an object
	
	/*
     * moving these CRUD methods to the package DAO
     * 
     *    DAO is a type of design pattern
     *    Data access object
     */
	                                                    // throws aka ducking
	 public static void serializeStudent(Student stud) throws IOException {
		 
	    	// Serialize student to a file
	    	FileOutputStream os = new FileOutputStream(filePathAndName);
	    			ObjectOutputStream oos = new ObjectOutputStream(os); 
	    		    oos.writeObject(stud);
	    		    oos.close();
	    		    
	    	}
	
	    
	    public static Student deserializeStudent() {
	    	
	   	 Student john = null; // declare john outside of the try block to get a bigger local scope 
	   	try (FileInputStream is = new FileInputStream(filePathAndName);
	   			ObjectInputStream ois = new ObjectInputStream(is)) {
	   		
	   	   john = (Student) ois.readObject(); // reassigning john
	   		
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


