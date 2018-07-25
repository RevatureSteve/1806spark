package com.ex.classes;

public class Launcher {
	public static void main(String[] args) {
		Dog sparky = new Dog("sparky", 48, false, "zombie");
<<<<<<< HEAD
		System.out.println(sparky.getAge());  //uses getter 
		Fish johnson = new Fish("johnson", 50, true, 1);
		System.out.println(johnson.isAlive());
		

		
		
		Pet[] pets = new Pet[5];
		pets[0] = sparky;
		 
		
		
		
		
=======
		Fish johnson = new Fish("johnson", 50, true, 1);
		
		Dog bolt = new Dog("bolt", 3, true, "husky");
		
		Fish bubbles = new Fish("bubbles", 2, true, 4);
		
		Dog drew = new Dog("drew", 8, true, "mut");
		
		Pet[] pets = new Pet[5];
		pets[0] = sparky;
		pets[1] = johnson;
		pets[2] = bolt;
		pets[3] = bubbles;
		pets[4] = drew;
>>>>>>> d475e543ae45678c0e0ef13aa404b494ea00a41e
		
		for(Pet p: pets) {
			p.speak();
		}
<<<<<<< HEAD
		
		//for(Pet p: pets) {     for each pet in the array pets
		//	System.out.println(p.getName());
		//	}
		
		
		
//		String[] pets = {"George","Hot Shot","Mr. Giggles","Fluff", "Popeye"};
		
		
//		System.out.println(pets[3]);
		
//		for(String element: pets){
//			System.out.println(element);
//		}
=======
>>>>>>> d475e543ae45678c0e0ef13aa404b494ea00a41e
	}
}
