import java.util.*;
import java.io.*;

public class Main {
	
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st = new StringTokenizer("");
	private static int n, m;
	private static ArrayList<Integer>[] graph;

	public static void main(String[] args) throws Exception {
		int testcases = readInt();
		for (int _ = 1; _ <= testcases; ++_) {
			n = readInt();
			m = readInt();
			graph = new ArrayList[n];
			for (int i = 0; i < n; ++i) graph[i] = new ArrayList<Integer>();
			for (int i = 0; i < m; ++i) {
				for (int j = 16; j < m + n + 1; ++j) {
					int on = readInt();
					if (on == 1) {
						graph[i].add(j);
					}
				}
			}
					
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
