package com.Car;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class CarDao {
	
	private static final String filePathAndName = "src/com/Car/SportsCar.txt";
	
	
public static void serializeCar(SportsCar car) throws IOException {
		
		//Serialize to student to a file
		
			FileOutputStream os = new FileOutputStream(filePathAndName);
			ObjectOutputStream oos = new ObjectOutputStream(os);
			oos.writeObject(car);
			oos.close();
	}

	public static SportsCar deserializeCar() {
		SportsCar frs = null;
		
		try (FileInputStream is = new FileInputStream(filePathAndName);
				ObjectInputStream ois = new ObjectInputStream(is)){
			
			 frs = (SportsCar) ois.readObject(); 
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}catch (Exception e) {
			
		}
		
		return frs;
	}
	
}
