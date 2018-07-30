package com.revature.monday;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ReceiptDao {
	
	private static final String filePathAndName = "src/com/revature/monday/SerializeToFile.txt";
	
	public static void serializeCheck(BarPresentationUtil check) throws FileNotFoundException, IOException {
		//Serialize check object to a file
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePathAndName));){
			oos.writeObject(check);
			oos.close();
		}
	}
		
	public static ReceiptSerializable deserializeCheck() {
		
		ReceiptSerializable yourCheck = null;
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePathAndName));){
			
			yourCheck = (ReceiptSerializable) ois.readObject();
			
		}catch (IOException e1) {
			e1.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return yourCheck;
	}

	public static void serializeCheck(ReceiptSerializable yourCheck) {
		// TODO Auto-generated method stub
		
	}
		
	}


