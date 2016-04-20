import java.util.*;

public class Main {

	private static double[][][] exchange;
	private static int[][][] path;
	private static int n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			n = sc.nextInt();
			exchange = new double[n+1][n+1][n+1];
			path = new int[n+1][n+1][n+1];
			for (int i = 1; i <= n; ++i) {
				for (int j = 1; j <= n; ++j) {
					if (i == j) {
						exchange[i][j][1] = 1.0;
					} else {
						exchange[i][j][1] = sc.nextDouble();
					}
					path[i][j][1] = i;
				}
			}
			floydwarshall();
			printPath();
		}
	}

	private static void printPath() {
		ArrayList<Integer> steps = new ArrayList<Integer>();
		boolean exists = false;
		for (int s = 2; s <= n; ++s) {
			for (int i = 1; i <= n; ++i) {
				if (exchange[i][i][s] > 1.01 && !exists) {
					int st = s;
					int k = path[i][i][s];
					steps.add(i);
					steps.add(k);
					exists = true;
					while (st != 1) {
						st = st - 1;
						int u = path[i][k][st];
						steps.add(u);
						k = u;
					}
				}
			}
		}
		if (exists) {
			for (int i = steps.size() - 1; i >= 0; --i) {
				if (i > 0) System.out.print(steps.get(i) + " ");
				else System.out.print(steps.get(0));
			}
			System.out.println();
		} else {
			System.out.println("no arbitrage sequence exists");
		}
	}

	private static void floydwarshall() {
		for (int s = 2; s <= n; ++s) {
			for (int k = 1; k <= n; ++k) {
				for (int i = 1; i <= n; ++i) {
					for (int j = 1; j <= n; ++j) {
						double temp = exchange[i][k][s - 1] * exchange[k][j][1];
						if (temp > exchange[i][j][s]) {
							exchange[i][j][s] = temp;
							path[i][j][s] = k;
						}
					}
				}
			}
		}
	}
}
