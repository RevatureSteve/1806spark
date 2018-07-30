package com.revature.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.revature.abstracts.Drinks;

public class DrinksDao {
	
	private final static String filePathAndNameSerizable = "src/com/revature/drinkSerizable.txt";
	private final static String filePathAndNameBuffer = "src/com/revature/drinkBuffer.txt";
	
	
	public static void serializeDrinks(Drinks drk) throws IOException {
		FileOutputStream os = new FileOutputStream(filePathAndNameSerizable);
		ObjectOutputStream oos = new ObjectOutputStream(os);
		oos.writeObject(drk);
		os.close();
		oos.close();
	}
	
	
	
	public static Drinks deserializeableDrinks() {
		Drinks drk = null;
		
		try (FileInputStream is = new FileInputStream(filePathAndNameSerizable);
				ObjectInputStream ois = new ObjectInputStream(is);){
			drk = (Drinks) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return drk;
	}
	
	

	
	public static void writeDrinks(Drinks drk) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePathAndNameBuffer));){
			bw.write(drk.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static String readDrinks() {
		String drk = null;
		try (BufferedReader br = new BufferedReader(new FileReader(filePathAndNameBuffer));) {
			drk = br.readLine();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return drk;
	}
	
}
