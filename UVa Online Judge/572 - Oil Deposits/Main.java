import java.util.*;
import java.io.*;

public class Main {

	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int n, m;
	private static boolean[][] grid;
	private static boolean[] visited, vis;
	private static ArrayList<Integer>[] graph;

	public static void main(String[] args) throws Exception {
		n = readInt();
		m = readInt();
		while (n != 0 || m != 0) {
			grid = new boolean[n+2][m+2];
			graph = new ArrayList[n*m + 1];
			visited = new boolean[n*m + 1];
			for (int i = 1; i <= n; ++i) {
				char[] temp = (readString()).toCharArray();
				for (int j = 1; j <= m; ++j) {
					if (temp[j-1] == '@') {
						grid[i][j] = true;
					}
					graph[i + (j - 1)*n] = new ArrayList<Integer>();
				}
			}
			for (int i = 1; i <= n; ++i) {
				for (int j = 1; j <= m; ++j) {
					if (grid[i][j]) {
						visited[i + (j-1)*n] = true;
						for (int a = -1; a < 2; ++a) {
							for (int b = -1; b < 2; ++b) {
								if (!(a == 0 && b == 0)) {
									if (grid[i+a][j+b]) {
										graph[i + (j-1)*n].add((i+a) + ((j+b) - 1)*n);
										visited[(i+a) + ((j+b) - 1)*n] = true;
									}
								}
							}
						}
					}
				}
			}
			vis = new boolean[n*m + 1];
			int result = 0;
			for (int i = 1; i <= n*m; ++i) {
				if (!vis[i] && visited[i]) {
					++result;
					bfs(i);
				}
			}
			System.out.println(result);
			n = readInt();
			m = readInt();
		}
	}

	private static void bfs(int start) {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		vis[start] = true;
		while (!queue.isEmpty()) {
			int u = queue.poll();
			for (Integer v : graph[u]) {
				if (!vis[v]) {
					queue.add(v);
					vis[v] = true;
				}
			}
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
