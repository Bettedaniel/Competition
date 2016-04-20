import java.util.*;
import java.io.*;

public class Main {
		
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int n;
	private static boolean[][] input;
	private static ArrayList<Integer>[] graph;
	private static boolean[] visited;

	public static void main(String[] args) {
		try {
			int t = 1;
			while (true) {
				n = readInt();
				input = new boolean[n+2][n+2];
				graph = new ArrayList[n*n + 1];
				for (int i = 1; i <= n; ++i) {
					String s = readString();
					for (int j = 1; j <= n; ++j) {
						if (s.charAt(j-1) == '1') {
							input[i][j] = true;
						}
						graph[i + (j-1)*n] = new ArrayList<Integer>();
					}
				}
				for (int i = 1; i <= n; ++i) {
					for (int j = 1; j <= n; ++j) {
						if (input[i][j]) {
							int from = i + (j-1)*n;
							for (int a = -1; a <= 1; ++a) {
								for (int b = -1; b <= 1; ++b) {
									if (!(a == 0 && b == 0)) {
										if (input[i+a][j+b]) {
											int to = (i+a) + ((j+b)-1)*n;
											graph[from].add(to);
											graph[to].add(from);
										}	
									}
								}
							}
						}
					}
				}
				visited = new boolean[n*n + 1];
				int eagles = 0;
				for (int i = 1; i <= n; ++i) {
					for (int j = 1; j <= n; ++j) {
						int start = i + (j-1)*n;
						if (input[i][j] && !visited[start]) {
							bfs(start);
							++eagles;
						}	
					}
				}
				System.out.println("Image number " + t + " contains " + eagles + " war eagles.");
				++t;
			}
		} catch (Exception e) {
		//	e.printStackTrace();
			return;
		}
	}

	private static void bfs(int start) {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		visited[start] = true;
		while (!queue.isEmpty()) {
			int u = queue.poll();
			for (Integer v : graph[u]) {
				if (!visited[v]) {
					visited[v] = true;
					queue.add(v);
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
