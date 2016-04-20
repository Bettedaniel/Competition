import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int n;
	private static HashSet<Integer> named = new HashSet<Integer>();
	private static ArrayList<Integer>[] graph;
	private static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	private static int[] distances;

	public static void main(String[] args) throws Exception {
		n = readInt();
		int c = 1;
		while (n != 0) {
			graph = new ArrayList[31];
			named = new HashSet<Integer>();
			map = new HashMap<Integer, Integer>();
			for (int i = 0; i < 31; ++i) graph[i] = new ArrayList<Integer>();
			int j = 0;
			for (int i = 0; i < n; ++i) {
				int from = readInt();
				if (!named.contains(from)) {
					named.add(from);
					map.put(from, j);
					++j;
				}
				int to = readInt();
				if (!named.contains(to)) {
					named.add(to);
					map.put(to, j);
					++j;
				}
				int rfrom = map.get(from);
				int rto = map.get(to);
				graph[rfrom].add(rto);
				graph[rto].add(rfrom);
			}
			int start = readInt();
			int setting = readInt();
			while (start != 0 || setting != 0) {
				bfs(map.get(start));
				int unreachable = 0;
				for (int i = 0; i < j; ++i) {
					if (distances[i] > setting) {
						++unreachable;
					}
				}
				System.out.println("Case " + c + ": " + unreachable + " nodes not reachable from node " + start + " with TTL = " + setting + ".");
				start = readInt();
				setting = readInt();
				++c;
			}
			n = readInt();
		}
	}

	private static void bfs(int start) {
		distances = new int[31];
		Arrays.fill(distances, Integer.MAX_VALUE);
		distances[start] = 0;
		boolean[] visited = new boolean[31];
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		visited[start] = true;
		while (!queue.isEmpty()) {
			int u = queue.poll();
			for (Integer v : graph[u]) {
				if (!visited[v]) {
					visited[v] = true;
					queue.add(v);
					distances[v] = distances[u] + 1;
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
