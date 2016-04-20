import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int sat, stat;
	private static ArrayList<Edge>[] graph;
	private static PriorityQueue<Integer> results;

	public static void main(String[] args) throws Exception {
		int tc = readInt();
		for (int _ = 0; _ < tc; ++_) {
			sat = readInt();
			stat = readInt();
			int[][] input = new int[stat][2];
			graph = new ArrayList[stat];
			for (int i = 0; i < stat; ++i) {
				int x = readInt();
				int y = readInt();
				input[i][0] = x;
				input[i][1] = y;
				graph[i] = new ArrayList<Edge>();
			}
			for (int i = 0; i < stat-1; ++i) {
				for (int j = i+1; j < stat; ++j) {
					int dist = pow(input[j][0] - input[i][0]) + pow(input[j][1] - input[i][1]);
					graph[i].add(new Edge(i, j, dist));
					graph[j].add(new Edge(j, i, dist));
				}
			}
			results = new PriorityQueue<Integer>();
			mst();
			int temp = sat;
			while (!results.isEmpty() && temp != 1) {
				int u = results.poll();
				--temp;
			}
			if (!results.isEmpty()) {
				System.out.printf("%.2f", Math.sqrt((double)((-1)*results.poll())));
				System.out.println();
			}
		}
	}

	private static void mst() {
		PriorityQueue<Edge> queue = new PriorityQueue<Edge>();
		queue.add(new Edge(0, 0, 0));
		boolean[] visited = new boolean[stat];
		int included = 0;
		while (!queue.isEmpty()) {
			Edge e = queue.poll();
			if (!visited[e.to]) {
				++included;
				visited[e.to] = true;
				results.add((-1)*e.dist);
			}
			if (included == stat) return;
			for (Edge v : graph[e.to]) {
				if (!visited[v.to]) {
					queue.add(new Edge(e.to, v.to, v.dist));
				}
			}
		}
	}

	private static int pow(int k) {return k * k;}

	private static class Edge implements Comparable<Edge> {
		int from, to, dist;
		public Edge(int from, int to, int dist) {
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
