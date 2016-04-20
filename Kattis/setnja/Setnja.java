import java.util.*;
import java.math.BigInteger;

public class Setnja {

	private static String s;

	public static void main(String[] args) {
		BigInteger sum = BigInteger.ZERO;
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			s = sc.next();
			BigInteger[][] dyn = new BigInteger[3][s.length() + 1]; 
			for (int i = 0; i < 3; ++i) {
				for (int j = 0; j < s.length() + 1; ++j) {
					dyn[i][j] = BigInteger.ZERO;	
				}	
			}
			dyn[1][0] = BigInteger.ONE;
			for (int i = 1; i <= s.length(); ++i) {
				if (s.charAt(i-1) == 'L') {
					BigInteger total = BigInteger.ZERO;
					for (int j = 0; j < 3; ++j) {
						if (!dyn[j][i-1].equals(BigInteger.ZERO)) {
							total = total.add(dyn[j][i-1].multiply(BigInteger.valueOf(2)));		
						}
					}
					dyn[0][i] = total;
				} else if (s.charAt(i-1) == 'R') {
					BigInteger total = BigInteger.ZERO;
					for (int j = 0; j < 3; ++j) {
						if (!dyn[j][i-1].equals(BigInteger.ZERO)) {
							total = total.add(dyn[j][i-1].multiply(BigInteger.valueOf(2)).add(BigInteger.ONE));
						}
					}	
					dyn[1][i] = total;
				} else if (s.charAt(i-1) == 'P') {
					for (int j = 0; j < 3; ++j) {
						dyn[j][i] = dyn[j][i-1];	
					}	
				} else {
					for (int j = 0; j < 3; ++j) {
						BigInteger total = BigInteger.ZERO;
						for (int k = 0; k < 3; ++k) {
							if (!dyn[k][i-1].equals(BigInteger.ZERO)) {
								if (j == 2) {
									total = total.add(dyn[k][i-1]);	
								} else if (j == 0) {
									total = total.add(dyn[k][i-1].multiply(BigInteger.valueOf(2)));	
								} else if (j == 1) {
									total = total.add(dyn[k][i-1].multiply(BigInteger.valueOf(2)).add(BigInteger.ONE));	
								}
							}	
						}	
						dyn[j][i] = total;
					}
				}
			}
			sum = sum.add(dyn[0][s.length()].add(dyn[1][s.length()]).add(dyn[2][s.length()]));
			System.out.println(s + "=" + dyn[0][s.length()].add(dyn[1][s.length()]).add(dyn[2][s.length()]));
		}
		System.out.println("Sum=\n" + sum);
	}	
}
