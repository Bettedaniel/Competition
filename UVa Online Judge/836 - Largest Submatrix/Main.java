import java.util.*;
import java.io.*;

public class Main {

	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int n;
	private static int[][] matrix = new int[25][25];

	public static void main(String[] args) throws Exception {
		int tc = readInt();
		stdin.readLine();
		for (int _ = 0; _ < tc; ++_) {
			String s = stdin.readLine();
			int j = 0;
			while (s != null && !s.equals("")) {
				char[] temp = s.toCharArray();
				n = temp.length;
				for (int i = 0; i < n; ++i) {
					matrix[i][j] = 1 - Integer.parseInt(Character.toString(temp[i]));
				}
				s = stdin.readLine();
				++j;
			}
			solve();
			if (_ < tc-1) System.out.println();
		}
	}

	private static void solve() {
		int max = 0;
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				for (int k = i; k < n; ++k) {
					for (int l = j; l < n; ++l) {
						if (rect(i, k, j, l) == 0) {
							int sum = ((k+1)-i)*((l+1)-j);
							if (sum > max) max = sum;
						}
					}
				}
			}
		}
		System.out.println(max);
	}

	private static int rect(int a, int b, int c, int d) {
		int sum = 0;
		for (int i = a; i <= b; ++i) {
			for (int j = c; j <= d; ++j) {
				sum += matrix[i][j];
			}
		}
		return sum;
	}

	private static String readString() throws Exception {
		while (!st.hasMoreTokens()) st = new StringTokenizer(stdin.readLine());
		return st.nextToken();
	}

	private static int readInt() throws Exception {
		return Integer.parseInt(readString());
	}
}
