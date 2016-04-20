import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int[] weights;
	private static int n, min, result1, result2, sum;

	public static void main(String[] args) throws Exception {
		int tc = readInt();
		for (int _ = 0; _ < tc; ++_) {
			n = readInt();
			if (_ != 0) System.out.println();
			weights = new int[n];
			sum = 0;
			for (int i = 0; i < n; ++i) {
				weights[i] = readInt();
				sum += weights[i];
			}
			min = Integer.MAX_VALUE;
			Arrays.sort(weights);
		}
	}

	private static void solve(int ta, int tb, int noa, int nob) {
		if (sum == weights[i]) {
			if (Math.abs(ta - tb) < min && Math.abs(noa - nob) <= 1) {
				result1 = ta;
				result2 = tb;
				min = Math.abs(ta - tb);
			}
			return;
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
