import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int n;
	private static ArrayList<Edge>[] edges;
	private static ArrayList<Edge> mstgraph; 
	private static int mstValue, mstValue2;
	private static Edge ignore;

	public static void main(String[] args) throws Exception {
		int tc = readInt();
		for (int t = 1; t <= tc; ++t) {
			n = readInt();
			int m = readInt();
			edges = new ArrayList[n+1];
			mstgraph = new ArrayList<Edge>();
			for (int i = 1; i <= n; ++i) edges[i] = new ArrayList<Edge>();
			for (int i = 0; i < m; ++i) {
				int from = readInt();
				int to = readInt();
				int dist = readInt();
				edges[from].add(new Edge(from, to, dist));
				edges[to].add(new Edge(to, from, dist));
			}
			mstValue = mst(false);
			mstValue2 = Integer.MAX_VALUE;
			for (Edge e : mstgraph) {	
				ignore = e;
				mstValue2 = Math.min(mst(true), mstValue2);
			}
			System.out.println(mstValue + " " + mstValue2);
		}
	}

	private static int mst(boolean check) {
		PriorityQueue<Edge> queue = new PriorityQueue<Edge>();
		boolean[] included = new boolean[n+1];
		int value = 0;
		int size = 0;
		queue.add(new Edge(0, 1, 0));
		while (!queue.isEmpty()) {
			Edge e = queue.poll();
			if (!included[e.to]) {
				included[e.to] = true;
				value += e.dist;
				++size;
				if (e.from != 0 && !check) {
					mstgraph.add(e);
				}
			}
			if (size == n) return value;
			for (Edge v : edges[e.to]) {
				if (!included[v.to]) {
					if (check) {		
						if (!v.equals(ignore) && !v.equals(new Edge(ignore.to, ignore.from, ignore.dist))) queue.add(v);
					} else {
						queue.add(v);
					}
				}
			}
		}
		return Integer.MAX_VALUE;
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
		public int hashCode() {
			return 3*from + 93*to + 113*dist;
		}
		public boolean equals(Object o) {
			Edge e = (Edge)o;
			return e.from == from && e.to == to && e.dist == dist;
		}
		public String toString() {
			return "(" + from + " -- "+ dist +" --> " + to + ")";
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
