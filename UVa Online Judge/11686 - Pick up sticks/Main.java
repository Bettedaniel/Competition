import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int n, m;
	private static ArrayList<Integer>[] graph;
	private static int[] indegree;
	private static LinkedList<Integer> queue;

	public static void main(String[] args) throws Exception {
		n = readInt(); m = readInt();
		while (n != 0 || m != 0) {
			graph = new ArrayList[n+1];
			indegree = new int[n+1];
			for (int i = 1; i <= n; ++i) graph[i] = new ArrayList<Integer>();
			for (int i = 0; i < m; ++i) {
				int a = readInt();
				int b = readInt();
				graph[a].add(b);
				++indegree[b];	
			}
			queue = new LinkedList<Integer>();
			for (int i = 1; i <= n; ++i) {
				if (indegree[i] == 0) queue.add(i);
			}
			if (queue.isEmpty()) System.out.println("IMPOSSIBLE");
			else {
				ArrayList<Integer> list = new ArrayList<Integer>();
				while (!queue.isEmpty()) {
					int u = queue.poll();
					list.add(u);
					for (Integer v : graph[u]) {
						--indegree[v];
						if (indegree[v] == 0) {
							queue.add(v);
						}
					}
				}
				if (list.size() == n) {
					for (int i = 0; i < list.size(); ++i) {
						System.out.println(list.get(i));
					}
				} else {
					System.out.println("IMPOSSIBLE");
				}
			}
			n = readInt(); m = readInt();
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
