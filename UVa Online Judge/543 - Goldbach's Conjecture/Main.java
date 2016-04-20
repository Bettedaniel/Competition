import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static boolean[] primes = new boolean[1000000];

	public static void main(String[] args) throws Exception {
		Arrays.fill(primes, true);
		primes[0] = false;
		primes[1] = false;
		for (int i = 2; i <= 1000; ++i) {
			if (primes[i]) {
				for (int j = 2*i; j < 1000000; j += i) {
					primes[j] = false;
				}
			}
		}
		int n = readInt();
		while (n != 0) {
			int a = 3;
			int b = n-3;
			int result1 = 0;
			int result2 = 0;
			for (int i = a; i < n-3; ++i) {
				if (primes[a] && primes[b]) {
					result1 = a;
					result2 = b;
					break;
				}
				++a;
				--b;
			}
			System.out.println(n + " = " + a + " + " + b);
			n = readInt();
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
