import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int n, m;
	private static ArrayList<Integer>[] graph;
	private static HashMap<Integer, String> map;
	private static HashMap<String, Integer> map2;
	private static ArrayList<Integer>[] stronglyconnected;

	public static void main(String[] args) throws Exception {
		n = readInt();
		m = readInt();
		int dataset = 1;
		while (n != 0 || m != 0) {
			if (dataset != 1) System.out.println();
			map = new HashMap<Integer, String>();
			map2 = new HashMap<String, Integer>();
			graph = new ArrayList[n];
			HashSet<String> seen = new HashSet<String>();
			stronglyconnected = new ArrayList[n];
			for (int i = 0; i < n; ++i) {
				graph[i] = new ArrayList<Integer>();
				stronglyconnected[i] = new ArrayList<Integer>();
			}
			int k = 0;
			for (int i = 0; i < m; ++i) {
				String from = readString();
				String to = readString();
				if (!seen.contains(from)) {
					seen.add(from);
					map.put(k, from);
					map2.put(from, k);
					++k;
				}
				if (!seen.contains(to)) {
					seen.add(to);
					map.put(k, to);
					map2.put(to, k);
					++k;
				}
				if (!graph[map2.get(from)].contains(map2.get(to))) graph[map2.get(from)].add(map2.get(to));
			}
			boolean[] in_one = new boolean[n];
			int c = 0;
			for (int i = 0; i < n; ++i) {
				if (!in_one[i]) {
					stronglyconnected[c].add(i);
					in_one[i] = true;
					if (i < n-1) {
						for (int j = i+1; j < n; ++j) {
							boolean ij = bfs(i, j);
							boolean ji = bfs(j, i);
							if (ij && ji) {
								stronglyconnected[c].add(j);
								in_one[j] = true;
							}
						}
					}
					++c;
				}
			}
			System.out.println("Calling circles for data set " + dataset + ":");
			for (int i = 0; i < c; ++i) {
				for (int j = 0; j < stronglyconnected[i].size(); ++j) {
					if (j == 0) System.out.print(map.get(stronglyconnected[i].get(j)));
					else System.out.print(", " + map.get(stronglyconnected[i].get(j)));
				}
				System.out.println();
			}
			n = readInt();
			m = readInt();
			++dataset;
		}
	}

	private static boolean bfs(int start, int end) {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[n];
		visited[start] = true;
		queue.add(start);
		while (!queue.isEmpty()) {
			int u = queue.poll();
			for (Integer v : graph[u]) {
				if (!visited[v]) {
					visited[v] = true;
					queue.add(v);
				}
				if (v ==  end) {
					return true;
				}
			}
		}
		return false;
	}

	private static String readString() throws Exception {
		while (!st.hasMoreTokens()) st = new StringTokenizer(stdin.readLine());
		return st.nextToken();
	}

	private static int readInt() throws Exception {
		return Integer.parseInt(readString());
	}
}
