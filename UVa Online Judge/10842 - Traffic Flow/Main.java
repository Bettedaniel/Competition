import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int n, m, min;
	private static ArrayList<Edge>[] edges;

	public static void main(String[] args) throws Exception {
		int tc = readInt();
		for (int t = 1; t <= tc; ++t) {
			n = readInt();
			m = readInt();
			edges = new ArrayList[n];
			for (int i = 0; i < n; ++i) edges[i] = new ArrayList<Edge>();
			for (int i = 0; i < m; ++i) {
				int from = readInt();
				int to = readInt();
				int dist = readInt();
				if (from != to) {
					edges[from].add(new Edge(from, to, dist));
					edges[to].add(new Edge(to, from, dist));
				}
			}
			min = Integer.MAX_VALUE;
			maxspanningtree();
			System.out.println("Case #"+t+": " + min);
		}
	}

	private static void maxspanningtree() {
		PriorityQueue<Edge> queue = new PriorityQueue<Edge>();
		boolean[] visited = new boolean[n];
		queue.add(new Edge(-1, 0, 0));
		int size = 0;
		while (!queue.isEmpty()) {
			Edge u = queue.poll();
			if (!visited[u.to]) {
				++size;
				if (u.from != -1) min = Math.min(u.dist, min);
				if (size == n) return;
				visited[u.to] = true;
				for (Edge e : edges[u.to]) {
					if (!visited[e.to]) {
						queue.add(new Edge(u.to, e.to, e.dist));
					}
				}
			}
		}
	}

	private static class Edge implements Comparable<Edge> {
		int from, to, dist;
		public Edge(int from, int to, int dist) {
			this.from = from;
			this.to = to;
			this.dist = dist;
		}
		public int compareTo(Edge e) {
			return e.dist - dist;
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
