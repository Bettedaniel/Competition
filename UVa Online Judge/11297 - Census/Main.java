import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int n, m, min, max;
	private static int[][] numbers = new int[501][501];

	public static void main(String[] args) throws Exception {
		n = readInt();
		m = readInt();
		for (int i = 1; i <= n; ++i) {
			for (int j = 1; j <= m; ++j) {
				numbers[i][j] = readInt();	
			}
		}
		int q = readInt();
		for (int i = 0; i < q; ++i) {
			String s = readString();
			if (s.equals("q")) {
				int x1 = readInt();
				int y1 = readInt();
				int x2 = readInt();
				int y2 = readInt();
				min = Integer.MAX_VALUE;
				max = 0;
				solve(x1, y1, x2, y2);
				System.out.println(max + " " + min);
			} else {
				int x = readInt();
				int y = readInt();
				int v = readInt();
				numbers[x][y] = v;
			}
		}
	}

	private static void solve(int x1, int y1, int x2, int y2) {
		for (int i = x1; i <= x2; ++i) {
			for (int j = y1; j <= y2; ++j) {
				min = Math.min(min, numbers[i][j]);
				max = Math.max(max, numbers[i][j]);
			}
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
