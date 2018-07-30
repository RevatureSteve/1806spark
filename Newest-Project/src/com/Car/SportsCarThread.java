package com.Car;

import java.io.IOException;

public class SportsCarThread extends Thread {
	
@Override
public void run() {
	lilCar car = (lilCar) ScreenUtil.buildingCar();
	try {
		CarDao.serializeCar(car);
	} catch (IOException e) {
		ScreenUtil.carError("File is corrupt!");	
		}
}


}
