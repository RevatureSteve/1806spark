package com.ex.classes;

public class Launcher {
	public static void main(String[] args) {
		Dog sparky = new Dog("sparky", 48, false, "zombie");
		System.out.println(sparky.getAge());  //uses getter 
		Fish johnson = new Fish("johnson", 50, true, 1);
		System.out.println(johnson.isAlive());
		

		
		
		Pet[] pets = new Pet[5];
		pets[0] = sparky;
		 
		
		
		
		
		
		for(Pet p: pets) {
			p.speak();
		}
		
		//for(Pet p: pets) {     for each pet in the array pets
		//	System.out.println(p.getName());
		//	}
		
		
		
//		String[] pets = {"George","Hot Shot","Mr. Giggles","Fluff", "Popeye"};
		
		
//		System.out.println(pets[3]);
		
//		for(String element: pets){
//			System.out.println(element);
//		}
	}
}
