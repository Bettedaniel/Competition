import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static ArrayList<Edge>[] graph;
	private static ArrayList<Edge> mstgraph;
	private static int n, m, mst1, mst2;

	public static void main(String[] args) throws Exception {
		int tc = readInt();
		for (int t = 1; t <= tc; ++t) {
			n = readInt();
			m = readInt();
			graph = new ArrayList[n+1];
			mstgraph = new ArrayList<Edge>();
			for (int i = 0; i <= n; ++i) graph[i] = new ArrayList<Edge>();
			for (int i = 0; i < m; ++i) {
				int from = readInt();
				int to = readInt();
				int dist = readInt();
				graph[from].add(new Edge(from, to, dist, i));
				graph[to].add(new Edge(to, from, dist, i));
			}
			int mstValue = mst(false, null);
			int mstValue2 = Integer.MAX_VALUE;
			if (mstValue == Integer.MAX_VALUE) {
				System.out.println("Case #" + t + " : No way");
			} else {
				for (Edge e : mstgraph) {
					mstValue2 = Math.min(mstValue2, mst(true, e));
				}
				if (mstValue2 == Integer.MAX_VALUE) {
					System.out.println("Case #" + t + " : No second way");
				} else {
					System.out.println("Case #" + t + " : " + mstValue2);
				}
			}
		}
	}

	private static int mst(boolean check, Edge ignore) {
		PriorityQueue<Edge> queue = new PriorityQueue<Edge>();
		boolean[] visited = new boolean[n+1];
		queue.add(new Edge(0, 1, 0, -1));
		int mst = 0;
		int size = 0;
		while (!queue.isEmpty()) {
			Edge e = queue.poll();
			if (!visited[e.to]) {
				visited[e.to] = true;
				++size;
				mst += e.dist;
				if (e.id != -1 && !check) {
					mstgraph.add(e);
				}
			}
			if (size == n) return mst;
			for (Edge v : graph[e.to]) {
				if (!visited[v.to]) {
					if (check) {
						if (v.id != ignore.id) queue.add(v);
					} else {
						queue.add(v);
					}
				}
			}
		}
		return Integer.MAX_VALUE;
	}

	private static class Edge implements Comparable<Edge> {
		int from, to, dist, id;
		public Edge(int from, int to, int dist, int id) {
			this.from = from;
			this.to = to;
			this.dist = dist;
			this.id = id;
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
