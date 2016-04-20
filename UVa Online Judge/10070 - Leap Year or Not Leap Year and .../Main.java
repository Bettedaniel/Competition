import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");

	public static void main(String[] args) throws Exception {
		int i = 0;
		while (true) {
			try {
				boolean leap = false;
				boolean hulu = false;
				boolean bulu = false;
				String n = readString();
				BigInteger bi = new BigInteger(n);
				if (i != 0) System.out.println();
				if ((bi.mod(new BigInteger("4")) == BigInteger.ZERO && bi.mod(new BigInteger("100")) != BigInteger.ZERO) || bi.mod(new BigInteger("400")) == BigInteger.ZERO) {
					leap = true;
					System.out.println("This is leap year.");
				}
				if (bi.mod(new BigInteger("15")) == BigInteger.ZERO) {
					System.out.println("This is huluculu festival year.");
					hulu = true;
				}
				if (leap && bi.mod(new BigInteger("55")) == BigInteger.ZERO) {
					System.out.println("This is bulukulu festival year.");
					bulu = true;
				}
				if (!leap && !hulu && !bulu) System.out.println("This is an ordinary year.");
				i = 1;
			} catch (Exception e) {
		//		e.printStackTrace();
				return;
			}
		}
	}

	private static String readString() throws Exception {
		while (!st.hasMoreTokens()) {
			st = new StringTokenizer(stdin.readLine());
		}
		return st.nextToken();
	}
}
