import java.util.*;
import java.io.*;

public class Main {
	
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int n, k;

	public static void main(String[] args) throws Exception {
		n = readInt();
		k = readInt();
		while (n != 0 || k != 0) {
			System.out.println(binom2((long)n, (long)k));
			n = readInt();
			k = readInt();
		}
	}

	private static long binom2(long n, long k) {
		long result = 1;
		k = Math.min(k, n-k); //Choosing k from n is the same as choosing n-k from n.
		if (k == 0 || n == k) return 1;
		for (long i = 1; i <= k; ++i) {
			result = result * (n-k+i)/i;
		}
		return result;
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
