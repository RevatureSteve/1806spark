package com.revature.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.revature.abstracts.Clothes;


public class ClothesDao {
	
	private static final String filePathAndName = "src/com/revature/part2/clothes.txt"; // static so it belongs to the class and i do not need an object
	
/*DAO is a type of design pattern
     *    Data access object
     */
	                                                    
	 public static void serializeStudent(Clothes clot) throws IOException {
		 
	    	// Serialize clothes to a file
	    	FileOutputStream os = new FileOutputStream(filePathAndName);
	    			ObjectOutputStream oos = new ObjectOutputStream(os); 
	    		    oos.writeObject(clot);
	    		    oos.close();
	    		    
	    	}
	
	    
	    public static Clothes deserializeClothes() {
	    	
	   	 Clothes clot = null; // declare clot outside of the try block to get a bigger local scope 
	   	try (FileInputStream is = new FileInputStream(filePathAndName);
	   			ObjectInputStream ois = new ObjectInputStream(is)) {
	   		
	   	   clot = (Clothes) ois.readObject(); // reassigning clot
	   		
	   	} catch (FileNotFoundException e) {
	   		e.printStackTrace();
	   	} catch (IOException e1) {
	   	   e1.printStackTrace();
	   	} catch (ClassNotFoundException e) {
	   		e.printStackTrace();
	   	}
	   	return clot; // return null; is another way of saying TODO
	   }


		public static void serializeClothes(Clothes clot) {
			
			
		}
	   	
	}


