package com.ex.fileio;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class CharacterStream {
	public static void main(String[] args) {
		/*
		 * fileReader / FileWriter : char bt char
		 * 
		 */
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
		 * when we connect to a resource like a file or DB, I open up a memory leak
		 * 		I NEED TO CLOSE ALL CONNECTON WHEN DONE!!
		 * 		try () is the try w/ resources
		 */
		
		try (FileWriter writer = new FileWriter(filename,true);) {
			/*FileWriter writer = new FileWriter(filename,true);*/
			for(int i = 65; i < 72; i++){
				writer.write(i);
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//finally block is the last block of a try/catch and it will always execute
			
		}
		
		
		
	}
	
	
}
