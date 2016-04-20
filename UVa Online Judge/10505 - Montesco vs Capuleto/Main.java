import java.util.*;
import java.io.*;

public class Main {
	
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in))	;
	private static StringTokenizer st = new StringTokenizer("");
	private static int n;
	private static ArrayList<Integer>[] graph;
	private static boolean[] visited;
	private static int[] colors;
	private static ArrayList<Integer> numbers;

	public static void main(String[] args) throws Exception {
		int tc = readInt();
		for (int _ = 0; _ < tc; ++_) {
			n = readInt();
			graph = new ArrayList[n+1];
			numbers = new ArrayList<Integer>();
			int max = 0;
			for (int i = 1; i <= n; ++i) graph[i] = new ArrayList<Integer>();
			for (int i = 1; i <= n; ++i) {
				if (!numbers.contains(i)) numbers.add(i);
				int m = readInt();
				max = Math.max(i, max);
				for (int j = 0; j < m; ++j) {
					int enemy = readInt();
					if (!numbers.contains(enemy)) numbers.add(enemy);
					max = Math.max(enemy, max);
					graph[i].add(enemy);
					if (enemy <= n) graph[enemy].add(i);
				}
			}
			visited = new boolean[max+1];
			int result = 0;
			for (Integer i : numbers) {
				if (!visited[i]) {
					colors = new int[max+1]; //1 = red. 2 = black.
					boolean poss = bicolor(i);
					if (poss) {
						int montesco = 0;
						int capuleto = 0;
						for (Integer j : numbers) {
							if (colors[j] == 1 && j <= n) ++montesco;
							else if (colors[j] == 2 && j <= n) ++capuleto;
						}
						result += Math.max(montesco, capuleto);
					}
				}
			}
			System.out.println(result);
		}
	}

	private static boolean bicolor(int start) {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		visited[start] = true;
		colors[start] = 1; 
		boolean answer = true;
		while (!queue.isEmpty()) {
			int u = queue.poll();
			for (Integer v : graph[u]) {
				if (!visited[v]) {
					if (v <= n) queue.add(v);
					visited[v] = true;
				}
				if (colors[v] == 0) {
					colors[v] = 3 - colors[u];
				} else {
					if (colors[v] == colors[u] && v <= n) {
						answer = false;
					}
				}
			}
		}
		return answer;
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
