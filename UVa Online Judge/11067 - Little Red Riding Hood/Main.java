import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int n, m;
	private static long[][] grid;

	public static void main(String[] args) throws Exception {
		n = readInt();
		m = readInt();
		while (n != 0 && m != 0) {
			grid = new long[n+1][m+1];
			int w = readInt();
			for (int i = 0; i < w; ++i) {
				int x = readInt();
				int y = readInt();
				grid[x][y] = -1;
			}
			paths();
		//	print();
			long result = grid[n][m];
			if (result == 0) {
				System.out.println("There is no path.");
			} else if (result == 1) {
				System.out.println("There is one path from Little Red Riding Hood's house to her grandmother's house.");
			} else {
				System.out.println("There are "+ result +" paths from Little Red Riding Hood's house to her grandmother's house.");
			}
			n = readInt();
			m = readInt();
		}
	}

	private static void paths() {
		for (int i = 0; i <= n; ++i) {
			if (grid[i][0] != -1) {
				grid[i][0] = 1;
			} else {
				break;
			}
		}
		for (int i = 0; i <= m; ++i) {
			if (grid[0][i] != -1) {
				grid[0][i] = 1;
			} else break;
		}
		for (int i = 1; i <= n; ++i) {
			for (int j = 1; j <= m; ++j) {
				if (grid[i][j] != -1) {
					if (grid[i-1][j] == -1 && grid[i][j-1] != -1) {
						grid[i][j] = grid[i][j-1];
					} else if (grid[i-1][j] != -1 && grid[i][j-1] == -1) {
						grid[i][j] = grid[i-1][j];
					} else if (grid[i-1][j] != -1 && grid[i][j-1] != -1) {
						grid[i][j] = grid[i-1][j] + grid[i][j-1];
					} 
				}
			}
		}
	}

	private static void print() {
		for (int i = 0; i <= n; ++i) {
			for (int j = 0; j <= m; ++j) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static String readString() throws Exception {
		while (!st.hasMoreTokens()) st = new StringTokenizer(stdin.readLine());
		return st.nextToken();
	}

	private static int readInt() throws Exception {
		return Integer.parseInt(readString());
	}
}
