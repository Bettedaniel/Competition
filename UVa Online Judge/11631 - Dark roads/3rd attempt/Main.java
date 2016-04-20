import java.util.*;
import java.io.*;


public class Main {
	
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static int n, m, old;
	private static StringTokenizer st = new StringTokenizer("");
	private static ArrayList<Edge>[] graph;
	private static PriorityQueue<Edge> queue;
	private static boolean[] contained;

	public static void main(String[] args) throws Exception {
		m = readInt();
		n = readInt();
		while (m != 0 || n != 0) {
			graph = new ArrayList[m];
			for (int i = 0; i < m; ++i) graph[i] = new ArrayList<Edge>();
			old = 0;
			for (int i = 0; i < n; ++i) {
				int from = readInt();
				int to = readInt();
				int distance = readInt();
				graph[from].add(new Edge(to, distance));
				graph[to].add(new Edge(from, distance));
				old += distance;
			}
			contained = new boolean[m];
			queue = new PriorityQueue<Edge>();
			queue.add(new Edge(0, 0));
			int temp = mst();
			System.out.println(old - temp);
			m = readInt();
			n = readInt();
		}
	}

	private static int mst() {
		int mstValue = 0;
		int count = 0;
		while (!queue.isEmpty()) {
			Edge e = queue.poll();
			if (contained[e.to]) continue;
			contained[e.to] = true;
			mstValue += e.dist;
			++count;
			if (count == m) break;
			for (Edge e1 : graph[e.to]) {
				if (!contained[e1.to]) queue.add(new Edge(e1.to, e1.dist));
			}
		}
		return mstValue;
	}

	private static class Edge implements Comparable<Edge> {
		int to, dist;
		public Edge(int to, int dist) {
			this.to = to;
			this.dist = dist;
		}

		public int compareTo(Edge e) {
			return dist - e.dist;
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
