import java.util.*;

public class Main {

	private static int[][] weight;
	private static int n, m, capacity, start, end;
	private static ArrayList<Integer>[] graph;
	private static int[] price, weights;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			n = sc.nextInt();
			m = sc.nextInt();
			graph = new ArrayList[n];
			price = new int[n];
			weight = new int[n][n];
			for (int i = 0; i < n; ++i) {
				price[i] = sc.nextInt();
				graph[i] = new ArrayList<Integer>();
			}
			for (int i = 0; i < m; ++i) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				int we = sc.nextInt();
				graph[from].add(to);
			//	graph[to].add(from);
				weight[from][to] = we;
			//	weight[to][from] = we;
			}
			int q = sc.nextInt();
			for (int i = 0; i < q; ++i) {
				capacity = sc.nextInt();
				start = sc.nextInt();
				end = sc.nextInt();
				dijkstra();
			//	if (weights[end] == 0) {
			//		System.out.println("impossible");
			//	} else {
				//	System.out.println(weights[end]);
					for (int j = 0; j < n; ++j) System.out.print(weights[i] + " ");
					System.out.println();
			//	}
			}
		}
	}

	private static void dijkstra() {
		weights = new int[n];
	//	for (int i = 0; i < n; ++i) {
	//		weights[i] = 20000000;
	//	}
		boolean[][] inq = new boolean[n][capacity+1];
		weights[start] = 0;
		PriorityQueue<Pair> queue = new PriorityQueue<Pair>();
		queue.add(new Pair(start, 0, 0));
		int res = 0;
		while (!queue.isEmpty()) {
			Pair u = queue.poll();
			inq[u.name][u.fuel] = false;
			System.out.println(u.name + " " + u.fuel + " " + u.w);

			if (u.name == end) {
				System.out.println("End u: " + u.name + " " + u.fuel + " " + u.w);
				weights[end] = u.w;
				break;
			}
			for (Integer v : graph[u.name]) {
				if (u.fuel - weight[u.name][v] >= 0 && !inq[v][u.fuel - weight[u.name][v]] && u.fuel - weight[u.name][v] < capacity) {
					queue.add(new Pair(v, u.fuel - weight[u.name][v], Math.min(weights[v], weights[u.name])));
					inq[v][u.fuel - weight[u.name][v]] = true;
				} 
				if (u.fuel < capacity && !inq[u.name][u.fuel]) {
					weights[u.name] += price[u.name];
					queue.add(new Pair(u.name, u.fuel + 1, weights[u.name]));
					inq[u.name][u.fuel] = true;
				}
			}
		}
	}

	private static class Pair implements Comparable<Pair> {
		int name, fuel, w;
		public Pair(int name, int fuel, int w) {
			this.name = name;
			this.fuel = fuel;
			this.w = w;
		}

		public int compareTo(Pair p) {
			return w - p.w;
		}
	}
}
