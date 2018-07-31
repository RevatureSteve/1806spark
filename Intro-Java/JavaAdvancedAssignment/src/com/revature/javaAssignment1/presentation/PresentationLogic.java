package com.revature.javaAssignment1.presentation;

import java.util.Scanner;


import com.revature.javaAssignment1.concreteClasses.*;
import com.revature.javaAssignment1.dao.NewThread;

public class PresentationLogic {
	
	
	public static void presentScreen() {
		
		System.out.println("\n\n*******************************************************************************************************************\n\n");
		System.out.println("\t\t\t\t\tWelcome: Let's Make Some Classical Music!\n\n");
		System.out.println("*******************************************************************************************************************\n");
		System.out.println("\tSelect a corresponding number:\n");
		System.out.println("\t1: Create music with a piano");
		System.out.println("\t2: Create music with a trumpet band");
		System.out.println("\t3: Create music with a marching band");
		System.out.println("\t4: Create music with a baby piano");
		System.out.println("\t5: Play an instrument");
		System.out.println("\t6: View created music");
		System.out.println("\t7: Leave music program\n");
		System.out.println("*******************************************************************************************************************\n\n");
	}
	
	
	public static PianoMusic creatingPianoObject() {
		Scanner scanny1 = new Scanner(System.in);
		System.out.println("\n\n*******************************************************************************************************************\n\n");
		System.out.println("\t\t\t\t\tCreating Music With Piano!\n\n");
		System.out.println("*******************************************************************************************************************\n");
		System.out.println("\tEnter name of Composer\n");
		String musicComposer = scanny1.nextLine();
		System.out.println("\tWhat is the name of the instrument?\n");
		String instrumentName= scanny1.nextLine();
		System.out.println("\tHow many musicians are playing?\n");
		int numOfPlayers= scanny1.nextInt();
		scanny1.nextLine();
		System.out.println("\tName of the song?\n");
		String musicName= scanny1.nextLine();
		System.out.println("*******************************************************************************************************************");
		PianoMusic musical = new PianoMusic(musicComposer, instrumentName, numOfPlayers, musicName);
		Runnable persist = new NewThread(musical);
		Thread runner = new Thread(persist);
		runner.start();
		return musical;
		
	}
	
	
	public static TrumpetBand creatingTrumpetBandObject() {
		Scanner scanny1 = new Scanner(System.in);
		System.out.println("\n\n*******************************************************************************************************************\n\n");
		System.out.println("\t\t\t\t\tCreating Music With Trumpetband!\n\n");
		System.out.println("*******************************************************************************************************************\n");
		System.out.println("\tEnter name of the band\n");
		String bandName = scanny1.nextLine();
		System.out.println("\tWhat is the name of the main instrument being used?\n");
		String instrumentName= scanny1.nextLine();
		System.out.println("\tHow many band members?\n");
		int numOfPlayers= scanny1.nextInt();
		scanny1.nextLine();
		System.out.println("\tName of the song?\n");
		String musicName= scanny1.nextLine();
		System.out.println("*******************************************************************************************************************\n\n");
		TrumpetBand trumpetBandMusic = new TrumpetBand(instrumentName, bandName, numOfPlayers,musicName);
		Runnable persist = new NewThread(trumpetBandMusic);
		Thread runner = new Thread(persist);
		runner.start();
		return trumpetBandMusic;
	}
	
	
	
	
	public static MarchingBand creatingMarchingBandObject() {
		Scanner scanny1 = new Scanner(System.in);
		System.out.println("\n\n*******************************************************************************************************************\n\n");
		System.out.println("\t\t\t\t\tCreating Music With Marchingband!\n\n");
		System.out.println("*******************************************************************************************************************\n");
		System.out.println("\tEnter name of the Marching Band\n");
		String bandName = scanny1.nextLine();
		System.out.println("\tWhat is the name of the main instrument being used?\n");
		String instrumentName= scanny1.nextLine();
		System.out.println("\tHow many band members?\n");
		int numOfPlayers= scanny1.nextInt();
		scanny1.nextLine();
		System.out.println("\tName of the song?\n");
		String musicName= scanny1.nextLine();
		System.out.println("*******************************************************************************************************************\n\n");
		MarchingBand marchingBand = new MarchingBand(instrumentName, bandName, numOfPlayers,musicName);
		Runnable persist = new NewThread(marchingBand);
		Thread runner = new Thread(persist);
		runner.start();
		return marchingBand;
	}
	
	public static BabyPianoMusic creatingBabyPianoMusicObject() {
		Scanner scanny1 = new Scanner(System.in);
		System.out.println("\n\n*******************************************************************************************************************\n\n");
		System.out.println("\t\t\t\t\tCreating Music With Baby Piano!\n\n");
		System.out.println("*******************************************************************************************************************\n");
		System.out.println("\tEnter name of Composer\n");
		String musicComposer = scanny1.nextLine();
		System.out.println("\tWhat is the name of the instrument?\n");
		String instrumentName= scanny1.nextLine();
		System.out.println("\tHow many musicians are playing?\n");
		int numOfPlayers= scanny1.nextInt();
		scanny1.nextLine();
		System.out.println("\tName of the song?\n");
		String musicName= scanny1.nextLine();
		System.out.println("*******************************************************************************************************************\n\n");
		BabyPianoMusic babyMusical = new BabyPianoMusic(musicComposer, instrumentName, numOfPlayers, musicName);
		Runnable persist = new NewThread(babyMusical);
		Thread runner = new Thread(persist);
		runner.start();
		return babyMusical;
	}

	public static void playInstrument() {
		Scanner scanny1 = new Scanner(System.in);
		System.out.println("\n\n*******************************************************************************************************************\n\n");
		System.out.println("\t\t\t\t\tLet's play a classical instrument\n\n");
		System.out.println("*******************************************************************************************************************\n");
		System.out.println("\tWhat instrument object do you want to play:\n");
		System.out.println("\tPiano");
		System.out.println("\tTrumpet Band");
		System.out.println("\tMarching Band");
		System.out.println("\tBaby Piano\n");
		System.out.print("\tEnter instrument type here: ");
		String userInput = scanny1.nextLine();
		if (userInput.equalsIgnoreCase("Piano")) {
			new PianoMusic().playInstrument();
		}
		else if (userInput.equalsIgnoreCase("Trumpet Band")){
			new TrumpetBand().playInstrument();
		}
		else if (userInput.equalsIgnoreCase("Marching Band")){
			new MarchingBand().playInstrument();
		}
		else if (userInput.equalsIgnoreCase("Baby Piano")){
			new BabyPianoMusic().playInstrument();
		}
		else {
			System.out.println("\t\nSorry we do not have that instument yet!");
		}
		
	}
	
}
