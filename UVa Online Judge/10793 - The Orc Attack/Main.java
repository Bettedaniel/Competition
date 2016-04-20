import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int[][] weights;
	private static int n, m;

	public static void main(String[] args) throws Exception {
		int tc = readInt();
		for (int t = 1; t <= tc; ++t) {
			n = readInt();
			m = readInt();
			weights = new int[n+1][n+1];
			for (int i = 0; i <= n; ++i) {
				Arrays.fill(weights[i], 1000000000);
				weights[i][i] = 0;
			}
			for (int i = 0; i < m; ++i) {
				int from = readInt();
				int to = readInt();
				int dist = readInt();
				weights[from][to] = Math.min(weights[from][to], dist);
				weights[to][from] = Math.min(weights[from][to], dist);
			}
			floydwarshall();
			ArrayList<Integer> list = new ArrayList<Integer>();
			int min = Integer.MAX_VALUE;
			for (int i = 1; i <= n; ++i) {
				if (weights[1][i] == weights[2][i] && weights[2][i] == weights[3][i] && weights[3][i] == weights[4][i] && weights[4][i] == weights[5][i]) {
					list.add(i);		
				}
			}	
			for (Integer j : list) {
				int max = 0;
				for (int i = 1; i <= n; ++i) {
					if (i != j) {
						if (weights[i][j] > max) {
							max = weights[i][j];
						}
					}
				}
				if (max < min) {
					min = max;
				}
			}
			if (min < 1000000000) System.out.println("Map " + t + ": " + min);
			else System.out.println("Map " + t + ": -1");
		}
	}

	private static void floydwarshall() {
		for (int k = 1; k <= n; ++k) {
			for (int i = 1; i <= n; ++i) {
				for (int j = 1; j <= n; ++j) {
					weights[i][j] = Math.min(weights[i][j], weights[i][k] + weights[j][k]);
				}
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
