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

import com.revature.abstracts.Attractions;
import com.revature.pojo.Lighthouse;

public class AttractionDao {
	
	private final static String filePathAndNameSerizable = "src/com/revature/attractionSerizable.txt";
	private final static String filePathAndNameBuffer = "src/com/revature/attractionBuffer.txt";
	
	
	public static void serializeAttraction(Attractions att) throws IOException {
		FileOutputStream os = new FileOutputStream(filePathAndNameSerizable);
		ObjectOutputStream oos = new ObjectOutputStream(os);
		oos.writeObject(att);
		os.close();
		oos.close();
	}
	
	
	
	public static Attractions deserializeableAttraction() {
		Attractions att = null;
		
		try (FileInputStream is = new FileInputStream(filePathAndNameSerizable);
				ObjectInputStream ois = new ObjectInputStream(is);){
			att = (Attractions) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return att;
	}
	
	

	
	public static void writeAttraction(Attractions attr) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePathAndNameBuffer));){
			bw.write(attr.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static String readAttraction() {
		String att = null;
		try (BufferedReader br = new BufferedReader(new FileReader(filePathAndNameBuffer));) {
			att = br.readLine();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return att;
	}
	
}
