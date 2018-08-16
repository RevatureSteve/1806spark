
public class ReverseString {
	
	public static void main(String[] args) {
		
		String s = args[0];
		
		if (s.length() > 0) {
			// substring(beginning index, one past ending index), inclusive
			String reverse = s.substring(s.length() - 1, s.length());
			
			for (int i = s.length() - 1; i > 0; i--) {
				reverse = reverse.concat( s.substring(i - 1, i) );
			}
			System.out.print(reverse);
		} else System.out.println("run with a String argument passed to main");
	}

}
