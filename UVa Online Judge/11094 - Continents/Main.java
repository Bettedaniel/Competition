import java.util.*;
import java.io.*;

public class Main {
	
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int n, m, bad1, bad2, mijid;
	private static char land;
	private static char[][] inputo;
	private static boolean[] visited;
	private static ArrayList<Integer>[] graph;

	public static void main(String[] args) throws Exception {
		try {
			while (true) {
				m = readInt();
				n = readInt();
				inputo = new char[m+2][n+2];
				graph = new ArrayList[n*m + 1];
				visited = new boolean[n*m+1];
				for (int i = 1; i <= m; ++i) {
					String s = readString();
					for (int j = 1; j <= n; ++j) {
						inputo[i][j] = s.charAt(j-1);	
						graph[i + (j-1)*m] = new ArrayList<Integer>();
					}
				}
				bad1 = readInt() + 1;
				bad2 = readInt() + 1;
				land = inputo[bad1][bad2];
				mijid = bad1 + (bad2-1)*m;
				for (int i = 1; i <= m; ++i) {
					for (int j = 1; j <= n; ++j) {
						int from = i + (j-1)*m;
						if (inputo[i][j] == land) {
							for (int a = -1; a <= 1; a += 2) {
								if (inputo[i+a][j] == land) {
									int to = (i+a) + (j-1)*m;
									graph[from].add(to);
									graph[to].add(from);
								}
								int k = j+a;
								if (j+a < 1) k = n;
								else if (j+a > n) k = 1;
								if (inputo[i][k] == land) {
									int to = i + (k - 1)*m;
									graph[from].add(to);
									graph[to].add(from);
								}
							}
						}
					}
				}
				int max = 0;
				for (int i = 1; i <= m; ++i) {
					for (int j = 1; j <= n; ++j) {
						int t = i + (j-1)*m;
						if (!visited[t] && inputo[i][j] == land) {
							int temp = bfs(t);
							max = Math.max(max, temp);
						}
					}
				}
				System.out.println(max);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}

	private static int bfs(int start) {
		visited[start] = true;
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		int size = 0;
		int result = -1;
		while (!queue.isEmpty()) {
			int u = queue.poll();
			++size;
			if (u == mijid) result = 0;
			for (Integer v : graph[u]) {
				if (!visited[v]) {
					visited[v] = true;
					queue.add(v);
				}
			}
		}
		if (result == -1) result = size;
		return result;
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

	private static void print() {
		for (int i = 1; i <= n; ++i) {
			for (int j = 1; j <= m; ++j) {
				System.out.print(inputo[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
