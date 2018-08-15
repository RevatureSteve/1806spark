package com.revature.pojo;

/*
 * Hercules is an object we want to restrict to only one instance: singleton
 * 
 * what does a singleton requires
 * 	1. control the constructor(s) by encapsulating them with private
 *  2. static self reference line 13
 *  3. public static get method  for the self reference
 *  4. create the state like any other pojo/Javabeans
 */
public class Hercules {
	
	//self reference to give to other classes
	private static Hercules hercules; //1 scope? it a class bc it is static by aka static keyword
	
	// privide Hercules with some state
		private String name; // 2 scope? insatance aka object, not inside of a method and not and not static
		
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		private int age;    // scope instance /// hover over the age, name, isAlive and you can generate getter and setter
		private boolean isAlive;  // scope instance
		
		
	 private Hercules() { //3 set the name to Hercules in the constructor
		 this.setName ("Hercules"); // this. is not required since we are not shadowing the name field
		 setAge(100);
		 setAlive(true);
		 
	 }
	 
	 // provide a getHercules static method to give the only instance where needed
	
	 public static Hercules getHercules() { //  call the constructor only once
		 if(hercules == null) {
			 hercules = new Hercules(); 
		 }
		 return hercules;
		 
	 }

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	
	
 
}
