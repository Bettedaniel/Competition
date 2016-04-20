import java.util.Arrays;
import java.util.Scanner;

public class ForCheck {
	static int INF = 1 << 29;

	public static double augmentPath(double[][] weight, int[][] res,
			int[] parent, int s, int t, int f) {
		int i = t;
		double cost = 0;
		while (parent[i] != -1) {
			res[parent[i]][i] -= f;
			cost += f * weight[parent[i]][i];
			res[i][parent[i]] += f;
			i = parent[i];
		}
		return cost;
	}

	public static int bf(double[][] weight, int[][] res, int[] parent, int s,
			int t) {
		double[] d = new double[weight.length];
		int[] f = new int[weight.length];
		Arrays.fill(f, 0);
		Arrays.fill(d, INF);
		d[s] = 0;
		f[s] = INF;
		Arrays.fill(parent, -1);
		for (int c = 0; c < weight.length - 1; c++) {
			for (int i = 0; i < weight.length; i++)
				for (int j = 0; j < weight.length; j++) {
					if (d[i] + weight[i][j] < d[j] && res[i][j] > 0) {
						d[j] = d[i] + weight[i][j];
						f[j] = Math.min(f[i], res[i][j]);
						parent[j] = i;
					}
				}
		}
		return f[t];
	}

	public static double minCostMaxFlow(int flow, double[][] weight,
			int[][] res, int s, int t) {
		for (int i = 0; i < res.length; i++)
			for (int j = 0; j < res.length; j++)
				if (res[i][j] != 0)
					weight[j][i] = -weight[i][j];
		int[] parent = new int[weight.length];
		double cost = 0;
		while (flow != 0) {
			int current = bf(weight, res, parent, s, t);
			if (current == 0)
				return INF;
			cost += augmentPath(weight, res, parent, s, t,
					Math.min(current, flow));
			flow -= current;
		}
		return cost;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (true) {
			int n = in.nextInt();
			int m = in.nextInt();
			if (n == 0 && m == 0)
				break;
			double[][] w = new double[n + m + 2][n + m + 2];
			int[][] res = new int[n + m + 2][n + m + 2];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					w[j + 1][m + i + 1] = in.nextDouble();
					res[j + 1][m + i + 1] = 1;
					w[0][j + 1] = 0;
					res[0][j + 1] = 1;
				}
				w[m + i + 1][w.length - 1] = 0;
				res[m + i + 1][w.length - 1] = 1;
			}
			System.out.printf("%.2f\n",
					minCostMaxFlow(n, w, res, 0, w.length - 1) / n + 1e-6);
		}
	}
}

