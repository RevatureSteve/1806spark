package com.ad;

import com.ad.pojo.MountainDrake;
import com.ad.abstracts.NoAgeException;
import com.ad.dao.DragonDao;
import com.ad.pojo.MysticDrake;
import com.ad.presentation.PresentationUtil;
import com.ad.threads.MountainThread;
import com.ad.threads.MysticThread;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Driver {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String MysticPath = "src/com/ad/MysticDrake.txt";
		System.out.println("Hello there! You must be the informant on the two dragons that have been spotted.");

		while (true) {
			MountainDrake mtn = getMountain();
			MysticDrake mys = readMys(MysticPath);
			PresentationUtil.Information(mtn, mys);

			String input = scan.nextLine();

			switch (input) {
			case "1":
				Thread t1 = new MountainThread();
				t1.start();
				try {
					t1.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				break;
			case "2":
				Thread t2 = new MysticThread();
				t2.start();
				try {
					t2.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				break;
			case "3":
				System.out.println("Thank you for the help! Goodbye");
				System.exit(1);
				break;
			}
		}
	}

	public static void persistMtn(MountainDrake mtn) {
		try {
			DragonDao.serializeMountain(mtn);
		} catch (IOException e) {
			PresentationUtil.errorView("File is corrupt");
		}
	}

	public static MountainDrake getMountain() {
		MountainDrake mtn = DragonDao.deserializeMountain();
		return mtn;
	}

	public static void writeMystic(String filename, MysticDrake mys) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename));) {
			bw.write(mys.getName() + ":" + mys.getAge() + ":" + mys.getAbility() + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static MysticDrake readMys(String filename) {
		MysticDrake mys = new MysticDrake();
		try (BufferedReader br = new BufferedReader(new FileReader(filename));) {

			String line = null;
			while ((line = br.readLine()) != null) {
				String[] drakeValues = line.split(":");
				mys.setName(drakeValues[0]);
				
				int age = Integer.valueOf(drakeValues[1]);
				try {
					mys.setAge(age);
				} catch (NoAgeException e) {
					e.printStackTrace();
				}
				
				mys.setAbility(drakeValues[2]);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return mys;

	}
}
