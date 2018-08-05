package com.ad.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import com.ad.pojo.MountainDrake;

public class DragonDao {

	private static final String MountainPath = "src/com/ad/MountainDrake.txt";

	public static void serializeMountain(MountainDrake mtn) throws IOException {

		// Serialize student to a file
		FileOutputStream os = new FileOutputStream(MountainPath);
		ObjectOutputStream oos = new ObjectOutputStream(os);
		oos.writeObject(mtn);
		oos.close();
	}

	public static MountainDrake deserializeMountain() {

		MountainDrake mtn = null;
		try (FileInputStream is = new FileInputStream(MountainPath);
				ObjectInputStream ois = new ObjectInputStream(is)) {

			mtn = (MountainDrake) ois.readObject();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return mtn;
	}
}
