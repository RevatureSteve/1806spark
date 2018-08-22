package com.ex.fileio;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class CharacterStream {
	/*
	 * 	FileReader / FileWriter: character by character
	 * 		Slower than BufferedReader / BufferedWriter
	 */
	public static void main(String[] args) {
		String filename = "src/com/ex/fileio/charExample.txt";
		
//		writeCharacterStream(filename);
		readCharacterStream(filename);
		
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
		 * 	When we connect to a resource like a file or database, I open up a memory leak
		 * 		I NEED TO CLOSE ALL CONNECTIONS WHEN DONE!!!
		 * 		try () is the try w/ resources 
		 * 			-it will close any object that **implements AutoCloseable**
		 * 			-introduce in Java 1.7
		 * 			-acts like finally{ writer.close(); }
		 */
		try  (FileWriter writer = new FileWriter(filename,false);){
			
			for(int i = 65; i < 72; i++){
				writer.write(i);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
//		OLD WAY pre 1.7
//		finally {
//			try {
//				writer.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//			// finally block is the last block of a try/catch and it will always execute
//			// most commonly used to originally to close resources
//			// IQ but we use try w/ resources instead try () { }
//			
//		}
		
		
		
	}
	
	
}
