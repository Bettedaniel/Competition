import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int k;

	public static void main(String[] args) throws Exception {
		long tc = readLong();
		for (int _ = 0; _ < tc; ++_) {
			long x = readLong();
			long palindrome = solve(x);
			System.out.println(k + " " + palindrome);
		}
	}

	private static long solve(long n) {
		k = 0;
		while (!isPalindrome(n)) {
			String a = Long.toString(n);
			StringBuilder sb = new StringBuilder();
			for (int i = a.length() - 1; i >= 0; --i) {
				sb.append(Character.toString(a.charAt(i)));
			}
			long temp = Long.parseLong(sb.toString());
			n = n+temp;
			++k;
		}
		return n;
	}

	private static boolean isPalindrome(long n) {
		String a = Long.toString(n);
		for (int i = 0; i < a.length(); ++i) {
			if (a.charAt(i) != a.charAt((a.length() - 1) - i)) return false;
		}
		return true;
	}

	private static String readString() throws Exception {
		while (!st.hasMoreTokens()) st = new StringTokenizer(stdin.readLine());
		return st.nextToken();
	}

	private static long readLong() throws Exception {
		return Long.parseLong(readString());
	}
}
