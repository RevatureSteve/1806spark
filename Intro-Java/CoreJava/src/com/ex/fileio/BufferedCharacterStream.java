package com.ex.fileio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedCharacterStream {
	public static void main(String[] args) {
		
		String filename = "src/com/ex/fileio/sampleBufferedCharacterFile.txt";
		writeCharacterStream(filename);
		readCharacterStream(filename);
	}
	
	static void writeCharacterStream(String filename) {
		
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(filename));){
			
			writer.write("Hello world\n");
			writer.write("again\n");
			writer.write("Buffered Streams are faster and easier to use\n");
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	static void readCharacterStream(String filename){
		

		try(BufferedReader reader = new BufferedReader(new FileReader(filename));){
			
			String line = "";
			while((line = reader.readLine()) != null){
				System.out.println(line);
			}			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
