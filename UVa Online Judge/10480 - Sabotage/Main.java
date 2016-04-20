import java.util.*;
import java.io.*;

public class Main {

	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int n, m, temp;
	private static ArrayList<Integer>[] graph;
	private static int[][] weights, residual;
	private static int[] parent;
	private static ArrayList<Pair> results;

	public static void main(String[] args) throws Exception {
		n = readInt();
		m = readInt();
		while (n != 0 || m != 0) {
			graph = new ArrayList[n+1];
			weights = new int[n+1][n+1];
			for (int i = 1; i <= n; ++i) graph[i] = new ArrayList<Integer>();
			for (int i = 0; i < m; ++i) {
				int from = readInt();
				int to = readInt();
				int w = readInt();
				graph[from].add(to);
				graph[to].add(from);
				weights[from][to] = w;
				weights[to][from] = w;
			}
			results = new ArrayList<Pair>();
			int result = maxflow();
			System.out.println(result);
			n = readInt();
			m = readInt();
		}
	}

	private static int maxflow() {
		residual = new int[n+1][n+1];
		int flow = 0;
		while (true) {
			temp = 0;
			bfs();
			if (temp == 0) break;
			flow += temp;
			int v = 2;
			while (v != 1) {
				int u = parent[v];
				residual[u][v] += temp;
				residual[v][u] -= temp;
				v = u;
			}
		}
		return flow;
	}

	private static void bfs() {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		parent = new int[n+1];
		for (int i = 0; i <= n; ++i) {
			parent[i] = -1;
		}
		parent[1] = -2;
		int[] ran = new int[n+1];
		ran[1] = Integer.MAX_VALUE;
		queue.add(1);
		while (!queue.isEmpty()) {
			int u = queue.poll();
			for (Integer v : graph[u]) {
				if (weights[u][v] - residual[u][v] > 0 && parent[v] == -1) {
					parent[v] = u;
					ran[v] = Math.min(ran[u], weights[u][v] - residual[u][v]);
					if (v != 2) {
						queue.add(v);
					} else {
						temp = ran[v];
						return;
					}
				}
			}
		}
		temp = 0;
	}

	private static class Pair {
		int a, b;
		public Pair(int a, int b) {
			this.a = a;
			this.b = b;
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
