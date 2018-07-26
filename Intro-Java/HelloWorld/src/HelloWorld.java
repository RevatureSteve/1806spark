
<<<<<<< HEAD
<<<<<<< HEAD
//classes must be capitalized
public class HelloWorld {
	public HelloWorld() {
		
	}
	
	public static void main(String[] args) {
		System.out.println("Hello World my dude!");
	}
}
=======
=======
>>>>>>> ec6e1080cc8d22ffe15518fa344d4cd7dc0b1146
public class HelloWorld {
	
	// Declare variables
	int x;
	int y;
//	String z; 
	
	
	// Start execution here!
	// The famous method name main(): must follow this entire method signature
	//		to let the JVM know where start executing your code
	public static void main(String[] arg) {
		// sysout aka print to the console like console.log
		System.out.println("Hello World!"); // type Sysout then ctrl + spacebar (new best friend)
//		foo();
		//HelloWorld is the Datatype of the variable hw
						// create an object of type HelloWorld;
		HelloWorld hw;
		 hw = new HelloWorld();
		hw.foo();
		hw.x = 5;
		hw.y = 10;
		
		HelloWorld hw1 = new HelloWorld();
		hw1.x = 500;
		hw1.y = 1000;
		
		System.out.println(hw.x + " " + hw.y);
		System.out.println(hw1.x + " " + hw1.y);
		
	}
	
	
	public void foo() {
		System.out.println("foo");
	}
}
<<<<<<< HEAD
>>>>>>> 1d2362eb26499c820219011f2c853fc0e02e8dc4
=======
>>>>>>> ec6e1080cc8d22ffe15518fa344d4cd7dc0b1146
