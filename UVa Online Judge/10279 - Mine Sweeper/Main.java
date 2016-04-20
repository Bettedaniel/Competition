import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int n;
	private static char[][] layout;
	private static boolean[][] clicked;
	private static int[][] result;
	private static int[] xs = {-1, -1, -1, 0, 1, 1, 1, 0};
	private static int[] ys = {-1, 0, 1, 1, 1, 0, -1, -1};
	private static boolean lost;

	public static void main(String[] args) throws Exception {
		int tc = readInt();
		for (int t = 0; t < tc; ++t) {
			if (t != 0) System.out.println();
			n = readInt();
			layout = new char[n+2][n+2];
			for (int i = 1; i <= n; ++i) {
				String s = readString();
				for (int j = 1; j <= n; ++j) {
					layout[i][j] = s.charAt(j-1);
				}
			}
			lost = false;
			clicked = new boolean[n+2][n+2];
			result = new int[n+2][n+2];
			for (int i = 1; i <= n; ++i) {
				String s = readString();
				for (int j = 1; j <= n; ++j) {
					if (s.charAt(j-1) == 'x') {
						clicked[i][j] = true;
						if (layout[i][j] == '*') lost = true;
					}
				}
			}
			for (int i = 1; i <= n; ++i) {
				for (int j = 1; j <= n; ++j) {
					if (clicked[i][j]) {
						for (int k = 0; k < 8; ++k) {
							int x = i+xs[k];
							int y = j+ys[k];
							if (layout[x][y] == '*') {
								++result[i][j];
							}
						}
					}
				}
			}
			for (int i = 1; i <= n; ++i) {
				for (int j = 1; j <= n; ++j) {
					if (clicked[i][j]) {
						if (layout[i][j] == '*') System.out.print("*");
						else System.out.print(result[i][j]);
					} else {
						if (lost && layout[i][j] == '*') System.out.print("*");
						else System.out.print(".");
					}
				}
				System.out.println();
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
