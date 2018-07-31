package com.revature.javaAssignment1;

import com.revature.javaAssignment1.concreteClasses.*;
import com.revature.javaAssignment1.dao.MusicDao;
import com.revature.javaAssignment1.presentation.PresentationLogic;

import java.util.*;

class Launcher{

	public static void main(String [] args) {
		
		TrumpetBand cobras = new MarchingBand();
		
		Scanner scanny = new Scanner(System.in);
		
	while(true)	{
		PresentationLogic.presentScreen();
		int userSelection = scanny.nextInt();
		switch (userSelection) {
		
		case 1:
				PresentationLogic.creatingPianoObject();
			break;
		case 2:
				PresentationLogic.creatingTrumpetBandObject();
			break;
		case 3:
				PresentationLogic.creatingMarchingBandObject();
			break;
		case 4:
				PresentationLogic.creatingBabyPianoMusicObject();
			break;
		case 5:
				PresentationLogic.playInstrument();
			break;
		case 6:
				MusicDao.readTheFile();
			break;
		case 7:
				System.out.println("\nexiting...\n");
				System.exit(1);
			break;
		default: 
				System.out.print("Enter a number 1 - 7");
		
		}
	}
		
	}
	
}
