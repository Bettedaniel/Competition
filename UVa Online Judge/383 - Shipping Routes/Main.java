import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int n, m, p;
	private static HashMap<String, Integer> map;
	private static int[][] weights;

	public static void main(String[] args) throws Exception {
		int tc = readInt();
		System.out.println("SHIPPING ROUTES OUTPUT\n");
		for (int t = 1; t <= tc; ++t) {
			System.out.println("DATA SET  " + t);
			System.out.println();
			m = readInt();
			n = readInt();
			p = readInt();
			map = new HashMap<String, Integer>();
			for (int i = 0; i < m; ++i) {
				map.put(readString(), i);
			}
			weights = new int[m][m];
			for (int i = 0; i < m; ++i) Arrays.fill(weights[i], 1000000000);
			for (int i = 0; i < n; ++i) {
				String from = readString();
				String to = readString();
				weights[map.get(from)][map.get(to)] = 1;
				weights[map.get(to)][map.get(from)] = 1;
			}
			floydwarshall();
			for (int i = 0; i < p; ++i) {
				int shipment = readInt();
				String from = readString();
				String to = readString();
				int legs = weights[map.get(from)][map.get(to)];
				int result = legs*shipment*100;
				if (legs == 1000000000) System.out.println("NO SHIPMENT POSSIBLE");
				else System.out.println("$" + result);
			}
			System.out.println();
		}
		System.out.println("END OF OUTPUT");
	}

	private static void floydwarshall() {
		for (int k = 0; k < m; ++k) {
			for (int i = 0; i < m; ++i) {
				for (int j = 0; j < m; ++j) {
					weights[i][j] = Math.min(weights[i][j], weights[i][k] + weights[k][j]);
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
