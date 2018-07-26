package com.ex.classes;

//public class Launcher {
//	 public static void main(String [] arrgs) {
//			
//		Dog sparky = new Dog("sparky",48,false,"bull");
////		sparky"sparky
//	 }
//}

public class Launcher {
	 public static void main(String [] arrgs) {
			
		Dog sparky = new Dog("sparky", 48, false, "zombie");
		System.out.println(sparky.getName());
		Fish johnson = new Fish("johnson", 15, true, "monster");
		System.out.println(johnson.getName());
		Bird joe = new Bird("buble", 5, true, "bigBird");
		System.out.println(joe.getName());
		
		Pet[] pets = new Pet[5];
		pets[0] = sparky;
		pets[2] = johnson;
		pets[3]	= joe;
//	    pets[4] = 
	    		
	 }
	 
	 
}
