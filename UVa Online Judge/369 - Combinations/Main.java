import java.util.*;
import java.io.*;
import java.math.*;

public class Main {

	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int n, m;

	public static void main(String[] args) throws Exception {
		n = readInt();
		m = readInt();
		while (n != 0 || m != 0) {
			BigInteger bi = binom(BigInteger.valueOf((long)n), BigInteger.valueOf((long)m));
			System.out.println(n + " things taken " + m +  " at a time is " + bi + " exactly.");	
			n = readInt();
			m = readInt();
		}
	}

	private static BigInteger binom(BigInteger n, BigInteger k) {
		if (n.equals(k) || k.equals(BigInteger.ZERO)) return BigInteger.ONE;
		else {
			return (((n.subtract(k)).add(BigInteger.ONE)).multiply(binom(n, k.subtract(BigInteger.ONE)))).divide(k);
		}
	}

	private static String readString() throws Exception {
		while (!st.hasMoreTokens()) {
			st = new StringTokenizer(stdin.readLine());
		}
		return st.nextToken();
	}

	private static int readInt() throws Exception {
		return Integer.parseInt(readString());
	}
}
