import java.util.*;
import java.io.*;

public class Main {
	
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static HashMap<String, Integer> map;
	private static ArrayList<Integer>[] graph;
	private static int[][] w;
	private static int n, m;

	public static void main(String[] args) throws Exception {
		n = readInt();
		m = readInt();
		while (n != 0 || m != 0) {
			map = new HashMap<String, Integer>();
			w = new int[n][n];
			graph = new ArrayList[n];
			for (int i = 0; i < n; ++i) {
				graph[i] = new ArrayList<Integer>();
				Arrays.fill(w[i], Integer.MAX_VALUE);
				String s = readString();
				map.put(s, i);
			}
			for (int i = 0; i < m; ++i) {
				String from = readString();
				String to = readString();
				int cost = readInt();Math.min(w[map.get(from)][map.get(to)], cost);
				w[map.get(from)][map.get(to)] = Math.min(w[map.get(from)][map.get(to)], cost);
				w[map.get(to)][map.get(from)] = Math.min(w[map.get(to)][map.get(from)], cost);;
				graph[map.get(from)].add(map.get(to));
				graph[map.get(to)].add(map.get(from));
			}
			int start = map.get(readString());
			int result = mst(start);
			if (result == -1) {
				System.out.println("Impossible");
			} else {
				System.out.println(result);
			}
			n = readInt();Math.min(w[map.get(from)][map.get(to)], cost);
			m = readInt();
		}
	}

	private static int mst(int start) {
		PriorityQueue<Edge> queue = new PriorityQueue<Edge>();
		boolean[] visited = new boolean[n];
		queue.add(new Edge(start, start, 0));
		int count = 0;
		int mst = 0;
		int result = -1;
		while (!queue.isEmpty()) {
			Edge e = queue.poll();
			if (!visited[e.to]) {
				++count;
				mst += e.cost;
			}
			visited[e.to] = true;
			if (count == n) {
				result = mst;
				break;
			}
			for (Integer v : graph[e.to]) {
				if (!visited[v]) {
					queue.add(new Edge(e.to, v, w[e.to][v]));
				}
			}
		}
		return result;
	} 

	private static class Edge implements Comparable<Edge> {
		int from, to, cost;
		public Edge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
		public int compareTo(Edge e) {
			return cost - e.cost;
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
