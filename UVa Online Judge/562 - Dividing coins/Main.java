import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int n, min, sum2;
	private static int[] coins;

	public static void main(String[] args) throws Exception {
		int tc = readInt();
		for (int _ = 0; _ < tc; ++_) {
			n = readInt();
			coins = new int[n];
			int sum = 0;
			for (int i = 0; i < n; ++i) {
				coins[i] = readInt();
				sum += coins[i];
			}
			sum2 = sum/2;
			min = Integer.MAX_VALUE;
			System.out.println("SUM/2: " + sum2 + " SUM: " + sum);
			solve(sum2, 0, "");
			System.out.println(min);
			int temp = sum - sum/2 + min;
			System.out.println(temp);
		}		
	}

	private static void solve(int m, int idx, String s) {
		if (m < 0 || idx > n) return;
		if (m < min) {
			System.out.println(s);
			min = m;
		}
		for (int i = idx; i < n; ++i) {
			if (i < n && coins[i] <= m) solve(m-coins[i], i+1, s + " " + coins[i]);
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
