import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static boolean[] primes = new boolean[10000001];
	private static String result;

	public static void main(String[] args) throws Exception {
		Arrays.fill(primes, true);
		primes[0] = false;
		primes[1] = false;
		for (int i = 2; i <= 3163; ++i) {
			if (primes[i]) {
				for (int j = 2*i; j <= 10000000; j += i) {
					primes[j] = false;
				}
			}
		}
		while (true) {
			try {
				int n = readInt();
				if (n < 8) System.out.println("Impossible.");
				else if (n == 8) System.out.println("2 2 2 2");
				else {
					System.out.println(solve(n));
				}
			} catch (Exception e) {
			//	e.printStackTrace();
				return;
			}
		}
	}

	private static String solve(int n) {
		StringBuilder sb = new StringBuilder();
		if (n % 2 == 1) {
			sb.append("2 3 ");
			n -= 5;
		} else {
			sb.append("2 2 ");
			n -= 4;
		}
		for (int i = 2; i < n; ++i) {
			if (primes[i] && primes[n-i]) {
				sb.append(""+i+" "+(n-i));
				break;
			}
		}
		return sb.toString();
	}

	private static String readString() throws Exception {
		while (!st.hasMoreTokens()) st = new StringTokenizer(stdin.readLine());
		return st.nextToken();
	}

	private static int readInt() throws Exception {
		return Integer.parseInt(readString());
	}
}
