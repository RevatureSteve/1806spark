import java.util.Date;

public class EmployeeTest {
	
	public static void main(String args[]) {
////		create two objects using constructor
//		Employee empOne = new Employee("James Smith");
//		Employee empTwo = new Employee("Mary Anne");
//		
////		Invoking methods for each object created
//		empOne.empAge(26);
//		empOne.empDesignation("Senior software engineer");
//		empOne.empSalary(1000);
//		empOne.printEmployee();
//		
//		empTwo.empAge(26);
//		empTwo.empDesignation("Senior software engineer");
//		empOne.empSalary(1000);
//		empOne.printEmployee();
//	}


//int [] numbers = {10, 20, 30, 40, 50, 60};
//
//	for (int x : numbers) {
//		System.out.print(x);
//		System.out.print(",");
//			}
//	System.out.print("\n");
//	String [] names = {"James", "Larry", "Tom", "Lacy"};
//	
//	for( String name : names) {
//		System.out.print( name );
//		System.out.print(",");
//	}
//}
//	char [] helloArray = {'h','e','l','p','m','e'};
//		String helloString = new String(helloArray);
//		System.out.println( helloString );
//
//	String palindrome = "Dot saw I was Tod";
//	int len = palindrome.length();
//	System.out.println( "String LEngth is : " + len);
//	
//	String string1 = " was kissing ";
//	System.out.println("Dot" + string1 + "Tod");
//	
//	int[] numbers = new int [9];
//	System.out.println(numbers);
//	
//	double[] myList = {1.9, 2.9, 3.4, 3.5};
//	
//	for (int i = 0; i < myList.length; i++) {
//		System.out.println(myList[i] + " ");
//	}	
//	double total = 0;
//	for (int i = 0; i < myList.length; i++) {
//		total += myList[i];
//	}
//	System.out.println("Total is " + total);
//	
//	double max = myList[0];
//	for (int i = 1; i < myList.length; i++) {
//		if (myList[i] > max) max = myList[i];
//	}
//	System.out.println("Max is " + max);
//	
//	for (double element:myList) {
//		System.out.println(element);
//	}
//	
//	public static void printArray(int[] array) {
//		for (int i = 0; i < array.length; i++) {
//			System.out.print( array[i] + " ");
//
//		printArray(new int[] {1 ,3 ,5 ,7 ,9});
//	}
//	
//		public static int [] reverse(int[] list) {
//			int[] result = new int [list.length];
//			
//			for (int i = 0, j=result.length -1; i <list.length; i++, j--) {
//				result[j] = list [i];
//			}
//			System.out.println( result );
//		}
//		Date date = new Date();
//		System.out.println(date.toString());
//		
//	}
//
//		
//		
//		int a = 11;
//		int b = 6;
//		int c = minFunction(a, b);
//		System.out.println("Minimum value = " + c);
//	
//}
//	public static int minFunction(int n1, int n2) {
//		int min;
//		if (n1 > n2)
//			min = n2;
//		else
//			min = n1;
//		
//		return min;
//		
//	}
	
	int a = 30;
	int b = 45;
	System.out.println("Before swapping, a=" + a + " and b = " + b);
	
	swapFunction(a, b);
	System.out.println("\n**Now, Before and After swapping values will be the same");
	System.out.println("after swap a =" + a + "b =" + b);
	}
	public static void swapFunction(int a, int b) {
		System.out.println("Before swapping (Inside) a = " + a + "b =" + b);
		
		int c = a;
		a = b;
		b = c;
		System.out.println("After swapping (inside), a=" + a + "b = " + b);
	}
}



	


