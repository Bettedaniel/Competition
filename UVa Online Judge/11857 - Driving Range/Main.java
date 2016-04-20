import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static ArrayList<Edge>[] mstgraph;
	private static int n, m;

	public static void main(String[] args) throws Exception {
		n = readInt();
		m = readInt();
		int t = 1;
		StringBuilder sb = new StringBuilder();
		while (n != 0 || m != 0) {
			mstgraph = new ArrayList[n];
			if (t != 1) sb.append("\n");
			for (int i = 0; i < n; ++i) {
				mstgraph[i] = new ArrayList<Edge>();
			}
			for (int i = 0; i < m; ++i) {
				int from = readInt();
				int to = readInt();
				int dist = readInt();
				mstgraph[from].add(new Edge(from, to, dist));
				mstgraph[to].add(new Edge(to, from, dist));
			}
			int r = mst();
			if (r == -1) sb.append("IMPOSSIBLE");
			else sb.append(r);
			n = readInt(); m = readInt();
			++t;
		}
		System.out.println(sb);
	}

	private static int mst() {
		int max = 0;	
		PriorityQueue<Edge> queue = new PriorityQueue<Edge>();
		boolean[] visited = new boolean[n];
		queue.add(new Edge(-1, 0, 0));
		int size = 0;
		while (!queue.isEmpty()) {
			Edge e = queue.poll();
			if (!visited[e.to]) {
				visited[e.to] = true;
				++size;
				if (e.from != -1) {
					max = Math.max(max, e.dist);
				}
				if (size == n) return max;
				for (Edge ev : mstgraph[e.to]) {
					if (!visited[ev.to]) {
						queue.add(ev);
					}
				}
			}
		}
		return -1;
	}
	
	private static class Edge implements Comparable<Edge> {
		int from, to, dist;
		public Edge (int from, int to, int dist) {
			this.from = from;
			this.to = to;
			this.dist = dist;
		}
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
