import java.util.*;
import java.io.*;

public class Main {

	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static char[][] input;
	private static boolean[][] checker;

	public static void main(String[] args) throws Exception {
		int t = readInt();
		for (int c = 1; c <= t; ++c) {
			int n = readInt();
			input = new char[n+2][n+2];
			checker = new boolean[n+2][n+2];
			for (int i = 1; i <= n; ++i) {
				String s = readString();
				char[] temp = s.toCharArray();
				for (int j = 1; j <= n; ++j) {
					input[i][j] = temp[j-1];
				}
			}
			int result = 0;
			for (int i = 1; i <= n; ++i) {
				for (int j = 1; j <= n; ++j) {
					String s1 = "";
					String s2 = "";
					if ((input[i][j] == 'x' || input[i][j] == '@') && !checker[i][j]) {
						for (int k = i; k <= Math.min(n, (i + n/2)); ++k) {
							if (input[k][j] == '.' || checker[k][j]) break;
							s1 += Character.toString(input[k][j]);
							if (k != i) checker[k][j] = true;
						}
						for (int k = j; k <= Math.min(n, (j + n/2)); ++k) {
							if (input[i][k] == '.' || checker[i][k]) break;
							s2 += Character.toString(input[i][k]);
							if (k != j) checker[i][k] = true;
						}
						checker[i][j] = true;
					}
				//	if (s1.length() > 0) System.out.println("s1: " + s1);
				//	if (s2.length() > 0) System.out.println("s2: " + s2);
					if (s1.length() > 1 && s2.length() > 1 && s2.contains("x") && s1.contains("x")) result += 2;
					else if (s1.length() == 1 && s2.length() > 1 && s2.contains("x")) ++result;
					else if (s2.length() == 1 && s1.length() > 1 && s1.contains("x")) ++result;
					else if (s1.length() == 1 && s2.length() == 1 && s1.contains("x")) ++result; 
				}
			}
			System.out.println("Case " + c + ": " + result);
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
