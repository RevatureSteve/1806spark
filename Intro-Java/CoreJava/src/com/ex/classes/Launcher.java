package com.ex.classes;

import com.ex.classes.Bird;
import com.ex.classes.Dog;
import com.ex.classes.Fish;

public class Launcher {
	public static void main(String[] args ) {
		
		Pet[] myPets = new Pet[5];
		
		myPets[0] = new Dog("sparky", 48, false,"zombie");


		myPets[1] = new Fish("Johnson", 58, true,1);

		
		myPets[2] = new Bird("Humph", 58, true,"turkey");

		
		myPets[3] = new Dog("Kell", 58, true,"golden retriever");

		
		myPets[4] = new Fish("Froppy", 58, true,2);

		
		
				
		for (Pet nam : myPets) {
            nam.speak();
        }

		
		
		
	}

}
