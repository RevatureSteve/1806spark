package com.revature.assign;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class LabelDao {

	private static final String filePathAndName = "src/com/revature/assign/labelSheet.txt";

	public static void serializeLabelB(LabelB label) throws IOException {
		PersThread pt = new PersThread();
		Thread thr = new Thread(pt);
		thr.start();

		FileOutputStream fos = new FileOutputStream(filePathAndName); 
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(label);
		fos.close();
		oos.close();
	}

	public static LabelB deserializeLabelB() {
		LabelB label = null;
		
		try (FileInputStream fis = new FileInputStream(filePathAndName);
			ObjectInputStream ois = new ObjectInputStream(fis)) {
			label = (LabelB) ois.readObject();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
			
		return label; // return null; is another way of saying TODO
	}

}
