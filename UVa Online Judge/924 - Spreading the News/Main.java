import java.util.*;
import java.io.*;

public class Main {

	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int n, r1, r2;
	private static ArrayList<Integer>[] graph;
	private static int[] days;

	public static void main(String[] args) throws Exception {
		try {
			while (true) {
				n = readInt();
				graph = new ArrayList[n];
				for (int i = 0; i < n; ++i) graph[i] = new ArrayList<Integer>();
				for (int i = 0; i < n; ++i) {
					int friends = readInt();
					for (int j = 0; j < friends; ++j) {
						int f = readInt();
						graph[i].add(f);
					}
				}
				int m = readInt();
				for (int i = 0; i < m; ++i) {
					days = new int[n];
					int start = readInt();
					boolean alone = bfs(start);
					r1 = 0;
					r2 = 0;
					if (alone) System.out.println(0);
					else {
						decide();
						System.out.println(r1 +  " " + r2);
					}
				}
			}
		} catch (Exception e) {
			return;
		}
	}

	private static void decide() {
		int[] temp = new int[n];
		for (int i = 0; i < n; ++i) {
			if (days[i] != 0) temp[days[i]] += 1;
		}
		for (int i = 0; i < n; ++i) {
			if (r1 < temp[i]) {
				r1 = temp[i];
				r2 = i;
			}	
		}
	}

	private static boolean bfs(int start) {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		boolean[] vis = new boolean[n];
		queue.add(start);
		vis[start] = true;
		days[start] = 0;
		while (!queue.isEmpty()) {
			int u = queue.poll();
			for (Integer v : graph[u]) {
				if (!vis[v]) {
					days[v] = days[u] + 1;
					queue.add(v);
					vis[v] = true;
				}
			}
		}
		for (int i = 0; i < n; ++i) {
			if (i != start && vis[i]) return false;
		}
		return true;
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
