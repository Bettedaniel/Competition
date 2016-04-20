import java.util.*;
import java.io.*;

public class Main {

	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static ArrayList<Integer>[] graph;
	private static int n;
	private static int[] indegree, results;

	public static void main(String[] args) throws Exception {
		int z = 0;
		while (true) {
			try {
				n = readInt();
				graph = new ArrayList[n];
				indegree = new int[n];
				for (int i = 0; i < n; ++i) graph[i] = new ArrayList<Integer>();
				for (int i = 0; i < n; ++i) {
					int ways = readInt();
					for (int j = 0; j < ways; ++j) {
						int to = readInt();
						graph[i].add(to);
						++indegree[to];
					}
				}
				if (z != 0) System.out.println();
				z = 1;
				LinkedList<Integer> queue = new LinkedList<Integer>();
				boolean[] visited = new boolean[n];
				results = new int[n];
				results[0] = 1;
				visited[0] = true;
				queue.add(0);
				while (!queue.isEmpty()) {
					int u = queue.poll();
					for (Integer v : graph[u]) {
						--indegree[v];
						results[v] += results[u];
						if (indegree[v] == 0) {
							queue.add(v);
						}
					}
				}
				int answer = 0;
				for (int i = 0; i < n; ++i) {
					if (graph[i].size() == 0) answer += results[i];
				}
				System.out.println(answer);
			} catch (Exception e) {
				//System.out.println(e);
				break;
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
