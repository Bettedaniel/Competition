import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int n, m;

	public static void main(String[] args) throws Exception {
		n = readInt();
		m = readInt();
		int t = 1;
		while (n != 0 || m != 0) {
			int[] t1 = new int[n+1];
			int[] t2 = new int[m+1];
			for (int i = 1; i <= n; ++i) {
				t1[i] = readInt();
			}
			for (int i = 1; i <= m; ++i) {
				t2[i] = readInt();
			}
			System.out.println("Twin Towers #" + t);
			System.out.println("Number of Tiles : " + lcs(t1, t2));
			System.out.println();
			++t;
			n = readInt();
			m = readInt();
		}
	}

	private static int lcs(int[] x, int[] y) {
		int[][] count = new int[n+1][m+1];
		for (int i = 1; i <= n; ++i) {
			for (int j = 1; j <= m; ++j) {
				if (x[i] == y[j]) {
					count[i][j] = count[i-1][j-1] + 1;
				} else {
					count[i][j] = Math.max(count[i-1][j], count[i][j-1]);
				}
			}
		}
		return count[n][m];
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
