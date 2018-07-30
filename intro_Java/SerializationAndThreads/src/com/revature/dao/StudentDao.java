package com.revature.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.revature.beans.Student;

public class StudentDao {

	 private static final String filePathAndName = "src/com/revature/persons.txt";
	
	public static void serializeStudent(Student stud) throws FileNotFoundException, IOException {
		//serialize to student to a file

		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePathAndName));){
			oos.writeObject(stud);
			oos.close();
					
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} catch (Exception e2) {
//		
		}
		
	}
		public static Student deserializeStudent() {
			
			Student john = null;
			
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePathAndName));) {
				
				john = (Student) ois.readObject();
				
				
			}catch (IOException e1) {
				e1.printStackTrace();
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			return john;
		}
}
