package com.revature.part23;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import com.revature.weapons.Sword;

public class WeaponsDao {
	
	private final static String filePathAndName = "src/com/revature/sword.txt";
	
	public static void serializeSword(Sword s) throws IOException {
		//	Serialize sword to a file
		FileOutputStream os = new FileOutputStream(filePathAndName);
		ObjectOutputStream oos = new ObjectOutputStream(os);
		oos.writeObject(s);
		oos.close();
		
	}

	public static Sword deserializeSword() {
		Sword s = null; // declare Bow outside of the try block to get a bigger local scope
		try (FileInputStream is = new FileInputStream(filePathAndName);
				ObjectInputStream ois = new ObjectInputStream(is)) {
			
		s = (Sword) ois.readObject(); // reassigning bow
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return s;
		
	}
}
