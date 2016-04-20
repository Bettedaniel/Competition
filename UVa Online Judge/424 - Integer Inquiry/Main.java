import java.util.*;
import java.math.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");

	public static void main(String[] args) throws Exception {
		String s = readString();
		BigInteger sum = new BigInteger("0");
		while (!s.equals("0")) {
			sum = sum.add(new BigInteger(s));
			s = readString();
		}
		System.out.println(sum);
	}

	private static String readString() throws Exception {
		while (!st.hasMoreTokens()) {
			st = new StringTokenizer(stdin.readLine());
		}
		return st.nextToken();
	}
}
