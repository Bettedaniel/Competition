import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int[] digits = new int[1000000];
	private static boolean[] primes = new boolean[1000000];
	private static int[] digitsPrimes = new int[1000000];

	public static void main(String[] args) throws Exception {
		for (int i = 1; i < 1000000; ++i) {
			digits[i] = digitSum(i);
		}
		Arrays.fill(primes, true);
		primes[0] = false;
		primes[1] = false;
		for (int i = 2; i < 1001; ++i) {
			if (primes[i]) {
				for (int j = 2*i; j < 1000000; j += i) {
					primes[j] = false;
				}
			}
		}
		for (int i = 1; i < 1000000; ++i) {
			if (primes[digits[i]] && primes[i]) {
				digitsPrimes[i] = 1;
			}
		}
		for (int i = 1; i < 1000000; ++i) {
			digitsPrimes[i] += digitsPrimes[i-1];
		}
		StringBuilder sb = new StringBuilder();
		int tc = readInt();
		for (int _ = 0; _ < tc; ++_) {
			int from = readInt();
			int to = readInt();
			int result = digitsPrimes[to] - digitsPrimes[from];
			if (primes[from] && primes[digits[from]]) ++result;
			if (_ != 0) sb.append("\n");
			sb.append(Integer.toString(result));
		}
		System.out.println(sb.toString());
	}

	private static int digitSum(int n) {
		int sum = 0;
		while (n != 0) {
			int p = n % 10;
			sum += p;
			n /= 10;
		}
		return sum;
	}

	private static String readString() throws Exception {
		while (!st.hasMoreTokens()) st = new StringTokenizer(stdin.readLine());
		return st.nextToken();
	}

	private static int readInt() throws Exception {
		return Integer.parseInt(readString());
	}
}
