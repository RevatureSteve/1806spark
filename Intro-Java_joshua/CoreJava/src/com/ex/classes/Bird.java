package com.ex.classes;

public class Bird extends Pet {

		
		private int wingLength;
		
		
		public Bird() {
			super();
		}
		
		public Bird(String name, int age, boolean isAlive, int wingLength) {
			super(name, age, isAlive);
			this.wingLength = wingLength;
		}
		
		

		public int getWingLength() {
			return wingLength;
		}
		public void setWingLength(int wingLength) {
			this.wingLength = wingLength;
		}

		@Override
		public void speak() {
			System.out.println(this.getName() + " bubbles");
			// TODO Auto-generated method stub 
			
		}
		
			
			
	
	
}
