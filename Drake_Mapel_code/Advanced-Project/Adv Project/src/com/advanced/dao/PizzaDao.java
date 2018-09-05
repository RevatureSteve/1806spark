package com.advanced.dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.advanced.drake.Pizza;

public class PizzaDao {
	
//	Data Access Object
		
	private static final String filePathAndName = "src/com/advanced/pizza.txt";
	
	
	public static void serializePizza(Pizza pizza) throws IOException {
		
		// serialize pizza to an order file
		FileOutputStream os = new FileOutputStream(filePathAndName);
		ObjectOutputStream oos = new ObjectOutputStream(os);
			
		oos.writeObject(pizza);
		
		os.close();
		oos.close();
	}
	
	public static Pizza deserializePizza() throws IOException, ClassNotFoundException {
		
		FileInputStream is = new FileInputStream(filePathAndName);
		ObjectInputStream ois = new ObjectInputStream(is);
	
		Pizza pizza = (Pizza) ois.readObject();	
		
		is.close();
		ois.close();
		return pizza;
	}

}