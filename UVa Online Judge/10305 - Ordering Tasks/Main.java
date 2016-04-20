import java.util.*;
import java.io.*;

public class Main {

	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int n, m;
	private static int[] indegree;
	private static LinkedList<Integer> queue;
	private static ArrayList<Integer> result;
	private static ArrayList<Integer>[] graph;

	public static void main(String[] args) throws Exception {
		n = readInt();
		m = readInt();
		while (n != 0 || m != 0) {
			indegree = new int[n+1];
			result = new ArrayList<Integer>();
			graph = new ArrayList[n+1];
			for (int i = 0; i < n+1; ++i) graph[i] = new ArrayList<Integer>();
			for (int i = 0; i < m; ++i) {
				int before = readInt();
				int after = readInt();
				graph[before].add(after);
				++indegree[after]; 
			}
			queue = new LinkedList<Integer>();
			for (int i = 1; i <= n; ++i) {
				if (indegree[i] == 0) {
					queue.add(i);
					result.add(i);
				}
			}
			while (!queue.isEmpty()) {
				int u = queue.poll();
				for (Integer v : graph[u]) {
					--indegree[v];
					if (indegree[v] == 0) {
						queue.add(v);
						result.add(v);
					}
				}
			}
			for (int i = 0; i < result.size(); ++i) {
				if (i != result.size() - 1) System.out.print(result.get(i) + " ");
				else System.out.print(result.get(i));
			}
			System.out.println();
			n = readInt();
			m = readInt();
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
