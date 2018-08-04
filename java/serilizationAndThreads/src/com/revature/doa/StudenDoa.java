package com.revature.doa;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.revature.beans.Student;

public class StudenDoa {
	
	 private static final String filePathAndName = "src/com/revature/person.txt";
	
	public static Student deserializeStudent(String filePathAndName) {
		
		Student john = null; // declaring outside of the try catch block to get bigger local scope
		try (FileInputStream is = new FileInputStream(filePathAndName);
				ObjectInputStream ois = new ObjectInputStream(is)){
			
				 john = (Student) ois.readObject();
		}
			
			
		 catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return john;
		
	}

//	private static  deserializeStudent(String filePathAndName) {
//		// TODO Auto-generated method stub
//		return null;
//		
//	}
	
							//this was for serialization
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void serializeStudent(Student stud, String filePathAndName) {
		// serialize to student to a file
		
	  try (FileOutputStream os = new FileOutputStream(filePathAndName);
			  // another out put stream that is faster
			  ObjectOutputStream oos = new ObjectOutputStream(os);) {
		  oos.writeObject(stud);
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	  catch (Exception e2) {
		  
	  }
		
	}

}
