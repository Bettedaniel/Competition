import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int[] gcds = new int[501]; 

	public static void main(String[] args) throws Exception {
		for (int k = 2; k < 501; ++k) {
			int g = 0;
			for (int i = 1; i <= k; ++i) {
				for (int j = i+1; j <= k; ++j) {
					g += gcd(i, j);
				}
			}
			gcds[k] = g;
		}
		int n = readInt();
		StringBuilder sb = new StringBuilder();
		int t = 1;
		while (n != 0) {
			if (t != 1) sb.append("\n");
			sb.append(gcds[n]);
			n = readInt();
			++t;
		}
		System.out.println(sb.toString());
	}
		
	private static int gcd(int a, int b) {
		while (a != b) {
			if (a > b) a -= b;
			else b -= a;
		}
		return a;
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
