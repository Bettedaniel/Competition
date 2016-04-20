import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int k;
	private static int[] numbers;

	public static void main(String[] args) throws Exception {
		k = readInt();
		int t = 1;
		while (k != 0) {
			if (t != 1) System.out.println();
			numbers = new int[k];
			for (int i = 0; i < k; ++i) {
				numbers[i] = readInt();
			}
			solve(0, 0, "");
			k = readInt();
			++t;
		}
	}

	private static void solve(int idx, int used, String s) {
		if (used == 6) {
			System.out.println(s.substring(1, s.length()));
			return;
		}
		for (int i = idx; i < k-6+used+1; ++i) {
			int temp = used + 1;
			solve(i+1, temp, s + " " + numbers[i]);
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
