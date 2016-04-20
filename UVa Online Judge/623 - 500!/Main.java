import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");

	public static void main(String[] args) throws Exception {
		while (true) {
			try {
				int n = readInt();
				System.out.println(n + "!");
				System.out.println(compute(n));
			} catch (Exception e) {
		//		e.printStackTrace();
				return;
			}
		}	
	}

	private static String compute(int n) {
		BigInteger value = BigInteger.ONE;
		for (int i = 2; i <= n; ++i) {
			value = value.multiply(BigInteger.valueOf((long)i));
		}
		return value.toString();
	}

	private static String readString() throws Exception {
		while (!st.hasMoreTokens()) st = new StringTokenizer(stdin.readLine());
		return st.nextToken();
	}

	private static int readInt() throws Exception {
		return Integer.parseInt(readString());
	}
}
