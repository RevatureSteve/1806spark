
public class HelloWorld {
// declare variables
	 int x;
	 int y;
	 String z;
	
//	Start execution here
//	the famous method name main(): must follow this entire method signature
//	to let the JVM know where to start executing your code
	public static void main(String[] arg) {
		
		System.out.println("Hello World!");
//		foo();
//		HelloWorld is the Datatype of the variable hw
//			create an object of type HelloWorld
		
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
