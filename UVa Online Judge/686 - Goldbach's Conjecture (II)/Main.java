import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static boolean[] primes = new boolean[32769];

	public static void main(String[] args) throws Exception {
		Arrays.fill(primes, true);
		primes[0] = false;
		primes[1] = false;
		for (int i = 2; i < 183; ++i) {
			if (primes[i]) {
				for (int j = 2*i; j < 32769; j += i) {
					primes[j] = false;
				}
			}
		}
		int n = readInt();
		while (n != 0) {
			int b = n-2;
			int result = 0;
			for (int a = 2; a <= b; ++a) {
				if (primes[a] && primes[b]) {
					++result;
				}
				--b;
			}
			System.out.println(result);
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
