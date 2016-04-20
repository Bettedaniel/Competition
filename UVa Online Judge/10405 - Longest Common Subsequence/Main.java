import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int[][] count;

	public static void main(String[] args) throws Exception {
		while (true) {
			try {
				String a = stdin.readLine();
				String b = stdin.readLine();
				if (a == null || b == null) break;
				System.out.println(lcs(a.toCharArray(), b.toCharArray()));
			} catch (Exception e) {
				return;
			}
		}
	}

	private static int lcs(char[] x, char[] y) {
		count = new int[x.length+1][y.length+1];
		for (int i = 1; i <= x.length; ++i) {
			for (int j = 1; j <= y.length; ++j) {
				if (x[i-1] == y[j-1]) {
					count[i][j] = count[i-1][j-1] + 1;
				} else {
					count[i][j] = Math.max(count[i-1][j], count[i][j-1]);
				}
			}
		}
		return count[x.length][y.length];
	}

	private static String readString() throws Exception {
		while (!st.hasMoreTokens()) {
			st = new StringTokenizer(stdin.readLine());
		}
		return st.nextToken();
	}
}
