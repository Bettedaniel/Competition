import java.util.*;
import java.io.*;

public class Main {

	private static int n, m, total;
	private static int[][] weights;
	private static ArrayList<Integer>[] graph;
	private static HashSet<Integer> vis;
	static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = new StringTokenizer("");

	public static void main(String[] args) throws Exception {
		//Scanner sc = new Scanner(System.in);
		m = readInt();
		n = readInt();
		while (n != 0 || m != 0) {
			weights = new int[m][m];
			graph = new ArrayList[m];
			for (int i = 0; i < m; ++i) graph[i] = new ArrayList<Integer>();
			total = 0;
			for (int i = 0; i < n; ++i) {
				int x = readInt();
				int y = readInt();
				int dist = readInt();
				graph[x].add(y);
				graph[y].add(x);
				weights[x][y] = dist;
				weights[y][x] = dist;
				total += dist;
			}
			System.out.println(total - (mst()));
			m = readInt();
			n = readInt();
		}
	}

	private static int mst() {
		PriorityQueue<Pair> queue = new PriorityQueue<Pair>();
		int mstw = 0;
		vis = new HashSet<Integer>();
		vis.add(0);
		for (Integer i : graph[0]) {
			queue.add(new Pair(i, weights[0][i]));
		}
		while (!queue.isEmpty()) {
			Pair u = queue.poll();
			if (!vis.contains(u.to)) {
				mstw += u.weight;
				vis.add(u.to);
			}
			if (vis.size() == m) break; //Vores graf inkluderer alle knuder.
			for (Integer v : graph[u.to]) {
				if (!vis.contains(v)) {
					queue.add(new Pair(v, weights[u.to][v]));
				}
			}
		}
		return mstw;
	}
	
	private static class Pair implements Comparable<Pair> {
		int to, weight;
		public Pair(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}

		public int compareTo(Pair p) {
			return (weight - p.weight);
		}
	}

	static String readString() throws Exception {
		while (!st.hasMoreTokens()) {
			st = new StringTokenizer(stdin.readLine());
		}
		return st.nextToken();
	}

	static int readInt() throws Exception {
		return Integer.parseInt(readString());
	}
}
