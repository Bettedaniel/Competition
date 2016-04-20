import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static String result;
	private static int min;

	public static void main(String[] args) throws Exception {
		int tc = readInt();
		for (int _ = 0; _ < tc; ++_) {
			int n = readInt();
			if (n >= 10) {
				result = "-1";
				min = Integer.MAX_VALUE;
				solve(n, "");
				System.out.println(result);
			} else if (n >= 0 && n <= 9) System.out.println(n);
		}
	}

	private static void solve(int n, String s) {
		if (n == 1) {
			int temp = Integer.parseInt(s);
			if (min > temp) {
				min = temp;
				result = s;
			}
			return;
		}
		for (int i = 2; i < 10; ++i) {
			if (n % i == 0) {
				solve(n/i, s+i);
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
