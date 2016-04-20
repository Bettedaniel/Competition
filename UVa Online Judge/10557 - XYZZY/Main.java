import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static ArrayList<Integer>[] graph, graph2, weights, weights2;
	private static int[] w, energies;
	private static ArrayList<Edge> list;
	private static int n;
	private static boolean infcharge;
	private static boolean[] keep;

	public static void main(String[] args) throws Exception {
		n = readInt();
		while (n != -1) {
			graph = new ArrayList[n+1];
			graph2 = new ArrayList[n+1];
			list = new ArrayList<Edge>();
			weights = new ArrayList[n+1];
			weights2 = new ArrayList[n+1];
			energies = new int[n+1];
			w = new int[n+1];
			for (int i = 0; i <= n; ++i) {
				graph[i] = new ArrayList<Integer>();
				graph2[i] = new ArrayList<Integer>();
				weights[i] = new ArrayList<Integer>();
				weights2[i] = new ArrayList<Integer>();
				w[i] = 100000000;
			}
			w[1] = 0;
			for (int i = 1; i <= n; ++i) {
				int energy = readInt();
				int m = readInt();
				for (int j = 0; j < m; ++j) {
					int to = readInt();
					graph[i].add(to);
					weights[i].add(energy);
				}
			}
			keep = new boolean[n+1];
			keep[n] = true;
			for (int i = 1; i < n; ++i) {
				keep[i] = reachable(i);
			}
			for (int i = 1; i <= n; ++i) {
				if (keep[i]) {
					for (int j = 0; j < graph[i].size(); ++j) {
						if (keep[graph[i].get(j)]) {
							graph2[i].add(graph[i].get(j));
							weights2[i].add(weights[i].get(j));
							list.add(new Edge(i, graph[i].get(j), (-1)*weights[i].get(j)));
						}
					}
				}
			}
			infcharge = bellmanford();
			if (infcharge) System.out.println("winnable");
			else if (w[n] < 100) System.out.println("winnable");
			else System.out.println("hopeless");
			n = readInt();
		}
	}

	private static boolean reachable(int start) {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		boolean[] vis = new boolean[n+1];
		queue.add(start);
		vis[start] = true;
		while (!queue.isEmpty()) {
			int u = queue.poll();
			if (u == n) return true;
			for (Integer v : graph[u]) {
				if (!vis[v]) {
					queue.add(v);
					vis[v] = true;
				}
			}
		}
		return false;
	}

	private static boolean bellmanford() {
		for (int i = 0; i < n; ++i) {
			for (Edge e : list) {
				if (w[e.v] > w[e.u] + e.dist) {
					if (w[e.u] + e.dist < 100) w[e.v] = w[e.u] + e.dist;
				}
			}
		}
		for (Edge e : list) {
			if (w[e.v] > w[e.u] + e.dist) {
				if (w[e.u] + e.dist < 100) return true;
			}
		}
		return false;
	}

	private static class Edge {
		int u, v, dist;
		public Edge(int u, int v, int dist) {
			this.u = u;
			this.v = v;
			this.dist = dist;
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
