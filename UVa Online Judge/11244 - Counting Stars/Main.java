import java.util.*;
import java.io.*;

public class Main {

	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int r, c;

	public static void main(String[] args) throws Exception {
		r = readInt();
		c = readInt();
		while (r != 0 || c != 0) {
			boolean[][] grid = new boolean[r+2][c+2];
			for (int i = 1; i <= r; ++i) {
				String s = readString();
				char[] charray = s.toCharArray();
				for (int j = 1; j <= c; ++j) {
					if (charray[j-1] == '*') {
						grid[i][j] = true;
					}
				}
			}
			int result = 0;
			boolean add = true;
			for (int i = 1; i < r+1; ++i) {
				for (int j = 1; j < c+1; ++j) {
					if (grid[i][j]) {
						add = true;
						for (int a = -1; a < 2; ++a) {
							for (int b = -1; b < 2; ++b) {
								if (a != 0 || b != 0) {
									if (grid[i+a][b+j]) {
										add = false;
									}
								}
							}
						}
						if (add) ++result;
					}
				}
			}
			System.out.println(result);
			r = readInt();
			c = readInt();
		}
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
