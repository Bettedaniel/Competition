import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int[] coins = new int[20];
	private static long[] amounts = new long[10001];

	public static void main(String[] args) throws Exception {
		for (int i = 2; i <= 21; ++i) {
			coins[i-2] = i*i*i;
		}
		Arrays.fill(amounts, 1);
		for (int i = 0; i < 20; ++i) {
			for (int j = 1; j <= 10000; ++j) {
				if (j >= coins[i]) {
					amounts[j] += amounts[j-coins[i]];
				}
			}
		}
		while (true) {
			try {
				System.out.println(amounts[readInt()]);
			} catch (Exception e) {
		//		e.printStackTrace();
				return;
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
