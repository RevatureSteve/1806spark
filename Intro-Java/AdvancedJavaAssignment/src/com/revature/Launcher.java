package com.revature;

import com.revature.exceptions.CheckedException;
import com.revature.exceptions.UncheckedException;
import com.revature.part23.InventoryUtil;
import com.revature.part23.WeaponsDao;
import com.revature.threads.StaffThread;
import com.revature.threads.SwordThread;
import com.revature.weapons.Aluneth;
import com.revature.weapons.Excalibur;
import com.revature.weapons.Staff;
import com.revature.weapons.Sword;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Launcher {

	public static void main(String[] args) throws CheckedException {
//		Sword s = new Sword(); // instanciating new object
//		s.setDamage(-100);
//		try {
//			s.setColor("blue");
//		} catch (CheckedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		Excalibur x = new Excalibur(200, "red");
//		Aluneth l = new Aluneth(300, "blue");
		
//		x.setDamage(-100);
//		try {
//			x.setColor(null);
//		} catch (CheckedException e) {
//			e.printStackTrace();
//		}
//		System.out.println(x);
//		System.out.println(l);
		
		Scanner scan = new Scanner (System.in);
		
		
		while(true) {
			InventoryUtil.welcomeInventory(); //	we know welcomeMenu() is static because PresentationUtil is capital
			int userInput = scan.nextInt();
			System.out.println("User entered: " + userInput);
			switch (userInput) {
			case 1:
				Thread t1 = new SwordThread();
				t1.start();
				try {
					t1.join();// forces the main method to wait until the thread is done
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
//				promptPlayerToEquipWeaponAndPersist();
				break;
			case 2:
				getSwordAndDisplay();
				break;
			case 3:
				Runnable f = new StaffThread();
				Thread t2 = new Thread(f);
				t2.start();
				try {
					t2.join();// forces the main method to wait until the thread is done
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
				break;
			case 4:
				Staff f1 =readStaff("src/com/revature/staff.txt");
				System.out.println(f1);
				break;
			case 5:
				System.out.println("Exiting...");
				scan.close();
				System.exit(1);
			}
		}
	}
	
	public static void promptPlayerToEquipWeaponAndPersist() {
		//	1st prompt player and retrieve input
		Sword s = InventoryUtil.usingNewSword();
		
		//	persist sword detail to file
		try {
			WeaponsDao.serializeSword(s);
		} catch (IOException e) {
			InventoryUtil.errorView("File is corrupt");
		}
	}
	
	public static void getSwordAndDisplay() {
		//	retrieve sword from WeaponsDAO (Data access object)
		Sword s = WeaponsDao.deserializeSword();
		InventoryUtil.swordDetail(s);
	}
	
	public static void writeStaff(String filename, Staff f) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename));) {
			bw.write(f.getDamage() + ":" + f.getColor());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Staff readStaff(String filename) throws CheckedException {
		Staff f = new Staff(0, filename);
		try (BufferedReader br = new BufferedReader(new FileReader(filename));) {

			String line = null;
			while ((line = br.readLine()) != null) {
				String[] staffValues = line.split(":");
				
				int damage = Integer.valueOf(staffValues[0]);
				try {
					f.setDamage(damage);
				} catch (UncheckedException e) {
					e.printStackTrace();
				}
				
				f.setColor(staffValues[1]);

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return f;

	}


}
