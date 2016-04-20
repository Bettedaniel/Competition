import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int n, m;

	public static void main(String[] args) throws Exception {
		n = readInt();
		m = readInt();
		int t = 1;
		while (n != 0 || m != 0) {
			if (n <= m) {
				System.out.println("Case " + t + ": 0");
				for (int i = 0; i < n; ++i) readInt();
				for (int i = 0; i < m; ++i) readInt();
			} else {
				int min = Integer.MAX_VALUE;
				for (int i = 0; i < n; ++i) {
					int a = readInt();
					min = Math.min(a, min);
				}
				for (int i = 0; i < m; ++i) {
					readInt();
				}
				System.out.println("Case " + t + ": " + (n-m) + " " + min);
			}
			n = readInt();
			m = readInt();
			++t;
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
