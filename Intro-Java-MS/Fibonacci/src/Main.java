import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		while (true) {
			int a = 0;
			int b = 1;
			int sum = 1;
			
			System.out.println("enter x");
			int endPoint = scan.nextInt(); // hold the amount of loop times
			
			if(endPoint == -1) {
				break;
			}
			
			for (int i = 0; i < endPoint; i++) {
				sum = a + b;
				a = b;
				b = sum;
			}

			System.out.println("Sum = " + sum);
		}
		scan.close();
	}

}
