import java.util.*;
import java.io.*;

public class Main {

	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int[] input;

	public static void main(String[] args) throws Exception {
		int tc = readInt();
		for (int t = 1; t <= tc; ++t) {
			int n = readInt();
			input = new int[n];
			for (int i = 0; i < n; ++i) {
				input[i] = readInt();
			}
			int lowjumps = 0;
			int highjumps = 0;
			for (int i = 0; i < n-1; ++i) {
				if (input[i+1] > input[i]) ++highjumps;
				else if (input[i+1] < input[i]) ++lowjumps;
			}
			System.out.println("Case " + t + ": " + highjumps + " " + lowjumps);
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
