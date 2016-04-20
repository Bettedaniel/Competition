import java.util.*;
import java.io.*;

public class Main {
	
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int c, n, m;

	public static void main(String[] args) throws Exception {
		c = readInt();
		while (c != 0) {
			n = readInt();
			m = readInt();
			for (int i = 0; i < c; ++i) {
				int x = readInt();
				int y = readInt();
				if (n == x || m == y) System.out.println("divisa");
				else if (x > n && y > m) System.out.println("NE");
				else if (x < n && y > m) System.out.println("NO");
				else if (x < n && y < m) System.out.println("SO");
				else System.out.println("SE");
			}
			c = readInt();
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
