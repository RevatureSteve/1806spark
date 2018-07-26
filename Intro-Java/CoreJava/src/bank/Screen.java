package bank;

public interface Screen {
	
	
	 /*
	  * the screen interface defines one method start();
	 all screens that implement this interface will
	 then run that method and return the next screen
	 to transition to
	 .*/
	
	Screen start();
	
}