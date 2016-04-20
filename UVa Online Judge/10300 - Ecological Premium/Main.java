import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");

	public static void main(String[] args) throws Exception {
		int tc = readInt();
		for (int t = 0; t < tc; ++t) {
			int farmers = readInt();
			int sum = 0;
			for (int i = 0; i < farmers; ++i) {
				int a = readInt();
				int b = readInt();
				int c = readInt();
				sum += a*c;
			}
			System.out.println(sum);
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
