import java.util.*;
import java.io.*;

public class Main {

	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int max = 10000 * 10000 + 10000 + 41;
	private static boolean[] primes = new boolean[10001];
	private static int[] sum = new int[10001];

	public static void main(String[] args) {
		for (int i = 0; i <= 10000; ++i) {
			if (isPrime(i * i + i + 41)) {
				primes[i] = true;
			}
		}
		for (int i = 0; i <= 10000; ++i) {
			if (primes[i]) sum[i] = 1;
		}
		for (int i = 1; i <= 10000; ++i) {
			sum[i] += sum[i-1];
		}
		try {
			while (true) {
				int a = readInt();
				int b = readInt();
				int no = sum[b] - sum[a];
				if (primes[a]) no += 1;
				int div = b - a + 1;
				double res = (double)(no/((double)div));
				res *= 100;
				System.out.printf("%.2f\n", res);
			}
		} catch (Exception e) {
			return;
		}
	}

	private static boolean isPrime(int p) {
		for (int i = 2; i <= Math.sqrt(p); ++i) {
			if (p%i == 0) return false;
		}
		return true;
	}

	private static String readString() throws Exception {
		while(!st.hasMoreTokens()) {
			st = new StringTokenizer(stdin.readLine());
		}
		return st.nextToken();
	}

	private static int readInt() throws Exception {
		return Integer.parseInt(readString());
	}
}
