public class HelloWorld {
	
	// Declare variables
	int x;
	int y;
	String z;
	
	// Start execution here
	public static void main(String[] args) {
		// Print to console
		System.out.println("Hello World!");
//		foo();
		HelloWorld hw = new HelloWorld();
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
