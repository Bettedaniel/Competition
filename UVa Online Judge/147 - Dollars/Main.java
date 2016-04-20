import java.util.*;
import java.io.*;

public class Main {

	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int n;
	private static int[] coins = {2000, 1000, 400, 200, 100, 40, 20, 10, 4, 2, 1}; //length = 10.
	private static long[] results = new long[6001];

	public static void main(String[] args) throws Exception {
		results[0] = 1;
		for (int j = 0; j < 11; ++j) {
			for (int i = 1; i <= 6000; ++i) {
				if (coins[j] <= i) {
					results[i] += results[i - coins[j]];
				}
			}
		}
		double in = readDouble();
		n = (int)(Math.round(in*100.00));
		while (n != 0) {
			long r = results[n/5];
			String s = String.format("%.2f", in);
			for (int i = 0; i < 6 - s.length(); ++i) {
				System.out.print(" ");
			}	
			System.out.print(s);
			System.out.printf("%17d\n", r);
			in = readDouble();
			n = (int)(Math.round(in*100.00));
		}
	}

	private static String readString() throws Exception {
		while (!st.hasMoreTokens()) {
			st = new StringTokenizer(stdin.readLine());
		}
		return st.nextToken();
	}

	private static double readDouble() throws Exception {
		return Double.parseDouble(readString());
	}
}
