package com.ex.classes;

<<<<<<< HEAD
public class Dog extends pet{
	
=======
public class Dog extends Pet {
>>>>>>> ec6e1080cc8d22ffe15518fa344d4cd7dc0b1146
	private String breed;

	public Dog() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Dog(String name, int age, boolean isAlive, String breed) {
		super(name, age, isAlive);
<<<<<<< HEAD
		// TODO Auto-generated constructor stub
=======
		this.breed = breed;
>>>>>>> ec6e1080cc8d22ffe15518fa344d4cd7dc0b1146
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	@Override
	public void speak() {
<<<<<<< HEAD
	 System.out.println(this.getName() + " woof!");
		// TODO Auto-generated method stub
		
	}


=======
		System.out.println(this.getName() + " barks");
	}

>>>>>>> ec6e1080cc8d22ffe15518fa344d4cd7dc0b1146
}
