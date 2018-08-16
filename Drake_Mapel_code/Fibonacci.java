import java.util.Scanner;

public class Fibonacci {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt();
		
		long i;
		long j;
		long sum;
		
		int k; // index in Fibonacci sequence

		while (x != -1) {
			i = 0;
			j = 1;
			
			k = 0;
			sum = 0;
			while (k < x) {
				sum = i + j;
				i = j;
				j = sum;
				
				k++;
			}
			System.out.println(sum);
			x = scan.nextInt();
		}
		
		scan.close();
	}

}
