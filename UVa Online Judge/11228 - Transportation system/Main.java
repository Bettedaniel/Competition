import java.util.*;
import java.io.*;

public class Main {
	
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int n, r;
	private static double notrails, rails;
	private static boolean[] visited;
	private static int[][] input, w;
	private static ArrayList<Integer>[] mstgraph, bfsgraph;
	
	public static void main(String[] args) throws Exception {
		int tcs = readInt();
		for (int t = 1; t <= tcs; ++t) {
			n = readInt();
			r = readInt();
			input = new int[n][2];
			mstgraph = new ArrayList[n];
			bfsgraph = new ArrayList[n];
			w = new int[n][n];
			for (int i = 0; i < n; ++i) {
				int x = readInt();
				int y = readInt();
				input[i][0] = x;
				input[i][1] = y;
				mstgraph[i] = new ArrayList<Integer>();
				bfsgraph[i] = new ArrayList<Integer>();
			}
			for (int i = 0; i < n-1; ++i) {
				for (int j = i+1; j < n; ++j) {
					int dist = pow2(input[j][0] - input[i][0]) + pow2(input[j][1] - input[i][1]);
					w[i][j] = dist;
					w[j][i] = dist;
					if (dist <= r*r) {
						bfsgraph[i].add(j);
						bfsgraph[j].add(i);
					}
					mstgraph[i].add(j);
					mstgraph[j].add(i);
				}
			}
			visited = new boolean[n];
			int graphs = 0;
			for (int i = 0; i < n; ++i) {
				if (!visited[i]) {
					bfs(i);
					++graphs;
				}
			}
			mst();
			System.out.println("Case #" + t + ": " + graphs + " " + (int)Math.round(notrails) + " " + (int)Math.round(rails));
		}
	}

	private static void bfs(int start) {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		visited[start] = true;
		queue.add(start);
		while (!queue.isEmpty()) {
			int u = queue.poll();
			for (Integer v : bfsgraph[u]) {
				if (!visited[v]) {
					queue.add(v);
					visited[v] = true;
				}
			}
		}
	}

	private static void mst() {
		PriorityQueue<Edge> queue = new PriorityQueue<Edge>();
		boolean[] vis = new boolean[n];
		queue.add(new Edge(0, 0, 0));
		int k = 0;
		rails = 0;
		notrails = 0;
		while (!queue.isEmpty() && k < n) {
			Edge e = queue.poll();
			if (!vis[e.to]) {
				++k;
				vis[e.to] = true;
				if (e.dist != 0 && e.dist <= r*r) {
					notrails += Math.sqrt(e.dist);
				} else if (e.dist != 0) rails += Math.sqrt(e.dist);
			}
			for (Integer v : mstgraph[e.to]) {
				if (!vis[v]) {
					queue.add(new Edge(e.to, v, w[e.to][v]));
				}
			}
		}
	}

	private static int pow2(int k) {return k * k;}

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
		while (!st.hasMoreTokens()) {
			st = new StringTokenizer(stdin.readLine());
		}
		return st.nextToken();
	}

	private static int readInt() throws Exception {
		return Integer.parseInt(readString());
	}
}
