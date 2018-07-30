package com.ex.fileio;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class CharacterStream {
	public static void main(String[] args) {
		String filename = "src/com/ex/fileio/charExample.txt";
		
		//writeCharacterStream(filename);
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
		 * when connecting to a resource like a file or a database, i open up a memory leak.
		 * i need to close all connected resources when done.
		 * try() is the try w/ resources and it will...
		 * - close any obj that implements AutoCloseable
		 * - intro'd in J.1.7
		 * - acts like a finally{writer.close();}
		 * */
		
			// while it is in the try( here ) it will close.
		try (FileWriter writer = new FileWriter(filename,true);) {
			//if FileWriter writer = new FileWriter(filename,true);
			// were here, itd cause a memory leak.
			for(int i = 65; i < 72; i++){
				writer.write(i); 
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} /*finally {
			// last block of a try/catch and will always execute.
		}*/
		
		
		
	}
	
	
}
