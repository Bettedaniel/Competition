import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static boolean[] primes = new boolean[2002];
	private static int[] frequency; 

	public static void main(String[] args) throws Exception {
		Arrays.fill(primes, true);
		primes[0] = false;
		primes[1] = false;
		for (int i = 2; i <= 2001; ++i) {
			if (primes[i]) {
				for (int j = 2*i; j <= 2001; j+=i) {
					primes[j] = false;
				}
			}
		}
		int tc = readInt();
		for (int t = 1; t <= tc; ++t) {
			String s = readString();
			frequency = new int[123];
			char[] temp = s.toCharArray();
			for (int i = 0; i < s.length(); ++i) {
				++frequency[(int)temp[i]];
			}
			StringBuilder result = new StringBuilder();
			for (int i = 0; i <= 122; ++i) {
				if (primes[frequency[i]]) {
					result.append((char)i);
				}
			}
			if (result.toString().length() > 0) System.out.println("Case " + t + ": " + result.toString());
			else System.out.println("Case " + t + ": empty");
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
