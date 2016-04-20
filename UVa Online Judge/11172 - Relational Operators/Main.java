import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");

	public static void main(String[] args) throws Exception {
		int tc = readInt();
		for (int t = 0; t < tc; ++t) {
			int a = readInt();
			int b = readInt();
			if (a > b) System.out.println(">");
			else if (a < b) System.out.println("<");
			else System.out.println("=");
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
