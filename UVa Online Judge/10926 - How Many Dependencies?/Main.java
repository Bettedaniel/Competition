import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int n;
	private static ArrayList<Integer>[] graph;

	public static void main(String[] args) throws Exception {
		n = readInt();
		while (n != 0) {
			graph = new ArrayList[n+1];
			for (int i = 0; i <= n; ++i) graph[i] = new ArrayList<Integer>();
			for (int i = 1; i <= n; ++i) {
				int t = readInt();
				for (int j = 0; j < t; ++j) {
					graph[i].add(readInt());
				}
			}
			int max = 0;
			int maxi = 0;
			for (int i = 1; i <= n; ++i) {
				int temp = bfs(i);
				if (temp > max) {
					max = temp;
					maxi = i;
				}
			}
			System.out.println(maxi);
			n = readInt();
		}
	}

	private static int bfs(int start) {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[n+1];
		queue.add(start);
		visited[start] = true;
		int nodes = 0;
		while (!queue.isEmpty()) {
			int u = queue.poll();
			++nodes;
			for (Integer v : graph[u]) {
				if (!visited[v]) {
					visited[v] = true;
					queue.add(v);
				}
			}
		}
		return --nodes;
	} 

	private static String readString() throws Exception {
		while (!st.hasMoreTokens()) st = new StringTokenizer(stdin.readLine());
		return st.nextToken();
	}

	private static int readInt() throws Exception {
		return Integer.parseInt(readString());
	}
}
