package com.revature.part2;

import java.io.IOException;
import java.util.Scanner;

import com.revature.abstracts.Clothes;
import com.revature.dao.ClothesDao;
import com.revature.part2.PresentationUtil;

public class Driver2 {
public static void main(String[]args) throws IOException {
        
    	
		Scanner scan = new Scanner(System.in);
    	
        
        while(true) {
        	PresentationUtil.welcomeMenu(); // we know welcomeMenu() is static because PresentationUtil is capital
            int userInput  = scan.nextInt();
            System.out.println("User entered: " + userInput);
       switch (userInput) {
       case 1:
    	   promptUserForNewClothesAndPersist();
    	   break;
       case 2:
    	   getClothesAndDisplay();
    	   break;
    	   
       case 3:
    	   System.out.println("exiting..");
    	   System.exit(1);
       }
        }
       
   
    }
    public static void promptUserForNewClothesAndPersist() throws IOException {
    	//First prompt user and retrieve input
    	Clothes clot = PresentationUtil.creatingNewClothes();
    	// persist Student to file
    	try {
			ClothesDao.serializeStudent(clot);
		} catch (IOException e) {
			PresentationUtil.errorView("File is corrupt");
			
		
		}
    	
    	ClothesDao.serializeClothes(clot);
    	
    }
    
    public static void getClothesAndDisplay() {
		// retrieve clothes from ClothesDAO (Data access object)
    	System.out.println("say something");
		Clothes clot = ClothesDao.deserializeClothes();
		System.out.println("nothing exits");
		// Probably should have ducked the exception, and handled them here with try/catch
		PresentationUtil.presentClothes(clot);
		
	}
}

