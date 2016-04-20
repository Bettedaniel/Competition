import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int n, start;
	private static ArrayList<Integer>[] graph;
	private static int[] distance;

	public static void main(String[] args) throws Exception {
		n = readInt();
		int t = 1;
		while (n != 0) {
			start = readInt();
			int from = readInt();
			int to = readInt();
			distance = new int[n+1];
			graph = new ArrayList[n+1];
			for (int i = 0; i <= n; ++i) graph[i] = new ArrayList<Integer>();
			while (from != 0 || to != 0) {
				graph[from].add(to);
				from = readInt();
				to = readInt();
			}
			bfs(start);
			int max = 0;
			int maxpos = 0;
			for (int i = 1; i < n+1; ++i) {
				if (max < distance[i]) {
					max = distance[i];
					maxpos = i;
				}
			}
			System.out.println("Case " + t + ": The longest path from " + start + " has length " + max + ", finishing at " + maxpos + ".");
			System.out.println();
			n = readInt();
			++t;
		}
	}

	private static void bfs(int s) {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[n+1];
		queue.add(s);
		visited[s] = true;
		while (!queue.isEmpty()) {
			int u = queue.poll();
			for (Integer v : graph[u]) {
				int pre = distance[v];
				distance[v] = Math.max(distance[v], distance[u] + 1);
				if (pre < distance[v]) visited[v] = false;
				if (!visited[v]) {
					visited[v] = true;
					queue.add(v);
				}
			}
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
