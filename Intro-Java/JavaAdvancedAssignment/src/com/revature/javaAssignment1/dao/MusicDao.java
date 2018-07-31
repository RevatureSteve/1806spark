package com.revature.javaAssignment1.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import com.revature.javaAssignment1.abstracts.Music;

public class MusicDao {
	
	
	private static String fileNameAndPath = "src/com/revature/javaAssignment1/MusicListBufferedWriter.txt";
	private static String fileNameAndPath1 = "src/com/revature/javaAssignment1/MusicListSerialized.txt";
	
	public static void writeToFile(String fileName,Object x) {
		
		
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));){
			
			
			writer.write("" + x);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void readTheFile() {
		
		
		try(BufferedReader reader = new BufferedReader(new FileReader(fileNameAndPath));){
			
			String line = "";
			while((line = reader.readLine()) != null){
				System.out.println(line);
			}			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void WriteSerializeMusicObject(Object obj) {
	
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileNameAndPath1));){
			
		oos.writeObject(obj);
		oos.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
			
			
		}
		
		
public static Music deserializeMusic() {
		
		Music lalala = null; //Outside block to make it local throughout the entire method
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileNameAndPath1));) {
			
			
			lalala = (Music)ois.readObject();
			
			
		} catch (IOException e1) {
			
			e1.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		
		return lalala; 
		
	}
	
	
	
	
	

}
