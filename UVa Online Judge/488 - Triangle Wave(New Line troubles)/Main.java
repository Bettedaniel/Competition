import java.util.*;
import java.io.*;

public class Main {
	
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static String result;

	public static void main(String[] args) throws Exception {
		int tc = readInt();
		int through = 0;
		for (int _ = 0; _ < tc; ++_) {
			int a = readInt();
			int f = readInt();
			if (a != 0) {
				solve(a);
				for (int i = 0; i < f; ++i) {
					if (result != "") System.out.println(result);
					if (f-1 != i || _ != tc-1) System.out.println();
				}
			}
		}
	}

	private static void solve(int a) {
		String s = "";
		for (int i = 0; i <= a; ++i) {
			for (int j = 0; j < i; ++j) {
				s += "" + i;
			}
			if (i != 0) s += "\n";
		}
		for (int i = a-1; i >= 1; --i) {
			for (int j = 0; j < i; ++j) {
				s += "" + i;
			}
			if (i != 1) s += "\n";
		}
		result = s;
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
