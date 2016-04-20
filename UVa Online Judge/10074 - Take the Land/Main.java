import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int n, m;
	private static int[][] grid;

	public static void main(String[] args) throws Exception {
		n = readInt(); m = readInt();
		while (n != 0 || m != 0) {
			grid = new int[Math.max(n, m)][Math.max(n, m)];
			for (int i = 0; i < n; ++i) {
				for (int j = 0; j < m; ++j) {
					int a = readInt();
					if (a == 1) {
						grid[i][j] = -1000000;
					} else {
						grid[i][j] = 1;
					}
				}
			}
			System.out.println(maxsum2d());
			n = readInt(); m = readInt();
		}
	}

	private static int maxsum2d() {
		for (int j = 0; j < Math.max(n, m); ++j) {
			for (int i = 0; i < Math.max(n, m); ++i) {
				if (j > 0) {
					grid[j][i] += grid[j-1][i];
				}
			}
		}
		int max = 0;
		for (int i = 0; i < Math.max(n, m); ++i) {
			for (int j = i+1; j < Math.max(n, m); ++j) {
				int sum = 0;
				for (int k = 0; k < Math.max(n, m); ++k) {
					if (i == 0) {
						sum += grid[j][k];
					} else {
						sum += grid[j][k] - grid[i][k];
					}
					if (sum < 0) sum = 0;
					if (sum > max) max = sum;
				}
			}
		}
		return max;
	}

	private static String readString() throws Exception {
		while (!st.hasMoreTokens()) st = new StringTokenizer(stdin.readLine());
		return st.nextToken();
	}

	private static int readInt() throws Exception {
		return Integer.parseInt(readString());
	}
}
