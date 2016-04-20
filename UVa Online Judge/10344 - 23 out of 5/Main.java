import java.util.*;
import java.io.*;

public class Main {
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int[] tuple = new int[5];
	private static boolean[] open;
	private static String result;

	public static void main(String[] args) throws Exception {
		StringBuilder answer = new StringBuilder();
		tuple[0] = readInt(); tuple[1] = readInt(); tuple[2] = readInt(); tuple[3] = readInt(); tuple[4] = readInt();
		int t = 1;
		while (true) {
			if (tuple[0] == 0 && tuple[1] == 0 && tuple[2] == 0 && tuple[3] == 0 && tuple[4] == 0) break;
			open = new boolean[5];
			result = "Impossible";
			for (int i = 0; i < 5; ++i) {
				open[i] = true;
				boolean k = solve(tuple[i], 1);
				open[i] = false;
				if (k) {
					result = "Possible";
					break;
				}
			}
			if (t == 1) answer.append(result);
			else answer.append("\n" + result);
			tuple[0] = readInt(); tuple[1] = readInt(); tuple[2] = readInt(); tuple[3] = readInt(); tuple[4] = readInt();
			++t;
		}
		System.out.println(answer.toString());
	}

	private static boolean solve(int n, int steps) {
		if (steps == 5) {
			if (n == 23) return true;
			return false;
		}
		for (int i = 0; i < 5; ++i) {
			if (!open[i]) {
				open[i] = true;
				if (solve(n+tuple[i], steps+1)) {
					return true;
				}
				if (solve(n-tuple[i], steps+1)) {
					return true;
				}
				if (solve(n*tuple[i], steps+1)) {
					return true;
				}
				open[i] = false;
			}
		}
		return false;
	}

	private static String readString() throws Exception {
		while (!st.hasMoreTokens()) st = new StringTokenizer(stdin.readLine());
		return st.nextToken();
	}

	private static int readInt() throws Exception {
		return Integer.parseInt(readString());
	}
}
