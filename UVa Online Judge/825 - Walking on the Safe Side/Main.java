import java.util.*;
import java.io.*;

public class Main {

	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int n, m;
	private static long[][] grid;

	public static void main(String[] args) throws Exception {
		int tc = readInt();
		for (int _ = 0; _ < tc; ++_) {
			n = readInt();
			m = readInt();
			if (_ != 0) System.out.println();
			grid = new long[n+1][m+1];
			for (int i = 1; i <= n; ++i) {
				StringTokenizer st1 = new StringTokenizer(stdin.readLine());
				int street = Integer.parseInt(st1.nextToken());
				while (st1.hasMoreTokens()) {
					grid[street][Integer.parseInt(st1.nextToken())] = -1;
				}
			}
			for (int i = 1; i <= n; ++i) {
				if (grid[i][1] == -1) break;
				grid[i][1] = 1;
			}
			for (int j = 1; j <= m; ++j) {
				if (grid[1][j] == -1) break;
				grid[1][j] = 1;
			}
			for (int i = 2; i <= n; ++i) {
				for (int j = 2; j <= m; ++j) {
					if (grid[i][j] != -1) {
						if (grid[i-1][j] != -1 && grid[i][j-1] == -1) {
							grid[i][j] = grid[i-1][j];
						} else if (grid[i-1][j] == -1 && grid[i][j-1] != -1) {
							grid[i][j] = grid[i][j-1];
						} else if (grid[i-1][j] != -1 && grid[i][j-1] != -1) {
							grid[i][j] = grid[i-1][j] + grid[i][j-1];
						}
					}
				}
			}
			System.out.println(grid[n][m]);
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
