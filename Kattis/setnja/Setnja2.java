import java.util.*;
import java.math.BigInteger;

public class Setnja2 {

	private static String s;

	public static void main(String[] args) {
		BigInteger sum = BigInteger.ZERO;
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			s = sc.next();
			BigInteger currentA = BigInteger.ONE;
			BigInteger currentB = BigInteger.ZERO;
			for (int i = s.length() - 1; i >= 0; --i) {
				BigInteger nextA = BigInteger.ZERO;
				BigInteger nextB = BigInteger.ZERO;
				if (s.charAt(i) == '*' || s.charAt(i) == 'P') {
					nextA = nextA.add(currentA);
					nextB = nextB.add(currentB);
				}
				if (s.charAt(i) == '*' || s.charAt(i) == 'L') {
					nextA = nextA.add(currentA);
					nextA = nextA.add(currentA);
					nextB = nextB.add(currentB);	
				}
				if (s.charAt(i) == '*' || s.charAt(i) == 'R') {
					nextA = nextA.add(currentA);	
					nextA = nextA.add(currentA);	
					nextB = nextB.add(currentA);
					nextB = nextB.add(currentB);
				}
			
				currentA = nextA;
				currentB = nextB;	
			}
			System.out.println(currentA.add(currentB));
		}

	}	
}

