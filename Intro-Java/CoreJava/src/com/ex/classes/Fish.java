package com.ex.classes;

<<<<<<< HEAD
public class Fish extends pet{

		private String numberFins;

		public Fish() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Fish(String name, int age, boolean isAlive, String numberFins) {
			super(name, age, isAlive);
			// TODO Auto-generated constructor stub
		}

		public Fish(String numberFins) {
			super();
			this.numberFins = numberFins;
		}

		public String getNumberFins() {
			return numberFins;
		}

		public void setNumberFins(String numberFins) {
			this.numberFins = numberFins;
		}

		@Override
		public void speak() {
			System.out.println(this.getName() + " bubbles.");
			// TODO Auto-generated method stub
			
		}
		
	

		
	}
=======
public class Fish extends Pet {
	private int numberFins;

	public Fish() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Fish(String name, int age, boolean isAlive, int numberFins) {
		super(name, age, isAlive);
		this.numberFins = numberFins;
	}

	public int getNumberFins() {
		return numberFins;
	}

	public void setNumberFins(int numberFins) {
		this.numberFins = numberFins;
	}

	@Override
	public void speak() {
		System.out.println(this.getName() + " bubbles");
	}

}
>>>>>>> ec6e1080cc8d22ffe15518fa344d4cd7dc0b1146
