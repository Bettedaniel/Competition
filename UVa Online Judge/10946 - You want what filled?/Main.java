import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int n, m;
	private static char[][] grid;
	private static ArrayList<Integer>[] graph;
	private static boolean[] visited;

	public static void main(String[] args) throws Exception {
		n = readInt();
		m = readInt();
		int t = 1;
		while (n != 0 || m != 0) {
			grid = new char[n+2][m+2];
			graph = new ArrayList[n*m + 1];
			for (int i = 1; i <= n; ++i) {
				String s = readString();
				for (int j = 1; j <= m; ++j) {
					grid[i][j] = s.charAt(j-1);
					graph[i + (j-1)*n] = new ArrayList<Integer>();
				}
			}
			visited = new boolean[n*m + 1];
			for (int i = 1; i <= n; ++i) {
				for (int j = 1; j <= m; ++j) {
					int pos = i + (j-1)*n;
					char c = grid[i][j];
					if (c == '.') {
						visited[pos] = true;
						continue;
					}
					for (int a = -1; a <= 1; a += 2) {
						if (grid[i+a][j] == c) {
							int pos1 = (i+a) + (j-1)*n;
							graph[pos].add(pos1);
							graph[pos1].add(pos);
						}
						if (grid[i][j+a] == c) {
							int pos1 = i + ((j+a)-1)*n;
							graph[pos].add(pos1);
							graph[pos1].add(pos);
						}
					}
				}
			}
			ArrayList<Pair> results = new ArrayList<Pair>();
			for (int i = 1; i <= n; ++i) {
				for (int j = 1; j <= m; ++j) {
					int pos = i + (j-1)*n;
					char c = grid[i][j];
					if (!visited[pos]) {
						int size = bfs(pos);
						results.add(new Pair(c, size));
					}
				}
			}
			Collections.sort(results);
			System.out.println("Problem " + t + ":");
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < results.size(); ++i) {
				Pair p = results.get(i);
				if (i != results.size()-1) sb.append(p.c + " " + p.size + "\n");
				else sb.append(p.c + " " + p.size);
			}
			System.out.println(sb.toString());
			n = readInt(); m = readInt();
			++t;
		}
	}

	private static int bfs(int start) {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		visited[start] = true;
		int size = 0;
		queue.add(start);
		while (!queue.isEmpty()) {
			int u = queue.poll();
			++size;
			for (Integer v : graph[u]) {
				if (!visited[v]) {
					visited[v] = true;
					queue.add(v);
				}
			}
		}
		return size;
	}

	private static class Pair implements Comparable<Pair> {
		char c;
		int size;
		public Pair (char c, int size) {
			this.c = c;
			this.size = size;
		}
		public int compareTo(Pair p) {
			if (size == p.size) return (int)c - (int)p.c;
			return p.size - size;
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
