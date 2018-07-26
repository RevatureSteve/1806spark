package com.ex.classes;
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

}
