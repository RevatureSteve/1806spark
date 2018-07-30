package com.revature;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FishDao {
	
	private static String filepath = "src/com/revature/FishPrintsSerial.txt";
	
	public static void serializeFish(Grouper g) throws IOException{
	
	FileOutputStream fos = new FileOutputStream(filepath);
	ObjectOutputStream oos = new ObjectOutputStream(fos);
	oos.writeObject(g);
	oos.close();
	}


public static Grouper deserialize() {
	// read the object from the file
	Grouper g = null; // creating the object
	try (FileInputStream is = new FileInputStream(filepath);// tells it what file to read
			ObjectInputStream ois = new ObjectInputStream(is)) { // 
		g = (Grouper) ois.readObject(); // reads the object assigns to g
	} catch (FileNotFoundException e) { //
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	return g; 
}
}