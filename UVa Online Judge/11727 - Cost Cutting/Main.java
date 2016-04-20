import java.util.*;
import java.io.*;

public class Main {
	
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	
	public static void main(String[] args) throws Exception {
		int tc = readInt();	
		for (int t = 1; t <= tc; ++t) {
			int a = readInt();
			int b = readInt();
			int c = readInt();
			int d = Math.max(a, b);
			d = Math.max(d, c);
			int e = -1;
			if (d == c) {
				e = Math.max(a, b);
			} else if (d == b) {
				e = Math.max(a, c);
			} else {
				e = Math.max(b, c);
			}
			System.out.println("Case " + t + ": " + e);
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
