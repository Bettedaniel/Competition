import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
//	private static PrintStream out = new PrintStream(System.out, true);
	private static ArrayList<Edge>[] graph;
	private static int airports;
	private static int[] parent = new int[10001], rank = new int[10001];
	private static PriorityQueue<Edge> queue;

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		int tc = readInt();	
		for (int t = 1; t <= tc; ++t) {
			if (t != 1) sb.append("\n");
			int n = readInt();
			int m = readInt();
			int airportcost = readInt();
			airports = n+1;
			int result = 0;
			queue = new PriorityQueue<Edge>(m);
			for (int i = 1; i <= n; ++i) {
				parent[i] = i;
				rank[i] = 0;
			}
			for (int i = 0; i < m; ++i) {
				int from = readInt();
				int to = readInt();
				int dist = readInt();
				queue.add(new Edge(from, to, dist));
			}
			while (!queue.isEmpty()) {
				Edge e = queue.poll();
				if (findSet(e.from) != findSet(e.to)) {
					if (e.dist < airportcost) {
						result += e.dist;
						union(e.from, e.to);
					} 
				}
			}
			result += (airports-1)*airportcost;
	//		out.printf("Case #%d: %d %d\n", t, result, (airports-1));
	//		System.out.println("Case #"+t+": " + result + " " + (airports-1));
			sb.append("Case #"+t+": " + result + " " + (airports-1));
		}
		System.out.println(sb);
	}

	private static void union(int x, int y) {
		airports--;
		link(findSet(x), findSet(y));
	}

	private static void link(int x, int y) {
		if (rank[x] > rank[y]) {
			parent[y] = x;
		} else {
			parent[x] = y;
			if (rank[x] == rank[y]) ++rank[y];
		}
	}

	private static int findSet(int x) {
		if (x != parent[x]) {
			parent[x] = findSet(parent[x]);
		}
		return parent[x];
	}

	private static class Edge implements Comparable<Edge> {
		int from, to, dist;
		public Edge(int from, int to, int dist) {
			this.from = from;
			this.to = to;
			this.dist = dist;
		}
		@Override
		public int compareTo(Edge e) {
			return dist - e.dist;
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
