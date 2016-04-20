import java.util.*;
import java.io.*;

public class Main {

	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static long[][] weights;
	private static long[] distance;
	private static int[] indegree, ways;
	private static ArrayList<Integer>[] graph, graph2;
	private static ArrayList<Pair>[] graph3;
	private static int n, m;

	public static void main(String[] args) throws Exception {
		n = readInt();
		while (n != 0) {
			m = readInt();
			weights = new long[n+1][n+1];
			graph = new ArrayList[n+1];
			graph2 = new ArrayList[n+1];
			indegree = new int[n+1];
			distance = new long[n+1];
			ways = new int[n+1];
			for (int i = 0; i <= n; ++i) {
				graph[i] = new ArrayList<Integer>();
				graph2[i] = new ArrayList<Integer>();
				distance[i] = 50000000000L;
			}
			distance[2] = 0;
			for (int i = 0; i < m; ++i) {
				int from = readInt();
				int to = readInt();
				int w = readInt();
				if (from != to) {
					weights[from][to] = w;
					weights[to][from] = w;
					graph[from].add(to);
					graph[to].add(from);
				}
			}
			dijkstra();
			bfs();
			LinkedList<Integer> queue = new LinkedList<Integer>();
			boolean[] visited = new boolean[n+1];
			queue.add(1);
			visited[1] = true;
			ways[1] = 1;
			while (!queue.isEmpty()) {
				int u = queue.poll();
				for (Integer v : graph2[u]) {
					--indegree[v];
					ways[v] += ways[u];
					if (indegree[v] == 0 && !visited[v]) {
						queue.add(v);
						visited[v] = true;
					} 
				}
			}
			System.out.println(ways[2]);
			n = readInt();
		}
	}

	private static void bfs() {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		boolean[] reachable = new boolean[n+1];
		queue.add(1);
		reachable[1] = true;
		while (!queue.isEmpty()) {
			int u = queue.poll();
			for (Integer v : graph[u]) {
				if (!reachable[v] && distance[u] > distance[v]) {
					queue.add(v);
					reachable[v] = true;
				}
				if (distance[u] > distance[v] && reachable[v]) {
					graph2[u].add(v);
					++indegree[v];
				}
			}
		}
	}

	private static void dijkstra() {
		PriorityQueue<Pair> queue = new PriorityQueue<Pair>();
		boolean[] visited = new boolean[n+1];
		queue.add(new Pair(2, distance[2]));
		while (!queue.isEmpty()) {
			Pair p = queue.poll();
			if (p.name == 1) return;
			if (!visited[p.name]) { //Vigtig linje. Uden denne tilfoejer vi alt for meget ekstra til queue.
				visited[p.name] = true;
				for (Integer v : graph[p.name]) {
					if (distance[v] > distance[p.name] + weights[p.name][v]) {
						distance[v] = distance[p.name] + weights[p.name][v];
					}
					if (!visited[v]) queue.add(new Pair(v, distance[v]));
				}
			}
		}
	}

	private static class Pair implements Comparable<Pair> {
		int name;
		long dist;
		public Pair(int name, long dist) {
			this.name = name;
			this.dist = dist;
		}
		public int compareTo(Pair p) {
			return (int)dist - (int)p.dist;
		}
	}

	private static class Edge {
		int u, v;
		long d;
		public Edge (int u, int v, long d) {
			this.u = u;
			this.v = v;
			this.d = d;
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
