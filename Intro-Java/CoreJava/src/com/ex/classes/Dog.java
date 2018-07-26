<<<<<<< HEAD
/*
 * @author Marcin Salamon
 */
package com.ex.classes;

public class Dog extends Pet{

	private String breed;

	/**
	 * 
	 */
=======
package com.ex.classes;

public class Dog extends Pet {
	private String breed;

>>>>>>> ec6e1080cc8d22ffe15518fa344d4cd7dc0b1146
	public Dog() {
		super();
		// TODO Auto-generated constructor stub
	}

<<<<<<< HEAD
	/**
	 * @param name
	 * @param age
	 * @param isAlive
	 */
=======
>>>>>>> ec6e1080cc8d22ffe15518fa344d4cd7dc0b1146
	public Dog(String name, int age, boolean isAlive, String breed) {
		super(name, age, isAlive);
		this.breed = breed;
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
		System.out.println("Bark Bark");
		
	}
	
} // end of dog
=======
		System.out.println(this.getName() + " barks");
	}

}
>>>>>>> ec6e1080cc8d22ffe15518fa344d4cd7dc0b1146
