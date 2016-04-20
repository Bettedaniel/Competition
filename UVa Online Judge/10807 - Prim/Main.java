import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int n, m;
	private static ArrayList<Edge>[] graph;
	private static boolean[] othercomp;

	public static void main(String[] args) throws Exception {
		n = readInt();
		while (n != 0) {
			m = readInt();
			graph = new ArrayList[n+1];
			for (int i = 0; i <= n; ++i) graph[i] = new ArrayList<Edge>();
			othercomp = new boolean[m];
			for (int i = 0; i < m; ++i) {
				int from = readInt();
				int to = readInt();
				int dist = readInt();
				graph[from].add(new Edge(from, to, dist, i));
				graph[to].add(new Edge(to, from, dist, i));
			}
/*			int result = 0;
			int temp = mst();
		//	System.out.println("Temp earlier: " + temp);
			if (temp != -1) {
				result += temp;
				temp = mst();
		//		System.out.println("Temp later: " + temp);
				if (temp != -1) {
					System.out.println(result + temp);
				} else System.out.println("No Way!");
			} else System.out.println("No Way!"); */
			n = readInt();
		} 
	}
	
/*	private static int mst() {
		PriorityQueue<Edge> queue = new PriorityQueue<Edge>();
		queue.add(new Edge(0, 1, 0, -1));
		boolean[] vis = new boolean[n+1];
		int size = 0;
		int mst = 0;
		while (!queue.isEmpty()) {
			Edge e = queue.poll();
			if (!vis[e.to] && (e.id == -1 || !othercomp[e.id])) {
				mst += e.dist;
				if (e.id != -1) othercomp[e.id] = true;
				++size;
			}
			vis[e.to] = true;
			if (size == n) {
				return mst;
			}
			for (Edge enew : graph[e.to]) {
				if (!othercomp[enew.id] && !vis[enew.to]) {
					queue.add(new Edge(e.to, enew.to, enew.dist, enew.id));
				}
			}
		}
		return -1;
	} */

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
		public boolean equals(Object o) {
			return id == ((Edge)o).id;
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
