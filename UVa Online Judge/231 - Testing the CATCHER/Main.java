import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static ArrayList<Integer> list;
	private static int[] missiles;
	private static int next, max;

	public static void main(String[] args) throws Exception {
		boolean broke = false;
		int cas = 1;
		while (true) {
			list = new ArrayList<Integer>();
			next = readInt();
			if (broke && next == -1) break;
			while (true) {
				list.add(next);
				next = readInt();
				if (next == -1) {
					broke = true;
					break;
				}
			}
			missiles = new int[list.size()];
			for (int i = 0; i < list.size(); ++i) {
				missiles[i] = list.get(i);
			}
			if (cas != 1) System.out.println();
			int result = solve(missiles, list.size());
			System.out.println("Test #" + cas + ":");
			System.out.println("  maximum possible interceptions: " + result);
			++cas;
		}
	}

	private static int solve(int[] dp, int n) {
		int[] q = new int[n];
		for (int i = 0; i < n; ++i) {
			max = 0;
			for (int j = 0; j <= i; ++j) {
				if (dp[i] < dp[j]) {
					if (q[j] > max) max = q[j];
				}
			}
			q[i] = max+1;
		}
		max = 0;
		for (int i = 0; i < n; ++i) {
			if (q[i] > max) max = q[i];
		}
		return max;
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
