package com.revature.assign;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BuffWrite {
	
	private static final String filePathAndName = "src/com/revature/assign/buffer.txt";
	
public static void writeCharacters(LabelB label) {
		
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePathAndName));){
			String page = label.getName() + label.getAge();
			
			writer.write(page);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static LabelB readCharacters(){
		
		try(BufferedReader reader = new BufferedReader(new FileReader(filePathAndName));){
			
			String line = "";
			while((line = reader.readLine()) != null){
				System.out.println(line);
			}			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}

}
