package com.ex.classes;
<<<<<<< HEAD
import java.util.Random;

public class Launcher {
	
	public static void main(String[] args) {
		
		Dog sparky = new Dog("sparky", 4, false, "zombie");
		System.out.println(sparky.getName());
		Fish johnson = new Fish("johnson", 50, true, 1);
		System.out.println(johnson.getName());
		
		Pet[] p = new Pet[5];
		for (int i = 0; i < p.length; i++) {
			p[i] = randPet();
		}
		
		for ( Pet petName: p ) {
//			System.out.println(petName.getName());
			petName.speak();
		}
		
	}
	
	public static Pet randPet() {
		Random rand = new Random();
		int r = rand.nextInt(3);
		Pet rp = null;
		switch (r) {
		
		case 0:
			rp = new Bird();
			rp.setName("birdy");
			break;
		
		case 1:
			rp = new Dog();
			rp.setName("doggo");
			break;
			
		case 2:
			rp = new Fish();
			rp.setName("bubbles");
			break;
			
		default:
			System.out.println("error");
			break;
		
		}
		
		return rp;
				
	}

=======

public class Launcher {
	public static void main(String[] args) {
		Dog sparky = new Dog("sparky", 48, false, "zombie");
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
		
		for(Pet p: pets) {
			p.speak();
		}
	}
>>>>>>> ec6e1080cc8d22ffe15518fa344d4cd7dc0b1146
}
