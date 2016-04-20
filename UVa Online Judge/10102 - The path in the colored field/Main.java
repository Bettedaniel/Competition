import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int n;
	private static int[][] grid;
	private static ArrayList<Integer> starts;
	private static ArrayList<Integer>[] graph;
	private static int[] color;

	public static void main(String[] args) throws Exception {
		while (true) {
			try {
				n = readInt();
				grid = new int[n+2][n+2];
				starts = new ArrayList<Integer>();
				graph = new ArrayList[n*n+1];
				color = new int[n*n+1];
				for (int i = 1; i <= n; ++i) {
					String s = readString();
					for (int j = 1; j <= n; ++j) {
						grid[i][j] = Integer.parseInt(Character.toString(s.charAt(j-1)));
						graph[i+(j-1)*n] = new ArrayList<Integer>();
						if (s.charAt(j-1) == '1') starts.add(i+(j-1)*n);
					}
				}
				for (int i = 1; i <= n; ++i) {
					for (int j = 1; j <= n; ++j) {
						int from = i + (j-1)*n;
						color[from] = grid[i][j];
						for (int a = -1; a <= 2; a += 2) {
							int to1 = (i+a) + (j-1)*n;
							int to2 = i + ((j+a)-1)*n;
							if (grid[i+a][j] != 0) {
								graph[from].add(to1);
								graph[to1].add(from);
								color[to1] = grid[i+a][j];
							}
							if (grid[i][j+a] != 0) {
								graph[from].add(to2);
								graph[to2].add(from);
								color[to2] = grid[i][j+a];
							}
						}
					}
				}
				int max = 0;
				for (Integer i : starts) {
					int temp = bfs(i);
					if (temp > max) {
						max = temp;
					}
				}
				System.out.println(max);
			} catch (Exception e) {
			//	e.printStackTrace();
				return;
			}
		}
	}

	private static int bfs(int start) {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[n*n+1];
		int[] distance = new int[n*n+1];
		queue.add(start);
		visited[start] = true;
		while (!queue.isEmpty()) {
			int u = queue.poll();
			if (color[u] == 3) return distance[u];
			for (Integer v : graph[u]) {
				if (!visited[v]) {
					distance[v] = distance[u] + 1;
					visited[v] = true;
					queue.add(v);
				}
			}
		}
		return 0;
	}

	private static String readString() throws Exception {
		while (!st.hasMoreTokens()) st = new StringTokenizer(stdin.readLine());
		return st.nextToken();
	}

	private static int readInt() throws Exception {
		return Integer.parseInt(readString());
	}
}
