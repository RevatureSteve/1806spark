package com.ex.classes;

public class Dog extends Pet {
	private String breed;

	public Dog() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Dog(String name, int age, boolean isAlive, String breed) {
		super(name, age, isAlive);
		this.breed = breed;
<<<<<<< HEAD
		// TODO Auto-generated constructor stub
=======
>>>>>>> d475e543ae45678c0e0ef13aa404b494ea00a41e
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
		// TODO Auto-generated method stub
		System.out.println(this.getName()+" barks ");
		
	}
	


	
	
	
	
	
	
}


=======
		System.out.println(this.getName() + " barks");
	}

}
>>>>>>> d475e543ae45678c0e0ef13aa404b494ea00a41e