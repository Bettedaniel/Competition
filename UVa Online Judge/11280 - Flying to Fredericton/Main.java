import java.util.*;
import java.io.*;

public class Main {

	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int n, max;
	private static HashMap<String, Integer> map;
	private static int[][] costs, dp;
	private static ArrayList<Integer> queries;

	public static void main(String[] args) throws Exception {
		int ts = readInt();
		for (int t = 1; t <= ts; ++t) {
			if (t != 1) System.out.println();
			n = readInt();
			map = new HashMap<String, Integer>();
			costs = new int[n][n];
			for (int i = 0; i < n; ++i) {
				map.put(readString(), i);
				Arrays.fill(costs[i], 100000000);
			}
			int m = readInt();
			for (int i = 0; i < m; ++i) {
				String from = readString();
				String to = readString();
				int cost = readInt();
				costs[map.get(from)][map.get(to)] = Math.min(costs[map.get(from)][map.get(to)], cost);
			}
			queries = new ArrayList<Integer>();
			max = 0;
			int q = readInt();
			for (int i = 0; i < q; ++i) {
				int a = readInt();
				max = Math.max(a, max);
				queries.add(a);
			}
			dp = new int[n][max+2];
			for (int i = 1; i < n; ++i) dp[i][0] = 100000000;
			for (int s = 1; s <= max + 1; ++s) {
				for (int k = 0; k < n; ++k) {
					int min = 100000000;
					for (int i = 0; i < n; ++i) {
						min = Math.min(min, dp[i][s-1] + costs[i][k]);
					}
					dp[k][s] = min;
				}
			}
			System.out.println("Scenario #" + t);
			for (Integer i : queries) {
//				int result = dp[n-1][i+1];
				int min = Integer.MAX_VALUE;
				for (int j = 0; j <= i+1; ++j) {
					min = Math.min(min, dp[n-1][j]);
				}
				if (min != 100000000) System.out.println("Total cost of flight(s) is $" + min);
				else System.out.println("No satisfactory flights");
			}
		/*	for (int i = 0; i < n; ++i) {
				for (int j = 0; j <= max+1; ++j) {
					if (dp[i][j] != 100000000) System.out.print(dp[i][j] + " ");
					else System.out.print("oo ");
				}
				System.out.println();
			}
			System.out.println(); */
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
