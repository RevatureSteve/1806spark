package bank;

public class bankLauncher {
		public static void main(String[] args) {
			
			Screen currentScreen = new MainScreen();

			while (true) {
				currentScreen = currentScreen.start();
			}
		}

	}