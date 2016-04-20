import java.util.*;
import java.io.*;

public class Main {

	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int n, m, c;
	private static HashMap<String, Integer> map;
	private static HashMap<Integer, String> map2;
	private static ArrayList<Integer>[] graph, copy;
	private static PriorityQueue<String> results;

	public static void main(String[] args) throws Exception {
		n = readInt();
		c = 1;
		while (n != 0) {
			map = new HashMap<String, Integer>();
			map2 = new HashMap<Integer, String>();
			graph = new ArrayList[n];
			for (int i = 0; i < n; ++i) {
				String s = readString();
				map2.put(i, s);
				map.put(s, i);
				graph[i] = new ArrayList<Integer>();
			}
			m = readInt();
			for (int i = 0; i < m; ++i) {
				String from = readString();
				String to = readString();
				int f = map.get(from);
				int t = map.get(to);
				graph[f].add(t);
				graph[t].add(f);
			}
			results = new PriorityQueue<String>();
			solve();
			n = readInt();
			++c;
		}
	}

	private static void solve() {
		int s = 0;
		for (int i = 0; i < n; ++i) {
			if (graph[i].size() > 0) {
				s = graph[i].get(0);
				copy = new ArrayList[n];
				copyGraph(copy, graph);
				split(copy, i);
				if (disconnected(copy, s, i)) {
					results.add(map2.get(i));
				}
			}
		}
		if (c != 1) System.out.println();
		System.out.println("City map #" + c + ": " + results.size() + " camera(s) found");
		while (!results.isEmpty()) {
			System.out.println(results.poll());
		}
	}

	private static boolean disconnected(ArrayList<Integer>[] g, int start, int removed) {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[n];
		queue.add(start);
		visited[start] = true;
		while (!queue.isEmpty()) {
			int u = queue.poll();
			for (Integer v : g[u]) {
				if (!visited[v]) {
					queue.add(v);
					visited[v] = true;
				}
			}
		}
		ArrayList<Integer> allowed = new ArrayList<Integer>();
		queue = new LinkedList<Integer>();
		boolean[] vis = new boolean[n];
		queue.add(start);
		while (!queue.isEmpty()) {
			int u = queue.poll();
			for (Integer v : graph[u]) {
				if (!vis[v]) {
					vis[v] = true;
					queue.add(v);
					allowed.add(v);
				}
			}
		}
		visited[removed] = true;
		for (Integer i : allowed) {
			if (!visited[i]) return true;
		}
		return false;
	}

	private static void copyGraph(ArrayList<Integer>[] target, ArrayList<Integer>[] source) {
		for (int i = 0; i < n; ++i) target[i] = new ArrayList<Integer>();
		for (int i = 0; i < n; ++i) {
			target[i].addAll(source[i]);
		}
	}

	private static void split(ArrayList<Integer>[] g, int node) {
		for (Integer v : g[node]) {
			g[v].remove(new Integer(node));
		}
		g[node].clear();
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
