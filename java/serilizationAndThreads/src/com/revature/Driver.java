package com.revature;

import java.util.Scanner;

import com.revature.beans.Student;
import com.revature.doa.StudenDoa;
import com.revature.presentation.PresentationUtil;

public class Driver {
	/// moved to doa
//	 private static final String filePathAndName = "src/com/revature/person.txt";
//	
	/*
	 * serialization : java object to bytes code 
	 * 
	 * deserialization  : byte code to java object
	 * 
	 * firstnote: all java Objects are blacklisted, meaning you cannot do serialization
	 * 					you must whitelist each individual class so the object created from 
	 * 					them to allowed to be serialized
	 * 
	 * 	1. the class must be implement s serialization(whitelist)
	 * 
	 * 	 ITV:	*serializable is a "Marker Interface"
	 * 				Marker Interface tells the JVM something special
	 * 				Marker Interfaces have no methods!
	 * 			1. The something special about serializable is the whitelisting
	 * 			2. Add serialVersionUID
	 * 
	 * itv   what is the point of the serialVersionUId?
	 *      		 to match the version when deserializing 
	 *      if the serialVersionUID doesnt match when deserializing what happen?
	 *         throws an exception.. but which one? .. InvalidClassexception
	 *         
	 *         /*
	 *         
	 *         
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
   PresentationUtil.Welcome(); // we know welcome() is static because PresentationUtil is capital
		int userInput = scan.nextInt();
		System.out.println("User enter: " +userInput);
		
//		Student stud1 = deserializeStudent();    // read CRUD
		
		//created the object from calss market as serializable
//		Student john = new Student(1, "John", 4.0);
//		
//		//serializeStudent(john, filePathAndName);  //create a CRUD
//		Student stud = deserializeStudent(filePathAndName);    // read CRUD
		
	//	System.out.println(stud);
	}

	private static Student deserializeStudent() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void promptUserForNewStudentAndPersist() {
		//1st prompt user and retrieve input
		Student stud = PresentationUtil.creatingNewStudent();
		
		//persist Student to file
//		StudenDoa.serializeStudent();
		
	}
	
	///moved to studentDoa
//	//////////////////////////////////////////////////////////////////////////////////
//	public static Student deserializeStudent(String filePathAndName) {
//		
//		Student john = null; // declaring outside of the try catch block to get bigger local scope
//		try (FileInputStream is = new FileInputStream(filePathAndName);
//				ObjectInputStream ois = new ObjectInputStream(is)){
//			
//				 john = (Student) ois.readObject();
//		}
//			
//			
//		 catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}  catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return john;
//		
//	}
//
////	private static  deserializeStudent(String filePathAndName) {
////		// TODO Auto-generated method stub
////		return null;
////		
////	}
//	
//							//this was for serialization
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//	public static void serializeStudent(Student stud, String filePathAndName) {
//		// serialize to student to a file
//		
//	  try (FileOutputStream os = new FileOutputStream(filePathAndName);
//			  // another out put stream that is faster
//			  ObjectOutputStream oos = new ObjectOutputStream(os);) {
//		  oos.writeObject(stud);
//		
//	} catch (FileNotFoundException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	} catch (IOException e1) {
//		// TODO Auto-generated catch block
//		e1.printStackTrace();
//	}
//	  catch (Exception e2) {
//		  
//	  }
//		
//	}
	
}
