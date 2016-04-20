import java.util.*;

public class Main {

	private static int n, start, end, m;
	private static ArrayList<Integer>[] graph;
	private static int[][] weights, residual;
	private static int[] parent, index;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int t = 1;
		while (n != 0) {
			start = sc.nextInt();
			end = sc.nextInt();
			int c = sc.nextInt();
			graph = new ArrayList[n+1];
			weights = new int[n+1][n+1];
			residual = new int[n+1][n+1];
			for (int i = 1; i < n+1; ++i) {
				graph[i] = new ArrayList<Integer>();
			}
			for (int i = 0; i < c; ++i) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				int weight = sc.nextInt();
				graph[from].add(to);
				graph[to].add(from);
				weights[from][to] += weight;
				weights[to][from] = weights[from][to];
			}
			System.out.println("Network " + t);
			System.out.println("The bandwidth is " + edmondskarp() + ".");
			System.out.println();
			n = sc.nextInt();
			++t;
		}
	}

	private static int edmondskarp() {
		int flow = 0;
		while (true) {
			m = 0;
			bfs();
			if (m == 0) break;
			flow += m;
			int v = end;
			while (v != start) {
				int u = parent[v];
				residual[u][v] += m;
				residual[v][u] -= m;
				v = u;
			}
		}
		return flow;
	}

	private static void bfs() {
		parent = new int[n+1];
		int[] mf = new int[n+1];
		for (int i = 1; i < n+1; ++i) {
			parent[i] = -1;
			mf[i] = 100000001;
		}
		parent[start] = -2;
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		while (!queue.isEmpty()) {
			int u = queue.poll();
			for (Integer v : graph[u]) {
				if (weights[u][v] - residual[u][v] > 0 && parent[v] == -1) {
					parent[v] = u;
					mf[v] = Math.min(mf[u], weights[u][v] - residual[u][v]);
					if (v != end) {
						queue.add(v);
					} else {
						m = mf[end];
						return;
					}
				}
			}
		}
	}
}
