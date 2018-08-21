package com.revature;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.revature.abstracts.MathTeam;

public class Serialization {
	private static String filepath = "file1.txt";
	public static void serialize(MathTeam a) {
		try {
			// write object to file
			FileOutputStream fos = new FileOutputStream(filepath);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(a);
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

	public static MathTeam deserialize() {
		// read object from file
		FileInputStream fis;
		try {
			fis = new FileInputStream(filepath);
			ObjectInputStream ois = new ObjectInputStream(fis);
			MathTeam result = (MathTeam) ois.readObject();
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
