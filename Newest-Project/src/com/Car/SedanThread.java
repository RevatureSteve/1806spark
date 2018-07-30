
package com.Car;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SedanThread extends Thread{
	
	
	@Override
	public void run() {
		BufferedWriter bw = null;
		Speakers car = ScreenUtil.buildingSedan();
		try {
			final String file = "src/com/Car/Sedan.txt";
			FileWriter fw = new FileWriter(file);
			  bw = new BufferedWriter(fw);
			  bw.write(ScreenUtil.currentCar((Speakers) car));
		          System.out.println("File written Successfully");
		} catch (IOException e) {
			ScreenUtil.carError("File is corrupt!");	
			}finally {
				try{
				      if(bw!=null)
					 bw.close();
				   }catch(Exception ex){
				       System.out.println("Error in closing the BufferedWriter "+ex);
				    }
			}
		 
	}
}
