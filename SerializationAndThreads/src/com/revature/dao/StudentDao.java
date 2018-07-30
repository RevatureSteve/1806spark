package com.revature.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.revature.beans.student;

public class StudentDao {
	private static final String filePathAndName = "src/com/revature/person.txt";
	
	
public static void serializeStudent(student stud) throws IOException {
		
		//Serialize to student to a file
		
			FileOutputStream os = new FileOutputStream(filePathAndName);
			ObjectOutputStream oos = new ObjectOutputStream(os);
			oos.writeObject(stud);
			oos.close();
	}
	public static student deserializeStudent() {
		student john = null;
		
		try (FileInputStream is = new FileInputStream(filePathAndName);
				ObjectInputStream ois = new ObjectInputStream(is)){
			
			 john = (student) ois.readObject(); 
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}catch (Exception e) {
			
		}
		
		return john;
	}
}
