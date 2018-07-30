//B


package com.Car;


public class SportsCar extends AllCars {
	
	
	public int horsePower;
	
	public SportsCar() {}
	
	

	public SportsCar(int horsePower, int cylinders, int seats, String model) {
		super(cylinders, seats, model);
		this.horsePower = horsePower;
		
	}



	public int getHorsePower() {
		return horsePower;
	}



	public void setHorsePower(int horsePower) {
		this.horsePower = horsePower;
	}




	@Override
	public String toString() {
		return super.toString() + "SportsCar [horsePower=" + horsePower + "]";
	}



	@Override
	public void homeMsg() {
		// TODO Auto-generated method stub
		
	}
	
	

}
