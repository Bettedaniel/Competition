import java.util.*;
import java.io.*;

public class Main {

	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int n, m;
	private static char[][] input;
	private static ArrayList<Integer>[] graph;
	private static int[] map;
	private static boolean[] visited;

	public static void main(String[] args) throws Exception {
		int tc = readInt();
		for (int t = 1; t <= tc; ++t) {
			n = readInt();
			m = readInt();
			input = new char[n+2][m+2];
			graph = new ArrayList[n*m + 1];
			map = new int[123];
			visited = new boolean[n*m + 1];
			for (int i = 1; i <= n; ++i) {
				String s = readString();
				for (int j = 1; j <= m; ++j) {
					input[i][j] = s.charAt(j-1);
					graph[i + (j-1)*n] = new ArrayList<Integer>();
				}
			}
			for (int i = 1; i <= n; ++i) {
				for (int j = 1; j <= m; ++j) {
					int from = i + (j-1)*n;
					for (int a = -1; a <= 1; a += 2) {
						if (input[i][j] == input[i+a][j]) {
							int to = (i+a) + (j-1)*n;
							graph[from].add(to);
							graph[to].add(from);
						}
						if (input[i][j] == input[i][j+a]) {
							int to = i + ((j+a)-1)*n;
							graph[from].add(to);
							graph[to].add(from);
						}
					}
				}
			}
			for (int i = 1; i <= n; ++i) {
				for (int j = 1; j <= m; ++j) {
					int start = i + (j-1)*n;
					if (!visited[start]) {
						bfs(start);	
						map[(int)input[i][j]] += 1;
					}
				}
			}
			PriorityQueue<Pair> list = new PriorityQueue<Pair>();
			for (int i = 97; i <= 122; ++i) {
				list.add(new Pair(i, map[i]));
			}
			System.out.println("World #" + t);
			while (!list.isEmpty()) {
				Pair p = list.poll();
				if (p.spoken != 0) System.out.println((char)p.ch + ": " + p.spoken);
			}
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
					queue.add(v);
					visited[v] = true;
				}
			}
		}
	}

	private static class Pair implements Comparable<Pair> {
		int ch, spoken;
		public Pair (int ch, int spoken) {
			this.ch = ch;
			this.spoken = spoken;
		}
		public int compareTo(Pair p) {
			if (spoken == p.spoken) {
				return ch - p.ch;
			}
			return p.spoken - spoken;
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
