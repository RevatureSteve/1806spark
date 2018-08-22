
public class HelloWorld {
	//declare variables
	int x;
	int y;
	String z;
	
	
	
	// Start execution here!
	public static void main(String[] args) {
		//sysout. aka print to console like console.log
		System.out.println("Hello World!"); // type sysout then ctrl + space
		//if another class isnt static...
		HelloWorld hw;
		hw= new HelloWorld();
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
