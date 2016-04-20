import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static BigInteger[] fib = new BigInteger[5001];

	public static void main(String[] args) throws Exception {
		fib[0] = BigInteger.ZERO;
		fib[1] = BigInteger.ONE;
		for (int i = 2; i <= 5000; ++i) {
			fib[i] = new BigInteger(fib[i-1].add(fib[i-2]).toString());
		}
		while (true) {
			try {
				int a = readInt();
				System.out.println("The Fibonacci number for " + a + " is " + fib[a]);
			} catch (Exception e) {
				return;
			}
		}
	}

	private static String readString() throws Exception {
		while (!st.hasMoreTokens()) st = new StringTokenizer(stdin.readLine());
		return st.nextToken();
	}

	private static int readInt() throws Exception {
		return Integer.parseInt(readString());
	}
}
