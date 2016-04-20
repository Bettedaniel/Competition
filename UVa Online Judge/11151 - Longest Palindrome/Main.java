import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int n, size;

	public static void main(String[] args) throws Exception {
		n = readInt();
		for (int i = 0; i < n; ++i) {
			String s = "_" + stdin.readLine();
			if (s.equals("")) System.out.println(0);
			else {
				StringBuilder sb = new StringBuilder();
				size = s.length();
				sb.append("_");
				for (int j = s.length() - 1; j >= 1; --j) {
					sb.append(s.charAt(j));
				}
			//	System.out.println(s + " " + sb.toString());
				System.out.println(lcs(s.toCharArray(), sb.toString().toCharArray()));
			}
		}
	}

	private static int lcs(char[] x, char[] y) {
		int[][] grid = new int[size][size];
	//	for (int i = 0; i < size; ++i) System.out.println(x[i] + " " + y[i]);
		for (int i = 1; i < size; ++i) {
			for (int j = 1; j < size; ++j) {
				if (x[i] == y[j]) {
					grid[i][j] = grid[i-1][j-1] + 1;
				} else {
					grid[i][j] = Math.max(grid[i][j-1], grid[i-1][j]);
				}
			}
		}
		return grid[size-1][size-1];
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
