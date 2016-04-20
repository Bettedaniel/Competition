import java.util.*;
import java.io.*;

public class Main {

	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static String a, b;

	public static void main(String[] args) throws Exception {
		a = stdin.readLine();
		int t = 1;
		while (!a.equals("#")) {
			b = stdin.readLine();
			System.out.println("Case #" + t + ": you can visit at most " + lcs(a.toCharArray(), b.toCharArray()) + " cities.");
			a = stdin.readLine();
			++t;
		}
	}

	private static int lcs(char[] x, char[] y) {
		int[][] count = new int[x.length + 1][y.length + 1];
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
}
