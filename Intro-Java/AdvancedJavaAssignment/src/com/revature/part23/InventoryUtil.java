package com.revature.part23;

import java.util.Scanner;

import com.revature.weapons.Staff;
import com.revature.weapons.Sword;

public class InventoryUtil {
	
	public static void welcomeInventory() {
		System.out.println("Welcome! What would you like to do?");
		System.out.println("Enter 1 to equip new sword");
		System.out.println("Enter 2 to read sword detail");
		System.out.println("Enter 3 to equip new staff");
		System.out.println("Enter 4 to read staff detail");
		System.out.println("Enter 5 to exit");
	}
	
	public static Sword usingNewSword() {
		Scanner scan = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);
		System.out.println("-----Equip New Sword-----");
		System.out.println("Enter Damage: ");
		int weaponDamage = scan.nextInt();
		System.out.println("Enter Color: ");
		String weaponColor = scan2.nextLine();
		
		Sword s = new Sword(weaponDamage, weaponColor);
		return s;
	}
	
	public static void swordDetail(Sword s) {
		System.out.println("-----Sword Detail-----");
		System.out.println(s);
	}
	
	public static Staff usingNewStaff() {
		Scanner scan = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);
		System.out.println("-----Equip New Staff-----");
		System.out.println("Enter Damage: ");
		int weaponDamage = scan.nextInt();
		System.out.println("Enter Color: ");
		String weaponColor = scan2.nextLine();
		
		Staff f = new Staff(weaponDamage, weaponColor);
		return f;
	}
	
	public static void staffDetail(Staff f) {
		System.out.println("-----Staff Detail-----");
		System.out.println(f);
	}
	
	public static void errorView(String message) {
		System.out.println("Sorry something went wrong...");
		System.out.println(message);
	}
}
