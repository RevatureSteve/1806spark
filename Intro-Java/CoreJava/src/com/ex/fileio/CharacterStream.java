package com.ex.fileio;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class CharacterStream {
<<<<<<< HEAD
	
	/*
	 *  FileReader
=======
	/*
	 * 	FileReader / FileWriter: character by character
	 * 		Slower than BufferedReader / BufferedWriter
>>>>>>> 8ff4b17dd674ea7826c6e1af98f02d7fae8acae8
	 */
	public static void main(String[] args) {
		String filename = "src/com/ex/fileio/charExample.txt";
		
<<<<<<< HEAD
		//writeCharacterStream(filename);
=======
//		writeCharacterStream(filename);
>>>>>>> 8ff4b17dd674ea7826c6e1af98f02d7fae8acae8
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
<<<<<<< HEAD
		
		/*
		 *	When we connect to a resource like a file or database, I open up a memory leak
		 *		I NEED TO CLOSE ALL CONNECTIONS WHEN DONE!! 
		 *	try() is the try w/ resources (try w/ resources)
		 *		- it will close any object that **implements AutoCloseable**
		 *				- classes extends classes and interfaces extends interfaces
		 *		- introduce in Java 1.7
		 *		- acts like finally{ writer.close}
		 */
		
		try (FileWriter writer = new FileWriter(filename,true);) {
=======
		/*
		 * 	When we connect to a resource like a file or database, I open up a memory leak
		 * 		I NEED TO CLOSE ALL CONNECTIONS WHEN DONE!!!
		 * 		try () is the try w/ resources 
		 * 			-it will close any object that **implements AutoCloseable**
		 * 			-introduce in Java 1.7
		 * 			-acts like finally{ writer.close(); }
		 */
		try  (FileWriter writer = new FileWriter(filename,false);){
>>>>>>> 8ff4b17dd674ea7826c6e1af98f02d7fae8acae8
			
			for(int i = 65; i < 72; i++){
				writer.write(i);
			}
<<<<<<< HEAD
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
//		OLD WAY pre 1.7 - The last block of a try catch usually used to close resources
		//finally {
//		
//		try {
//			writer.close();
//		} catch (IOException e) {
//		e.printStackTrace();
//			}
		
			// finally block is the last block of a try/catch and it will always execute
			// most commonly used originally to close resources
			// IQ but we use try w/ resources instead try () {}
=======
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
>>>>>>> 8ff4b17dd674ea7826c6e1af98f02d7fae8acae8
		
		
		
	}
	
	
}
