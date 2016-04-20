import java.util.*;
import java.io.*;

public class Main {

	private static int n, m;
	private static long[][] input;
	private static boolean[][] visited;
	private static Triple[][] dp;
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");

	public static void main(String[] args) {
		try {
			while (true) {
				n = readInt();
				m = readInt();
				input = new long[n][m];
				dp = new Triple[n][m];
				for (int i = 0; i < n; ++i) {
					for (int j = 0; j < m; ++j) {
						input[i][j] = readLong();
					}
				}
				for (int i = 0; i < n; ++i) {
					dp[i][m-1] = new Triple(i, m-1, input[i][m-1]);
				}
				if (n > 1) {
					for (int j = m-2; j >= 0; --j) {
						for (int i = 0; i < n; ++i) {
							int a = i-1;
							if (a == -1) a = n-1;
							long w = Math.min(dp[a][j+1].value, Math.min(dp[i][j+1].value, dp[(i+1)%n][j+1].value)) + input[i][j];
							dp[i][j] = new Triple(i, j, w);
						}
					}
					long min = Long.MAX_VALUE;
					int mini = 0;
					for (int i = 0; i < n; ++i) {
						if (min > dp[i][0].value) {
							min = dp[i][0].value;
							mini = i;
						}
					}
					int x = mini;
					int y = 0;
					System.out.print(mini + 1);
					while (y != m-1) {
						int a = x-1;
						if (a == -1) a = n-1;
						long v1 = dp[a][y+1].value;
						long v2 = dp[x][y+1].value;
						long v3 = dp[(x+1)%n][y+1].value;
						long comp = dp[x][y].value - input[x][y];
						if (comp == v1 && comp != v2 && comp != v3) {
							x = a;
						} else if (comp == v2 && comp != v1 && comp != v3) {
							x = x;
						} else if (comp == v3 && comp != v1 && comp != v2) {
							x = (x+1)%n;
						} else if (comp == v1 && comp == v2 && comp != v3) {
							x = Math.min(a, x);
						} else if (comp == v2 && comp == v3 && comp != v1) {
							x = Math.min(x, (x+1)%n);
						} else if (comp == v3 && comp == v1 && comp != v2) {
							x = Math.min(a, (x+1)%n);
						} else {
							x = Math.min(a, Math.min(x, (x+1)%n));
						}
						y = y+1;
						System.out.print(" " + (x+1));
					}
					System.out.println();
					System.out.println(min);
				} else {
					long result = 0;
					for (int i = 0; i < m; ++i) {
						if (i == m-1) System.out.println(1);
						else System.out.print(1 + " ");
						result += input[0][i];
					}
					System.out.println(result);
				}
			}
		} catch (Exception e) {
		//	e.printStackTrace();
			return;
		}
	}

	private static class Triple {
		long x, y, value;
		Triple pre;
		public Triple(long x, long y, long v) {
			this.x = x;
			this.y = y;
			value = v;
		}
	}

/*	private static class ForSort implements Comparable<ForSort> {
		String list;
		public ForSort(String list) {
			this.list = list;
		}

		public String toString() {return list;}

		public int compareTo(ForSort f) {
			StringTokenizer st1 = new StringTokenizer(list);
			StringTokenizer st2 = new StringTokenizer(f.list);
			for (int i = 0; i < list.length(); ++i) {
				int a = Integer.parseInt(st1.nextToken());
				int b = 0;
				try {
					b = Integer.parseInt(st2.nextToken());
				} catch (Exception e) {
					return -1;
				}
				if (a == b) continue;
				else return a - b;
			}
			return 1;
		}
	}
*/
	private static String readString() throws Exception {
		while (!st.hasMoreTokens()) {
			st = new StringTokenizer(stdin.readLine());
		}
		return st.nextToken();
	}

	private static int readInt() throws Exception {
		return Integer.parseInt(readString());
	}

	private static long readLong() throws Exception {
		return Long.parseLong(readString());
	}
}
