import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int n;
	private static ArrayList<Integer>[] graph, graph2;

	public static void main(String[] args) throws Exception {
		n = readInt();
		while (n != 0) {
			graph = new ArrayList[n+1];
			for (int i = 1; i <= n; ++i) graph[i] = new ArrayList<Integer>();
			while (true) {
				String s = stdin.readLine();
				StringTokenizer st1 = new StringTokenizer(s);
				int from = Integer.parseInt(st1.nextToken());
				if (from == 0) break;
				while (st1.hasMoreTokens()) {
					int to = Integer.parseInt(st1.nextToken());
					graph[from].add(to);
					graph[to].add(from);
				}
			}
			int result = 0;
			for (int i = 1; i <= n; ++i) {
				boolean add = true;
				graph2 = new ArrayList[n+1];
				copyGraphAndRemove(graph, graph2, i);
				for (Integer v : graph[i]) {
					int temp = bfs(v, graph2);
					if (temp == n-1) add = false;
				}
				if (add && graph[i].size() > 0) ++result;
			}
			System.out.println(result);
			n = readInt();
		}
	}

	private static void printGraph(ArrayList<Integer>[] g) {
		for (int i = 1; i <= n; ++i) {
			System.out.println(i + " --> " + g[i]);
		}
	}

	private static int bfs(int start, ArrayList<Integer>[] g) {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[n+1];
		visited[start] = true;
		queue.add(start);
		int size = 0;
		while (!queue.isEmpty()) {
			int u = queue.poll();
			++size;
			for (Integer v : g[u]) {
				if (!visited[v]) {
					visited[v] = true;
					queue.add(v);
				}
			}
		}
		return size;
	}

	private static void copyGraphAndRemove(ArrayList<Integer>[] from, ArrayList<Integer>[] to, int node) {
		for (int i = 1; i <= n; ++i) to[i] = new ArrayList<Integer>();
		for (int i = 1; i <= n; ++i) {
			for (Integer v : from[i]) {
				if (v != node && i != node) to[i].add(v);
			}
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
