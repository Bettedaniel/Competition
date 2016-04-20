import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static ArrayList<Integer>[] graph;
	private static int[][] weights, residual;
	private static int n, r, m;
	private static int[] p;
	private static HashMap<Integer, String> map;
	private static HashMap<String, Integer> map2;
	private static HashSet<String> seen;

	public static void main(String[] args) throws Exception {
		n = readInt();
		r = readInt();
		int scene = 1;
		while (n != 0 || r != 0) {
			graph = new ArrayList[n];
			map = new HashMap<Integer, String>();
			map2 = new HashMap<String, Integer>();
			seen = new HashSet<String>();
			weights = new int[n][n];
			for (int i = 0; i < n; ++i) graph[i] = new ArrayList<Integer>();
			int name = 0;
			for (int i = 0; i < r; ++i) {
				String from = readString();
				if (!seen.contains(from)) {
					map.put(name, from);
					map2.put(from, name);
					seen.add(from);
					++name;
				}
				String to = readString();
				if (!seen.contains(to)) {
					map.put(name, to);
					map2.put(to, name);
					seen.add(to);
					++name;
				}
				int cap = readInt();
				graph[map2.get(to)].add(map2.get(from));
				graph[map2.get(from)].add(map2.get(to));
				weights[map2.get(to)][map2.get(from)] += cap;
				weights[map2.get(from)][map2.get(to)] += cap;
			}
			String start = readString();
			String end = readString();
			int result = edmondskarp(map2.get(start), map2.get(end));
			System.out.println("Scenario #" + scene);
			System.out.println(result + " tons");
			System.out.println();
			n = readInt();
			r = readInt();
			++scene;
		}
	}

	private static int edmondskarp(int start, int end) {
		int f = 0;
		residual = new int[n][n];
		while (true) {
			m = bfs(start, end);
			if (m == 0) break;
			f = Math.max(f, m);
			int v = end;
			while (v != start) {
				int u = p[v];
				residual[u][v] += m;
				residual[v][u] -= m;
				v = u;
			}
		}
		return f;
	}

	private static int bfs(int start, int end) {
		p = new int[n];
		for (int i = 0; i < n; ++i) p[i] = -1;
		p[start] = -2;
		int[] w = new int[n];
		w[start] = Integer.MAX_VALUE;
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		while (!queue.isEmpty()) {
			int u = queue.poll();
			for (Integer v : graph[u]) {
				if (weights[u][v] - residual[u][v] > 0 && p[v] == -1) {
					p[v] = u;
					w[v] = Math.min(w[u], weights[u][v] - residual[u][v]);
					if (v != end) queue.add(v);
					else {
						return w[end];
					}
				}
			}
		}
		return 0;
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
