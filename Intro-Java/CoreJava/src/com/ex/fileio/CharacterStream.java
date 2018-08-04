package com.ex.fileio;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class CharacterStream {
	/*
	 * filereader/filewriter: character by character
	 * */
	public static void main(String[] args) {
		String filename = "src/com/ex/fileio/charExample.txt";
		
		writeCharacterStream(filename);
		
	}
	
	static void readCharacterStream(String filename){
		
		try(FileReader reader = new FileReader(filename);){
			
			int i;
			while ((i = reader.read()) != -1) {
				System.out.print((char) i);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	static void writeCharacterStream(String filename){
		/*
		 * * when we connect to a resource like a file or database, i open up a memory leak
		 *  I need to close all connections when done!!!
		 *  try () is the try with resources
		 *    - it will close any object that **implements AutoCloseable **
		 *    - introduce i java 1.7
		 *    - acts like finally {writer.close(); }
		 */
		
		try (FileWriter writer = new FileWriter(filename,true);) {
			// true mean append so in this case it will keep adding to the file
			
			for(int i = 65; i < 72; i++){
				writer.write(i);
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
}
