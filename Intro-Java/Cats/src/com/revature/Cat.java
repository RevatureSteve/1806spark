package com.revature;


/**
 * 	POJO: Cat
 * 		- state
 * 		- no-args constructor
 * 		- behavior
 * 		- override toString()
 */
public class Cat {

		private String name;
		private String breed;
		public int age;
		
		
		public Cat() {}

		public Cat(String name, String breed) {
			super();
			this.name = name;
			this.breed = breed;
		}


		/*
		 * 	Getters and Setters for name
		 */
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}

		/*
		 * 	Getters and Setters for bredd
		 */
		public String getBreed() {
			return breed;
		}
		public void setBreed(String breed) {
			this.breed = breed;
		}

		@Override
		public String toString() {
			return "Cat [name=" + name + ", breed=" + breed + "]";
		}
		
		/*
		 * 	override the toString for proper display of the state(variables) in a Sysout
		 */
		
}
