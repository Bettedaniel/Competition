import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int n, m;
	private static ArrayList<Integer>[] graph;
	private static boolean[] colors, globalvisit;
	private static ArrayList<Integer> nodes;

	public static void main(String[] args) throws Exception {
		int tc = readInt();
		for (int _ = 0; _ < tc; ++_) {
			n = readInt();
			m = readInt();
			System.out.println("N & M: " + n + "  " + m);
			graph = new ArrayList[n+1];
			for (int i = 0; i < n+1; ++i) graph[i] = new ArrayList<Integer>();
			for (int i = 0; i < m; ++i) {
				int from = readInt();
				int to = readInt();
				graph[from].add(to);
				graph[to].add(from);
			}
			ArrayList<Integer> blacks = new ArrayList<Integer>();
			int total = 0;
			globalvisit = new boolean[n+1];
			for (int i = 1; i <= n; ++i) {
				if (!globalvisit[i]) {
					nodes = new ArrayList<Integer>();
					bfs(i, true);
					ArrayList<Integer> temp = new ArrayList<Integer>();
					int bs = 0;
					for (Integer j : nodes) {
						if (!colors[j]) {
							++bs;
							temp.add(j);
						}
					}
					int max = bs;
					for (Integer j : nodes) {
						ArrayList<Integer> temp2 = new ArrayList<Integer>();
						bs = 0;
						bfs(j, false);
						for (Integer k : nodes) {
							if (!colors[k]) {
								++bs;
								temp2.add(k);
							}
						}
						if (bs > max) {
							max = bs;
							temp.clear();
							temp.addAll(temp2);
						}
				//		System.out.println(temp);
					}
				//	System.out.println("AFTER: " + temp);
					blacks.addAll(temp);
				}	
			}
			System.out.println(blacks.size());
			for (int i = 0; i < blacks.size(); ++i) {
				if (i == 0) System.out.print(blacks.get(i));
				else System.out.print(" " + blacks.get(i));
			}
			if (blacks.size() != 0) System.out.println();
			if (_ != tc-1) System.out.println();
		}
	}

	private static void bfs(int start, boolean add) {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[n+1];
		colors = new boolean[n+1];
		visited[start] = true;
		globalvisit[start] = true;
		queue.add(start);
		while(!queue.isEmpty()) {
			int u = queue.poll();
			if (add) nodes.add(u);
			for (Integer v : graph[u]) {
				if (!colors[u]) colors[v] = true;
				if (!visited[v]) {
					visited[v] = true;
					globalvisit[v] = true;
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
