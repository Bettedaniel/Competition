import java.util.*;
import java.io.*;

public class Main {

	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int stones;
	private static int[][] input;
	private static int[][] weights;

	public static void main(String[] args) throws Exception {
		stones = readInt();
		int no = 1;
		while (stones != 0) {
			input = new int[stones][2];
			weights = new int[stones][stones];
			for (int i = 0; i < stones; ++i) {
				int x = readInt();
				int y = readInt();
				input[i][0] = x;
				input[i][1] = y;
			}
			for (int i = 0; i < stones; ++i) {
				for (int j = i+1; j < stones; ++j) {
					int dist = power2(input[j][0] - input[i][0]) + power2(input[j][1] - input[i][1]);
					weights[i][j] = dist;
					weights[j][i] = dist;
				}
			}
			floydwarshall();
			int result = weights[0][1];
			System.out.println("Scenario #" + no);
			System.out.print("Frog Distance = ");
			System.out.printf("%.3f\n", Math.sqrt((double)(result)));
			System.out.println();
			stones = readInt();
			++no;
		}
	}

	private static int power2(int n) {
		return n*n;
	}

	private static void floydwarshall() {
		for (int k = 0; k < stones; ++k) {
			for (int i = 0; i < stones; ++i) {
				for (int j = 0; j < stones; ++j) {
					weights[i][j] = Math.min(weights[i][j], Math.max(weights[i][k], weights[k][j]));
				}
			}
		}
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
