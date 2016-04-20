import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int n, m;
	private static ArrayList<Edge> edges;
	private static double[][] weights, residual;
	private static int[] parent;

	public static void main(String[] args) throws Exception {
		n = readInt();
		m = readInt();
		while (n != 0 || m != 0) {
			edges = new ArrayList<Edge>();
			weights = new double[42][42];
			residual = new double[42][42];
			for (int i = 1; i <= n; ++i) {
				edges.add(new Edge(i+20, 41));
				weights[i+20][41] = 0.0;
				residual[i+20][41] = 1;
				for (int j = 1; j <= m; ++j) {
					double dist = readDouble();
					weights[j][i+20] = dist;
					weights[0][j] = 0.0;
					residual[0][j] = 1;
					residual[j][i+20] = 1;
					edges.add(new Edge(j, i+20));
					edges.add(new Edge(0, j));
					edges.add(new Edge(i+20, j));
					weights[i+20][j] = -weights[j][i+20];
				}
			}
			double result = edmondskarp();
			System.out.printf("%.2f\n", result/n + 1e-6);
			n = readInt();
			m = readInt();
		}
	}

	private static double edmondskarp() {
		double flow = 0;
		while (true) {
			double temp = bellmanford();
			if (temp == Double.POSITIVE_INFINITY) break;
			flow += temp;
			int v = 41;
			while (v != 0) {
				int u = parent[v];
				residual[u][v] -= 1;
				residual[v][u] += 1;
				v = u;
			}
		}
		return flow;
	}

	private static double bellmanford() {
		parent = new int[42];
		double[] distance = new double[42];
		Arrays.fill(distance, Double.POSITIVE_INFINITY);
		distance[0] = 0.0;
		for (int i = 0; i <= n+m; ++i) {
			for (Edge e : edges) {
				int u = e.from;
				int v = e.to;
				if (distance[u] + weights[u][v] + 1e-6 < distance[v] && residual[u][v] > 0) {
					distance[v] = distance[u] + weights[u][v];
					parent[v] = u;
				}
			}
		}
		return distance[41];
	}

	private static class Edge {
		int from, to;
		public Edge(int from, int to) {
			this.from = from;
			this.to = to;
		}
	}

	private static String readString() throws Exception {
		while (!st.hasMoreTokens()) st = new StringTokenizer(stdin.readLine());
		return st.nextToken();
	}

	private static int readInt() throws Exception {
		return Integer.parseInt(readString());
	}

	private static double readDouble() throws Exception {
		return Double.parseDouble(readString());
	}
}
