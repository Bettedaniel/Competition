import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int r;
	private static int[][] weights;

	public static void main(String[] args) throws Exception {
		int tc = readInt();
		for (int _ = 0; _ < tc; ++_) {
			r = readInt();
			weights = new int[r][r];
			int[] input = new int[r];
			for (int i = 0; i < r; ++i) {
				input[i] = readInt();
				Arrays.fill(weights[i], 1000000000);
			}
			for (int i = 0; i < r; ++i) {
				for (int j = i+1; j < r; ++j) {
					if (input[i] != input[j]) {
						weights[i][j] = Math.abs(input[i] - input[j]);
						weights[j][i] = Math.abs(input[i] - input[j]);
					}
				}
			}
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < r; ++i) {
				int temp = 0;
				for (int j = 0; j < r; ++j) {
					if (weights[i][j] < 1000000000) {
						temp += weights[i][j];
					}
				}
				if (temp < min) min = temp;
			}
			System.out.println(min);
		}
	}

	private static void floydwarshall() {
		for (int i = 0; i < r; ++i) {
			for (int j = 0; j < r; ++j) {
				for (int k = 0; k < r; ++k) {
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
