package com.revature;

import com.revature.presentation.MainMenuScreen;

public class Driver {
	
	
	public static void main(String[] args) {
		Screen currentScreen = new MainMenuScreen();
		while(true) {			
			currentScreen = currentScreen.start();
		}
	}
	
	
	
	

	public static void displayOuterSpace() {
		System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT+".       "+ConsoleColors.WHITE_BOLD_BRIGHT+"  _ "+ConsoleColors.PURPLE_BOLD_BRIGHT+" .          .          .  "+ConsoleColors.YELLOW_BOLD_BRIGHT +"  +   "+ConsoleColors.PURPLE_BOLD_BRIGHT+"  .          .          .      ." + ConsoleColors.RESET);
		System.out.println(ConsoleColors.WHITE_BOLD_BRIGHT+"         (_)          .            .            .            .       :");
		System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT + "        .   .      .    .     .     .    .      .   .      . .  .  "+ ConsoleColors.YELLOW_BOLD_BRIGHT+"-+- "+ ConsoleColors.CYAN_BOLD_BRIGHT +"       ." + ConsoleColors.RESET);
		System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT +"         .           .   .        .           .          /         :  ." + ConsoleColors.RESET);
		System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "   . .        .  .      /.   .      .    .     .     .  / .      . ' .");
		System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT + "       . "+ ConsoleColors.YELLOW_BOLD_BRIGHT+" +   "+ ConsoleColors.BLUE_BOLD_BRIGHT +"    .    /     .          .          .   /      ." + ConsoleColors.RESET);
		System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT +"      .            .  /         .            .       "+ ConsoleColors.YELLOW_BRIGHT + " * "+ ConsoleColors.GREEN_BOLD_BRIGHT +"  .         .     ."+ ConsoleColors.RESET);
		System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT +"     .   .      .  " + ConsoleColors.YELLOW_BRIGHT +"  * "+ ConsoleColors.CYAN_BOLD_BRIGHT +"    .     .    .      .   .       .  ."+ ConsoleColors.RESET);
		System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "         .           .           .           .           .     "+ConsoleColors.YELLOW_BOLD_BRIGHT+"    + "+ConsoleColors.RED_BOLD_BRIGHT+" ."+ ConsoleColors.RESET);
		System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT +" . .        .  .       .   .      .    .     .     .    .      .   ." + ConsoleColors.RESET);
		System.out.println();
		System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT +"   .   +      .    "+ ConsoleColors.GREEN_BOLD_BRIGHT +"     ___/\\_._/~~\\_...__/\\__.._._/~\\   " + ConsoleColors.BLUE_BOLD_BRIGHT + "     .         .   ." + ConsoleColors.RESET);
		System.out.println("  "+ConsoleColors.PURPLE_BOLD_BRIGHT+"       .  "+ ConsoleColors.GREEN_BOLD_BRIGHT +"       _.--'                              `--. /\\   "+ ConsoleColors.PURPLE_BOLD_BRIGHT+"       .   ." + ConsoleColors.RESET);
		System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT +"            /~~\\/~\\                                          `-/~\\_  " + ConsoleColors.RESET +"          .");
		System.out.println("      . "+ ConsoleColors.GREEN_BOLD_BRIGHT +" .-'                                                        `-/\\ " + ConsoleColors.RESET);
		System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT +"   _/\\.-'               "+ ConsoleColors.YELLOW_BOLD_BRIGHT + "     Welcome to the Outer Bank!  " + ConsoleColors.GREEN_BOLD_BRIGHT +  "               \\__/~\\/\\-.__");
		System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + " .'                                                                                  `." + ConsoleColors.RESET);

	}
}
