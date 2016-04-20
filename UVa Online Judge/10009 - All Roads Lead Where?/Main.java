import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static ArrayList<Integer>[] graph;

	public static void main(String[] args) throws Exception {
		int tc = readInt();
		for (int _ = 0; _ < tc; ++_) {
			int roads = readInt();
			int queries = readInt();
			if (_ != 0) System.out.println();
			graph = new ArrayList[26];
			for (int i = 0; i < 26; ++i) graph[i] = new ArrayList<Integer>();
			for (int i = 0; i < roads; ++i) {
				String from = readString();
				int f = (int)from.charAt(0) - 65;
				String to = readString();
				int t = (int)to.charAt(0) - 65;
				graph[f].add(t);
				graph[t].add(f);
			}
			for (int i = 0; i < queries; ++i) {
				String a = readString();
				String b = readString();
				System.out.println(bfs((int)(a.charAt(0)) - 65, (int)(b.charAt(0)) - 65));
			}
		}
	}

	private static String bfs(int start, int end) {
		int[] parent = new int[26];
		LinkedList<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[26];
		queue.add(end);
		visited[end] = true;
		while (!queue.isEmpty()) {
			int u = queue.poll();
			for (Integer v : graph[u]) {
				if (!visited[v]) {
					visited[v] = true;
					parent[v] = u;
					queue.add(v);
				}
			}
		}
		StringBuilder result = new StringBuilder();
		int v = start;
		result.append((char)(v+65));
		while (v != end) {
			int u = parent[v];
			result.append((char)(u+65));
			v = u;
		}
		return result.toString();
	}

	private static String readString() throws Exception {
		while (!st.hasMoreTokens()) st = new StringTokenizer(stdin.readLine());
		return st.nextToken();
	}

	private static int readInt() throws Exception {
		return Integer.parseInt(readString());
	}
}
