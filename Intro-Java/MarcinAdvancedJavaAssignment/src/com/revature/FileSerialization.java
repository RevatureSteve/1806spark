package com.revature;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.revature.abstracts.LabelA;

public class FileSerialization {
	public static void serialize(LabelA a) {
		try {
			// write object to file
			FileOutputStream fos = new FileOutputStream("file1.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(a);
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

	public static LabelA deserialize(String filepath) {
		// read object from file
		FileInputStream fis;
		try {
			fis = new FileInputStream(filepath);
			ObjectInputStream ois = new ObjectInputStream(fis);
			LabelA result = (LabelA) ois.readObject();
			ois.close();
			return result;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
		
	}
}
